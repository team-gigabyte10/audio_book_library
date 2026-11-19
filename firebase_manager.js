const { initializeApp } = require('./ReactFrontend/node_modules/firebase/app');
const {
  getFirestore,
  doc,
  getDoc,
  setDoc,
  updateDoc,
  collection,
  getDocs
} = require('./ReactFrontend/node_modules/firebase/firestore');

const firebaseConfig = {
  apiKey: "AIzaSyC0sUtQ-SsE-IazJNg9AwP-JmQ_xJMR1iY",
  authDomain: "book-store-bec15.firebaseapp.com",
  projectId: "book-store-bec15"
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

function getCurrentFormattedDate() {
  const d = new Date();
  const pad = (n) => String(n).padStart(2, '0');
  return `${d.getFullYear()}-${pad(d.getMonth() + 1)}-${pad(d.getDate())} ${pad(d.getHours())}:${pad(d.getMinutes())}:${pad(d.getSeconds())}`;
}

function normalizeBundle(code) {
  const clean = code.trim().toLowerCase();
  if (clean === 'mega' || clean === 'mega_bundle' || clean === 'all') return 'mega_bundle';
  if (clean === 'audiobook' || clean === 'audiobook_bundle' || clean === 'books') return 'audiobook_bundle';
  if (clean.includes('quran') || clean === 'qr') return 'quran_course';
  if (clean.includes('regional') || clean === 'bd') return 'regional_course';
  if (clean.includes('japan') || clean === 'jp') return 'japanese_course';
  if (clean.includes('chinese') || clean === 'zh' || clean === 'china') return 'chinese_course';
  if (clean.includes('german') || clean === 'de') return 'german_course';
  if (clean.includes('arabic') || clean === 'ar') return 'arabic_course';
  if (clean.includes('korean') || clean === 'ko') return 'korean_course';
  if (clean.includes('urdu') || clean === 'ur') return 'urdu_course';
  if (clean.includes('hindi') || clean === 'hi') return 'hindi_course';
  if (clean.includes('english') || clean === 'en') return 'english_course';
  return clean;
}

async function getPolicy() {
  const ref = doc(db, 'settings', 'course_config');
  const snap = await getDoc(ref);
  if (!snap.exists()) {
    console.log('❌ settings/course_config does not exist yet.');
  } else {
    console.log('✅ settings/course_config:', JSON.stringify(snap.data(), null, 2));
  }
}

async function setPolicy(mode = 'ad_and_paid', hours = 24, adminEmail = 'admin@audiobook.com') {
  const isPaidOnly = mode.toLowerCase() === 'paid_only';
  const data = {
    unlockMode: isPaidOnly ? 'paid_only' : 'ad_and_paid',
    allowRewardedAdUnlock: !isPaidOnly,
    rewardUnlockHours: parseInt(hours, 10) || 24,
    freePreviewPartCount: 1,
    updatedAt: getCurrentFormattedDate(),
    updatedBy: adminEmail
  };

  const ref = doc(db, 'settings', 'course_config');
  await setDoc(ref, data, { merge: true });
  console.log(`✅ Course Unlock Policy updated successfully to: ${data.unlockMode}`);
  console.log(JSON.stringify(data, null, 2));
}

async function listUsers() {
  const snap = await getDocs(collection(db, 'users'));
  console.log(`\n📋 Total Users: ${snap.size}\n` + '='.repeat(60));
  snap.forEach(d => {
    const u = d.data();
    console.log(`Email   : ${d.id}`);
    console.log(`Name    : ${u.name || '(No Name)'}`);
    console.log(`Status  : ${u.status || 'trial'}`);
    console.log(`Role    : ${u.role || 'customer'} (isAdmin: ${u.isAdmin === true})`);
    console.log(`Bundles : ${JSON.stringify(u.unlockedBundles || [])}`);
    console.log('-'.repeat(60));
  });
}

async function getUser(email) {
  const cleanEmail = email.trim().toLowerCase();
  const ref = doc(db, 'users', cleanEmail);
  const snap = await getDoc(ref);
  if (!snap.exists()) {
    console.log(`❌ User not found: ${cleanEmail}`);
  } else {
    console.log(`✅ User Details [${cleanEmail}]:\n`, JSON.stringify(snap.data(), null, 2));
  }
}

async function makeAdmin(email) {
  const cleanEmail = email.trim().toLowerCase();
  const ref = doc(db, 'users', cleanEmail);
  const snap = await getDoc(ref);
  if (!snap.exists()) {
    console.log(`❌ User not found: ${cleanEmail}`);
    return;
  }
  await updateDoc(ref, {
    role: 'admin',
    isAdmin: true,
    lastLoginAt: getCurrentFormattedDate()
  });
  console.log(`🎉 User ${cleanEmail} is now an ADMIN (role: "admin", isAdmin: true)`);
}

async function grantCourses(email, coursesStr) {
  const cleanEmail = email.trim().toLowerCase();
  const ref = doc(db, 'users', cleanEmail);
  const snap = await getDoc(ref);
  if (!snap.exists()) {
    console.log(`❌ User not found: ${cleanEmail}`);
    return;
  }
  const u = snap.data();
  const currentBundles = new Set(u.unlockedBundles || []);
  const toAdd = coursesStr.split(',').map(s => normalizeBundle(s.trim()));
  
  if (toAdd.includes('mega_bundle')) {
    ['audiobook_bundle', 'english_course', 'japanese_course', 'chinese_course',
     'german_course', 'arabic_course', 'korean_course', 'urdu_course',
     'hindi_course', 'quran_course', 'regional_course', 'mega_bundle'
    ].forEach(b => currentBundles.add(b));
  } else {
    toAdd.forEach(b => currentBundles.add(b));
  }

  await updateDoc(ref, {
    status: 'paid',
    unlockedBundles: Array.from(currentBundles),
    lastLoginAt: getCurrentFormattedDate()
  });
  console.log(`🎉 Granted courses to ${cleanEmail}: ${JSON.stringify(Array.from(currentBundles))}`);
}

async function revokeCourses(email, coursesStr) {
  const cleanEmail = email.trim().toLowerCase();
  const ref = doc(db, 'users', cleanEmail);
  const snap = await getDoc(ref);
  if (!snap.exists()) {
    console.log(`❌ User not found: ${cleanEmail}`);
    return;
  }
  const u = snap.data();
  const currentBundles = new Set(u.unlockedBundles || []);
  const toRemove = coursesStr.split(',').map(s => normalizeBundle(s.trim()));
  toRemove.forEach(b => currentBundles.delete(b));

  await updateDoc(ref, {
    unlockedBundles: Array.from(currentBundles),
    lastLoginAt: getCurrentFormattedDate()
  });
  console.log(`Updated bundles for ${cleanEmail}: ${JSON.stringify(Array.from(currentBundles))}`);
}

async function setTrial(email) {
  const cleanEmail = email.trim().toLowerCase();
  const ref = doc(db, 'users', cleanEmail);
  const snap = await getDoc(ref);
  if (!snap.exists()) {
    console.log(`❌ User not found: ${cleanEmail}`);
    return;
  }
  await updateDoc(ref, {
    status: 'trial',
    role: 'customer',
    isAdmin: false,
    unlockedBundles: [],
    lastLoginAt: getCurrentFormattedDate()
  });
  console.log(`🔒 User ${cleanEmail} has been set to TRIAL (status: "trial", role: "customer", isAdmin: false, unlockedBundles: [])`);
}

async function main() {
  const [,, cmd, arg1, arg2, arg3] = process.argv;
  try {
    switch (cmd) {
      case 'init-policy':
        await setPolicy('ad_and_paid', 24, arg1 || 'admin');
        break;
      case 'set-policy':
        await setPolicy(arg1 || 'ad_and_paid', arg2 || 24, arg3 || 'admin');
        break;
      case 'get-policy':
        await getPolicy();
        break;
      case 'list-users':
        await listUsers();
        break;
      case 'get-user':
        if (!arg1) console.log('Usage: node firebase_manager.js get-user <email>');
        else await getUser(arg1);
        break;
      case 'make-admin':
        if (!arg1) console.log('Usage: node firebase_manager.js make-admin <email>');
        else await makeAdmin(arg1);
        break;
      case 'grant-courses':
        if (!arg1 || !arg2) console.log('Usage: node firebase_manager.js grant-courses <email> <courses>');
        else await grantCourses(arg1, arg2);
        break;
      case 'revoke-courses':
        if (!arg1 || !arg2) console.log('Usage: node firebase_manager.js revoke-courses <email> <courses>');
        else await revokeCourses(arg1, arg2);
        break;
      case 'set-trial':
        if (!arg1) console.log('Usage: node firebase_manager.js set-trial <email>');
        else await setTrial(arg1);
        break;
      default:
        console.log(`
Firebase Management CLI
Commands:
  node firebase_manager.js init-policy
  node firebase_manager.js set-policy <ad_and_paid|paid_only> [rewardHours] [adminEmail]
  node firebase_manager.js get-policy
  node firebase_manager.js list-users
  node firebase_manager.js get-user <email>
  node firebase_manager.js make-admin <email>
  node firebase_manager.js grant-courses <email> <english,japanese|mega_bundle>
  node firebase_manager.js revoke-courses <email> <english,japanese>
  node firebase_manager.js set-trial <email>
        `);
    }
  } catch (err) {
    console.error('Error executing query:', err);
  } finally {
    process.exit(0);
  }
}

main();
