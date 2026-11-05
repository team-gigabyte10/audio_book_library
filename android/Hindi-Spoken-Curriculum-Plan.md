# Spoken Hindi Curriculum Plan: Zero to Advanced (for Bangla Speakers)

This plan is for a spoken Hindi course (**হিন্দি স্পোকেন কোর্স**). The base language is Bangla. The plan covers the language curriculum (levels, units, lesson design, assessment, and content data) as well as the Android learning module integration (`com.gigabyte.bookstore.learning`). It does not alter the existing English, Japanese, or Urdu courses (see section 9).

Hindi has no single global exam like JLPT, so this plan follows the **CEFR** levels (**Pre-A1 Stage 0 → A1 → A2 → B1 → B2 → C1 → C2 + Specialist Tracks**), aligned with Central Hindi Directorate (*Kendriya Hindi निदेशालय*) proficiency standards and CEFR "can-do" speaking goals.

---

## 1. Principles

1. **Speaking first.** Every lesson ends with the learner speaking aloud. Reading Devanagari supports speaking and real-world navigation (signs, menus, hospitals, railway stations, chat); handwriting is optional.
2. **Leverage what Bangla already gives.** Bangla and Hindi are sister Indo-Aryan languages. Both use **SOV** (Subject–Object–Verb) word order, postpositions, dative subjects (`मुझे ठंड लग रही है` = আমার ঠান্ডা লাগছে), conjunctive participles (`खा कर` = খেয়ে), and compound verbs (`कर देना` = করে দেওয়া). Moreover, Devanagari consonant groups (*क-वर्ग* to *प-वर्ग*) map 1-to-1 to the Bangla alphabet (ক-বর্গ থেকে প-বর্গ).
3. **Fix the Bangla-speaker blind spots early.** Because Hindi and Bangla are so close, Bangla speakers often transfer Bangla habits into Hindi. The course drills the 6 biggest differences from Stage 0 and A1:
   - **Schwa deletion & flat अ:** Hindi `अ` is a central/flat sound (not rounded Bangla `অ`), and silent at the end of words (`कमल` = *kamal* কমল্, not কমলঅ).
   - **`ब` (b) vs `व` (v/w):** Bangla merges both into `ব`, whereas Hindi contrasts `वात` (wind) and `बात` (matter).
   - **`स` (s) vs `श / ष` (sh):** Bangla pronounces most sibilants as `শ`, whereas Hindi strictly separates dental `स` (`साल` year) from palatal `श` (`शाल` shawl).
   - **Grammatical gender:** Every Hindi noun is masculine (`পুং`) or feminine (`স্ত্রী`), and adjectives, possessive postpositions (`का / की / के`), and verbs (`जाता / जाती`) agree with gender.
   - **The ergative marker `ने` (*ne*) in the past:** Transitive verbs in the past tense take `ने` after the subject and agree with the **object** (`मैंने रोटी खाई`, `मैंने आम खाया`).
   - **Bangla–Hindi "False Friends" (*সমান দেখতে কিন্তু ভিন্ন অর্থ*):** Shared Sanskrit words whose meanings shifted between Bangla and Hindi (`कमरा` = room, `संदेश` = message, `अभिमान` = arrogance, `अवसर` = opportunity).
4. **Script and sound together.** The learner reads Devanagari from Stage 0. A Bangla-script phonetic hint (`bn_pron`) guides pronunciation at the start and fades out by level (decision 11.1).
5. **Repeat with change (6-way transformation drill).** Every core sentence pattern is drilled across 6 forms (section 4): affirmative, negative, past/future, question, respect switch (`आप / तुम`), and speaker gender switch (`m / f`).
6. **Real life of a Bangladeshi learner.** Examples reflect authentic scenarios: travel and medical visits in India (Kolkata, Delhi, Vellore, Chennai, Mumbai), cross-border trade and business, Gulf/overseas workplace communication, hospitality, and South Asian media.
7. **On-device audio only.** All audio uses the phone's offline Text-to-Speech engine (`hi-IN`). No external MP3 files are bundled.
8. **Native review before release.** Every item is checked by a native Hindi reviewer and a Bangla reviewer before its status is set to `reviewed` (section 8).

---

## 2. Level Framework

| Level | CEFR | Active Words | Grammar Points | Guided Hours | Units / Lessons |
|---|---|---|---|---|---|
| **Stage 0** | Pre-A1 | ~250 | ~8 | 25–35 | 10 units / 45 lessons |
| **A1** | A1 | ~800 | ~35 | 60–80 | 15 units / 60 lessons |
| **A2** | A2 | ~1,500 | ~35 | 90–110 | 15 units / 60 lessons |
| **B1** | B1 | ~2,500 | ~40 | 140–170 | 16 units / 70 lessons |
| **B2** | B2 | ~4,000 | ~40 | 190–230 | 16 units / 70 lessons |
| **C1** | C1 | ~6,000 | ~30 | 240–290 | 16 units / 70 lessons |
| **Advanced** | C2 + Tracks | 8,000+ | — | per track | 7 tracks × 10–20 lessons |

*Note:* Guided hours are lower than Japanese (and slightly lower than Urdu Stage 0) because Devanagari is strictly left-to-right, non-cursive, and follows the exact *varga* (বর্গ) alphabetical order that Bangla speakers learned in school.

### Speaking Goal per Level (Can-Do)

| Level | The learner can… |
|---|---|
| **Stage 0** | Read any Devanagari word aloud with correct schwa deletion. Pronounce `व`, `स/श`, and nuqta sounds (`ज़, फ़`) clearly. Greet, thank, count to 20, and use `आप / तुम / तू` appropriately. |
| **A1** | Introduce themselves and their family. Ask and answer simple questions about daily routines, shopping, prices, time, food, and places. Use correct masculine/feminine agreement on common nouns, adjectives, and present/future verbs. |
| **A2** | Talk about past events and future plans. Use `ने` (*ne*) accurately with transitive past verbs. Ask for directions, describe symptoms to a doctor at a hospital, book hotels/trains, and handle workplace basics. |
| **B1** | Narrate a story, express opinions with reasons, make polite complaints, handle phone calls, use conditional (`अगर…तो`) and relative (`जो…वह`) clauses naturally, and read Hinglish chat messages. |
| **B2** | Participate in business meetings and job interviews, deliver a structured presentation, switch between everyday spoken Hindi and formal *Shuddh Hindi*, and follow Hindi news and films. |
| **C1** | Speak with native-like idiomatic fluency: use *muhavare* (idioms), *lokoktiyan* (proverbs), humor, formal debate, and recite/interpret classic and modern Hindi poetry. |
| **C2 / Tracks** | Use Hindi professionally in specialized domains: India travel & medical tourism, cross-border trade, Gulf workplace, media/Bollywood, official *Rajbhasha*, or Bangla ↔ Hindi interpreting. |

---

## 3. Curriculum Sequence

### Stage 0 — Zero Start (Pre-A1): Sounds, Devanagari Script & Oral Reflex

**Stage 0 has 10 units and 45 lessons (25–35 guided hours).**

| Unit | Content | Lessons | Speaking Task at the End |
|---|---|---|---|
| **0.1** | Flat `अ`, schwa deletion (inherent vowel drop), and short/long vowels (`अ–औ`) | 4 | Say 10 short/long pairs (`कम/काम`, `दिन/दीन`) and 10 schwa-drop words (`कमल, नमक`) |
| **0.2** | Vowel signs (*Matras* `ा ि ी ु ू ृ े ै ो औ`) and nasalization (`ं अनुस्वार` vs `ँ चंद्रबिंदु` vs `ः`) | 5 | Read 20 matra + nasal words aloud (`माँ, मैं, हैं, हाँ, आँख, हिंदी`) |
| **0.3** | Velar & Palatal rows: `क ख ग घ ङ` and `च छ ज झ ञ` (1-to-1 with ক-বর্গ ও চ-বর্গ) | 5 | Read 20 everyday words aloud |
| **0.4** | Retroflex & Dental rows: `ट ठ ड ढ ण` (plus flaps `ड़ ढ़`) and `त थ द ध न` (ট-বর্গ ও ত-বর্গ) | 5 | Read 20 words aloud; contrast `ड/ड़` and `ढ/ढ़` |
| **0.5** | Labial & Semivowel/Sibilant rows: `प फ ब भ म`, `य र ल व`, `श ष स ह` | 5 | Read 25 words aloud; contrast `ब/व` and `स/श` |
| **0.6** | Conjunct consonants (*Samyuktakshar* `क्ष त्र ज्ञ श्र`), half-letters (`क् त् स्`), and `र` forms (`प्र, क्र, र्प, ट्र`) | 5 | Read 20 conjunct words (`नमस्ते, अच्छा, प्यार, क्या, ट्रेन, धर्म`) |
| **0.7** | Nuqta letters (`क़ ख़ ग़ ज़ फ़`) and high-impact minimal pairs for Bangla speakers | 4 | Say 10 minimal pairs without error (`साल/शाल`, `बात/वात`, `राज/राज़`, `फल/फ़ोन`) |
| **0.8** | Shared Bangla–Hindi words, **False Friends** (*সাবধান শব্দ*), and numbers 1–20 | 4 | Say 20 shared words, explain 10 false friends, and count 1–20 |
| **0.9** | Survival phrases and the 3 respect levels (`आप / तुम / तू`) | 5 | 1-minute greeting and introduction role-play |
| **0.10** | Fluency drills, tongue twisters, and Stage 0 speaking test | 3 | Stage 0 speaking test |

#### How Every Script & Sound Lesson Works (7-Step Sound Practice Loop)

1. **Hear** the letter or word 3 times (slow `0.8x` → normal `1.0x`).
2. **See** the Devanagari character, its Bangla equivalent (`ক = क`), and a Bangla mouth-position tip.
3. **Say** it 3 times after the model voice.
4. **5 practice words** using only letters learned so far, starting with words familiar to Bangla speakers (`कमल, नाम, घर, पानी, चाय`).
5. **Near-sound contrast** where Bangla speakers typically slip (`स` vs `श`, `ब` vs `व`, `ज` vs `ज़`, `अ` vs `आ`).
6. **Speed ladder** at `0.8x → 0.9x → 1.0x → 1.15x`.
7. **Recall:** see the Bangla meaning and speak the Hindi word aloud before the answer plays.

#### Pronunciation Rules Specifically for Bangla Speakers

| Point | Hindi | Bangla Habit | What to Do in Hindi |
|---|---|---|---|
| **Inherent `अ` (Schwa)** | `कमल` (*kamal*), `सफ़र` (*safar*) | Bangla `অ` is rounded (`কমোল`, `সফর`) | Keep `अ` flat and unrounded (like a very short `আ`). Drop `अ` completely at the end of a word: `कमल` = `কমল্`, never `কমলঅ`. |
| **Medial Schwa Drop** | `समझना` (*samajhnā*), `कमरा` (*kamrā*) | Pronounced with full vowels in every syllable | In 3–4 syllable words, the second vowel drops when followed by a long vowel: `कमरा` = `কম্‌রা`, `समझना` = `সমঝ্‌না`. |
| **`व` vs `ब`** | `वात` (wind) vs `बात` (talk) | Both read as `ব` | For `व`, touch the upper teeth lightly to the lower lip (or round lips slightly without closing them fully): `वह` = *vah/woh*, `पानी` vs `वाणी`. |
| **`स` vs `श / ष`** | `साल` (year) vs `शाल` (shawl) | Both often pronounced `শ` | Keep `स` a crisp dental "s" (`স`). Use palatal "sh" (`শ`) only for `श` and `ष`. |
| **`ज़` (z) & `फ़` (f)** | `ज़मीन` (land), `फ़ोन` (phone), `साफ़` (clean) | Said as `জ` and aspirated `ফ` | Buzz the teeth for `ज़` (`জ়`) and touch top teeth to lower lip for `फ़` (`ফ়`), distinct from aspirated `फ` (`फल` fruit). |
| **Nasal `ं` vs `ँ`** | `हूँ, हाँ, माँ, मैं, हैं` | Bangla has `ং` and `ঁ` | `ँ` (*chandrabindu*) nasalizes the vowel itself (`माँ` = মাঁ). `मैं` = `ম্যাঁয়`, `हैं` = `হ্যাঁয়`, `है` = `হ্যায়` (not `হে`). |
| **`ड़` and `ढ़`** | `बड़ा` (big), `पढ़ना` (to study) | Same as Bangla `ড়` and `ঢ়` | Direct match! Bangla speakers already master retroflex flaps better than most learners. |
| **Dental vs Retroflex + Aspiration** | `त थ द ध` vs `ट ठ ड ढ`; `क ख ग घ` | Exact 1-to-1 match with ত থ দ ধ, ট ঠ ড ঢ, ক খ গ ঘ | Huge natural advantage for Bangla speakers—all 4-way stop contrasts (voiceless, aspirated, voiced, voiced aspirated) are identical. |

#### Unit 0.8 Highlight — Bangla–Hindi "False Friends" (*সমান শব্দ কিন্তু ভিন্ন অর্থ*)

Bangla speakers must learn early which shared Sanskrit words have different everyday meanings in Hindi:

| Hindi Word | Hindi Meaning (Bangla) | What It Means in Bangla (Trap!) | Example Sentence in Hindi |
|---|---|---|---|
| **कमरा** (*kamrā*) | ঘর / রুম (Room) | কামরা (ট্রেনের বগি) | यह मेरा कमरा है। (এটা আমার ঘর।) |
| **संदेश** (*sandesh*) | বার্তা / খবর (Message) | সন্দেশ (মিষ্টি) | आपके लिए एक संदेश है। (আপনার জন্য একটি বার্তা আছে।) |
| **अभिमान** (*abhimān*) | অহংকার / গর্ব (Pride/Arrogance) | অভিমান (প্রিয়জনের ওপর রাগ) | उसे अपने पैसे का अभिमान है। (তার নিজের টাকার অহংকার আছে।) |
| **अवसर** (*avsar*) | সুযোগ (Opportunity) | অবসর (ছুটি বা রিটায়ারমেন্ট) | यह एक अच्छा अवसर है। (এটি একটি ভালো সুযোগ।) |
| **व्यवहार** (*vyavahār*) | আচরণ (Behavior) | ব্যবহার (কোনো জিনিস কাজে লাগানো = `इस्तेमाल / उपयोग`) | उनका व्यवहार बहुत अच्छा है। (তাঁর আচরণ খুব ভালো।) |
| **चेष्टा / कोशिश** | চেষ্টা (`कोशिश` is natural in speech; `चेष्टा` is formal/literary) | চেষ্টা (সাধারণ কথা) | मैं पूरी कोशिश करूँगा। (আমি পুরো চেষ্টা করব।) |
| **आराम** (*ārām*) | বিশ্রাম বা আরাম (Rest / Comfort) | আরাম (শুধু স্বস্তি) | थोड़ा आराम कीजिए। (একটু বিশ্রাম নিন।) |

#### Unit 0.9 — Survival Phrases & Respect Levels (`आप / तुम / तू`)

| Hindi | Bangla Sound Hint (`bn_pron`) | Bangla Meaning (`bn`) |
|---|---|---|
| नमस्ते / नमस्कार। | নমস্তে / নমস্কার | নমস্কার / হ্যালো। |
| आप कैसे हैं? / आप कैसी हैं? | আপ ক্যায়সে হ্যাঁয়? / আপ ক্যায়সি হ্যাঁয়? | আপনি কেমন আছেন? (পুরুষ / নারী) |
| मैं ठीक हूँ, धन्यवाद / शुक्रिया। | ম্যাঁয় ঠীক হুঁ, ধন্যবাদ / শুক্রিয়া | আমি ভালো আছি, ধন্যবাদ। |
| मेरा नाम रहीम है। | মেরা নাম রহীম হ্যায় | আমার নাম রহিম। |
| मैं बांग्लादेश से हूँ। | ম্যাঁয় বাংলাদেশ সে হুঁ | আমি বাংলাদেশ থেকে এসেছি। |
| हाँ जी / जी नहीं। | হাঁ জী / জী নহীঁ | জি হ্যাঁ / জি না। |
| माफ़ कीजिए। | মাফ় কীজিয়ে | মাফ করবেন / এক্সকিউজ মি। |
| मुझे समझ नहीं आया। | মুঝে সমঝ নহীঁ আয়া | আমি বুঝতে পারিনি। |
| कृपया धीरे बोलिए। | কৃপয়া ধীরে বোলিয়ে | অনুগ্রহ করে আস্তে বলুন। |
| यह कितने का है? | ইয়ে কিতনে কা হ্যায়? | এটার দাম কত? |
| फिर मिलेंगे। | ফির মিলেঙ্গে | আবার দেখা হবে। |

**Respect Levels:** `आप` = আপনি (`آइए / बोलिए`), `तुम` = তুমি (`आओ / बोलो`), `तू` = তুই (`आ / बोल`). Because Bangla has the exact same 3-tier pronoun and verb-ending system, learners grasp this immediately.

---

### Level A1 — Beginner (Foundations & Daily Life)

**15 units, 60 lessons (~750–900 spoken items).**

| Unit | Topic | Key Grammar | Speaking Task |
|---|---|---|---|
| **1.1** | Self-Introduction & Identity | `हूँ / है / हैं`, `मैं / आप / तुम / यह / वह` | मेरा नाम रहीम है। मैं ढाका से हूँ। |
| **1.2** | Things, Ownership & Gender | Noun gender (`m/f`), `का / की / के` (`मेरा कमरा / मेरी किताब / मेरे दोस्त`) | यह मेरी किताब है। वह मेरा बैग है। |
| **1.3** | Family & Plurals | Masculine & feminine plurals (`लड़का → लड़के, लड़की → लड़कियाँ, किताब → किताबें`) | मेरे दो भाई और एक बहन हैं। |
| **1.4** | Describing People & Objects | Adjective agreement (`अच्छा / अच्छी / अच्छे`, `बड़ा / बड़ी / बड़े` vs invariable `साफ़, सुंदर`) | कमरा बड़ा है। चाय बहुत अच्छी है। |
| **1.5** | Places, Existence & Oblique Case | Postpositions `में, पर, से, तक, के पास, के सामने` + Oblique singular (`कमरा → कमरे में`) | मेज़ पर किताब है। मेरे घर के पास बाज़ार है। |
| **1.6** | Numbers, Time & Dates | `कितने बजे हैं?`, `सवा / साढ़े / पौने`, days of the week | अभी साढ़े आठ बजे हैं। |
| **1.7** | Daily Routine (Present Habitual) | `ता हूँ / ती हूँ / ते हैं / ते हो` | मैं रोज़ सुबह सात बजे उठता/उठती हूँ। |
| **1.8** | Essential WH-Questions | `क्या, कौन, कहाँ, कब, क्यों, कैसे, कितना/कितनी/कितने, किसका` | आप कहाँ रहते हैं? आपका काम क्या है? |
| **1.9** | Likes, Dislikes & Preferences | `मुझे … पसंद है / अच्छा लगता है / अच्छी लगती है` | मुझे मसाला चाय बहुत पसंद है। |
| **1.10** | Polite Requests & Commands | Imperatives across tiers (`तू कर / तुम करो / आप कीजिए / कृपया बताइए`) | कृपया मुझे पानी दीजिए। |
| **1.11** | Shopping, Prices & Bargaining | `यह कितने का/की है?`, numbers 21–100, counters & weights (`किलो, दर्जन`) | भैया, यह शर्ट कितने की है? थोड़ा कम कीजिए। |
| **1.12** | Actions Happening Now | Present continuous: `रहा हूँ / रही हूँ / रहे हैं` | मैं अभी हिंदी सीख रहा/रही हूँ। |
| **1.13** | Skills & Ability | `सकना` (can do) vs `आना` (know how to: `मुझे हिंदी बोलनी आती है / तैरना आता है`) | मैं थोड़ा हिंदी बोल सकता/सकती हूँ। |
| **1.14** | Future Plans | Future tense: `ऊँगा / ऊँगी / एगा / एगी / एँगे` | मैं कल कोलकाता जाऊँगा/जाऊँगी। |
| **1.15** | A1 Master Review | All A1 grammar & situational role-plays | A1 Speaking Test |

---

### Level A2 — Elementary (Past, Ergative `ने`, Travel & Healthcare)

**15 units, 60 lessons.**

| Unit | Topic | Key Grammar | Speaking Task |
|---|---|---|---|
| **2.1** | Yesterday & Past States | `था / थी / थे / थीं` & Past of intransitive verbs (`गया / गई / गए / आया / बैठा`) | मैं कल बाज़ार गया था / गई थी। |
| **2.2** | What I Did (`ने` Ergative Construction) | **Subject + `ने` + Object-agreed verb** (`मैंने खाना खाया, मैंने चाय पी, उसने किताबें पढ़ीं`) | मैंने सुबह नाश्ता किया और चाय पी। |
| **2.3** | Past Habits & Ongoing Past | `ता था / ती थी` (used to) and `रहा था / रही थी` (was doing) | मैं पहले चटगाँव में रहता था। |
| **2.4** | Wants & Needs | `चाहिए` (need: `मुझे पानी चाहिए`) vs `चाहना` (`मैं जाना चाहता हूँ`) | मुझे एक टिकट चाहिए। |
| **2.5** | Obligation & Compulsion | `मुझे जाना है` (have to), `जाना पड़ता है` (must/forced to), `जाना चाहिए` (should) | मुझे कल सुबह जल्दी उठना है। |
| **2.6** | Comparisons & Superlatives | `से ज़्यादा / से कम / से अच्छा`, `सबसे अच्छा` | यह होटल उस होटल से सस्ता और अच्छा है। |
| **2.7** | Navigating Cities & Transport | Directions (`सीधा, दाएँ, बाएँ, मुड़ना`), train/metro/auto-rickshaw dialogues | भैया, स्टेशन जाने के लिए कहाँ से मेट्रो मिलेगी? |
| **2.8** | At the Hospital & Pharmacy | Body parts, symptoms (`मेरे पेट में दर्द है, मुझे बुखार है, चक्कर आ रहा है`) | डॉक्टर साहब, मुझे दो दिन से बुखार है। |
| **2.9** | Phone Calls & Appointments | `कौन बोल रहा है?`, scheduling & polite inquiries | क्या कल शाम को डॉक्टर से मिलना हो सकता है? |
| **2.10** | Life Experiences | Present perfect (`देखा है, गया हूँ, खाया है`) & `कभी / कभी नहीं` | मैं दो बार भारत गया हूँ। |
| **2.11** | Suggestions & Subjunctive | Subjunctive mood (`चलें?, क्या मैं अंदर आऊँ?, शायद बारिश हो`) | चलिए, कहीं बैठकर चाय पीते हैं। |
| **2.12** | Compound Verbs (*रंजक क्रियाएँ*) | Nuance verbs: `कर देना, ले लेना, खा लेना, बैठ जाना, रख देना` | यह फ़ॉर्म भर दीजिए। |
| **2.13** | Sequencing Actions | Conjunctive participle `कर / के` (`नहा कर, खाना खा के`) | मैं हाथ धोकर खाना खाता हूँ। |
| **2.14** | Workplace & Service Interactions | Asking for leave, explaining tasks, talking to colleagues | सर, मुझे कल एक दिन की छुट्टी चाहिए। |
| **2.15** | A2 Master Review | All A2 patterns & role-plays | A2 Speaking Test |

---

### Level B1 — Intermediate (Connected Speech, Clauses & Opinions)

**16 units, 70 lessons.**

| Unit | Topic | Key Grammar & Skills | Speaking Task |
|---|---|---|---|
| **3.1** | Conditionals | `अगर / यदि … तो` (real, habitual, and counterfactual `होता तो करता`) | अगर बारिश हुई तो हम घर पर रहेंगे। |
| **3.2** | Relative–Correlative Clauses | `जो … वह, जहाँ … वहाँ, जब … तब, जितना … उतना, जैसा … वैसा` (exact match to যে…সে, যেখানে…সেখানে!) | जो आदमी वहाँ खड़ा है, वह मेरा दोस्त है। |
| **3.3** | Indirect & Reported Speech | `उसने कहा कि…`, `पूछा कि…`, `बताया कि…` | डॉक्टर ने कहा कि तीन दिन आराम करो। |
| **3.4** | Passive Voice | `किया जाता है / किया गया / बोला जाता है` & inability passive (`मुझसे चला नहीं जाता`) | यहाँ हिंदी और अंग्रेज़ी दोनों बोली जाती हैं। |
| **3.5** | Causative Verbs (*प्रेरणार्थक क्रिया*) | 3-tier verb families: `बनना → बनाना → बनवाना`, `करना → कराना → करवाना`, `पढ़ना → पढ़ाना → पढ़वाना` | मैंने अपनी गाड़ी ठीक करवाई। |
| **3.6** | Presumptive & Guessing | `होगा / रही होगी / गया होगा` (must be / probably did) | वह अब तक घर पहुँच गया होगा। |
| **3.7** | Storytelling & Narration | Discourse markers (`फिर, उसके बाद, अचानक, आख़िरकार, दरअसल`) | Narrate a 2-minute personal travel story |
| **3.8** | Expressing Opinions | `मेरे ख़्याल से, मेरी राय में, मुझे लगता है कि, क्योंकि, इसलिए` | Give an opinion on a topic with 2 reasons |
| **3.9** | Complaints & Problem Resolution | Polite firmness, hotel/order/billing issues | Resolve a wrong bill or delayed booking |
| **3.10** | Formal Telephone Hindi | Office calls, leaving messages, transferirng calls | Handle a 2-minute business phone call |
| **3.11** | Simultaneous & Durative Actions | `जब तक … तब तक, जैसे ही, करते-करते, सोते हुए, चलते हुए` | जैसे ही ट्रेन रुकी, लोग उतरने लगे। |
| **3.12** | Emotions & Dative Constructions | `लगना, आना, होना` with feelings (`डर लगना, ग़ुस्सा आना, खुशी होना, याद आना`) | मुझे अपने घर की बहुत याद आती है। |
| **3.13** | Reading Hinglish (Roman Hindi) | WhatsApp/SMS Latin-script Hindi conventions (`kya kar rahe ho`, `kal milte hain`) | Read 5 chat messages and reply aloud |
| **3.14** | Everyday Idioms (*मुहावरे 1*) | 20 high-frequency spoken idioms (`हाथ बँटाना, पेट में चूहे कूदना, बात बनाना`) | Use 3 idioms naturally in conversation |
| **3.15** | News & Current Affairs Basics | Core media vocabulary (`सरकार, चुनाव, मौसम, अर्थव्यवस्था`) | Summarize a short news item |
| **3.16** | B1 Master Review | All B1 patterns | B1 Speaking Test |

---

### Level B2 — Upper Intermediate (Professional, Formal *Shuddh Hindi* & Media)

**16 units, 70 lessons.**

| Unit | Topic | Focus | Speaking Task |
|---|---|---|---|
| **4.1** | Spoken Hindustani vs *Shuddh Hindi* | Switching between everyday (`ज़रूरत, इस्तेमाल, कोशिश`) and formal Sanskritized (`आवश्यकता, प्रयोग, प्रयास`) | Say 10 ideas in both casual and formal registers |
| **4.2** | Formal Etiquette & Hospitality | `कृपया पधारिए, आसन ग्रहण कीजिए, आपका हार्दिक स्वागत है, क्षमा प्रार्थी हूँ` | Formally welcome a guest or speaker |
| **4.3** | Sanskrit Prefixes & Word Building | `उप-, अनु-, प्रति-, सह-, अ-, गैर-, बे-` and `-ता, -त्व, -पन` | Build and use 15 abstract nouns in speech |
| **4.4** | Job Interviews | Describing qualifications, strengths, and career goals | 5-minute job interview role-play |
| **4.5** | Workplace Meetings | Agreeing, politely disagreeing (`मैं आपकी बात से सहमत हूँ, परंतु…`), proposing ideas | Lead a short team discussion |
| **4.6** | Structured Presentations | Signposting (`सबसे पहले, इसके अतिरिक्त, निष्कर्ष के रूप में`) | Deliver a 3-minute presentation |
| **4.7** | Business Negotiation | Wholesale/retail trade, terms, discounts, delivery timelines | Negotiate a wholesale order |
| **4.8** | Hindi Cinema, Songs & Drama | Colloquial expressions, emotional register, song lyric comprehension | Discuss a film scene or song meaning |
| **4.9** | Society, Education & Technology | Discussing modern issues with nuance | 2-minute structured talk |
| **4.10** | Advanced Connectors | `यद्यपि … तथापि, हालाँकि … फिर भी, चूँकि, ताकि, इसके बावजूद` | Justify a complex decision |
| **4.11** | Formal Correspondence to Speech | Reading official notices, bank/hospital forms, and emails aloud | Read and verbally summarize an official notice |
| **4.12** | Customer Service & Hospitality | Handling dissatisfied clients with empathy and tact | Customer resolution role-play |
| **4.13** | Debate Foundations | Building arguments, citing examples, polite rebuttal | 3-minute structured debate |
| **4.14** | Indian & South Asian Culture | Festivals (Diwali, Holi, Eid, Durga Puja), cuisine, regional etiquette | Compare festivals across Bangladesh and India |
| **4.15** | Fast Native Speech Shadowing | Reduced vowels, rapid conversational fillers (`मतलब, वैसे, दरअसल, खैर`) | Shadow a 1-minute native-speed dialogue |
| **4.16** | B2 Master Review | All B2 skills | B2 Speaking Test |

---

### Level C1 — Advanced (Idiomatic Mastery, Literature, Rhetoric & Register Shift)

**16 units, 70 lessons.**

| Unit | Topic | Focus | Speaking Task |
|---|---|---|---|
| **5.1** | Advanced Idioms (*मुहावरे 2*) | 30 nuanced idioms (`आसमान सिर पर उठाना, बाल-बाल बचना, पानी-पानी होना`) | Use 5 idioms naturally in a monologue |
| **5.2** | Proverbs (*लोकोक्तियाँ / कहावतें*) | `नाच न जाने आँगन टेढ़ा`, `दूर के ढोल सुहावने लगते हैं`, `बंदर क्या जाने अदरक का स्वाद` | Explain and apply 3 proverbs |
| **5.3** | Persuasive Rhetoric | Rhetorical questions, triads, formal emphasis (`ही तो, तक, मात्र`) | 5-minute persuasive speech |
| **5.4** | Humor, Irony & Wordplay | Light banter, understatement, witty retorts | Tell a humorous anecdote |
| **5.5** | Classic Poetry (*दोहे*) | Kabir, Tulsidas, and Rahim *Dohe* — rhythm, meter, and wisdom | Recite and explain 2 classic *Dohe* |
| **5.6** | Modern Hindi *Kavita* | Harivansh Rai Bachchan, Dinkar, Subhadra Kumari Chauhan | Read a poem aloud with expressive prosody |
| **5.7** | Literary Prose (*कहानी*) | Premchand's narrative Hindi style | Read and analyze a literary excerpt |
| **5.8** | Public Speaking & Anchoring | Stage introductions, votes of thanks (*धन्यवाद ज्ञापन*), formal hosting | Deliver a formal opening & closing address |
| **5.9** | Academic & Technical Hindi | Explaining economics, science, or law in formal Hindi | 3-minute specialist explanation |
| **5.10** | Formal Debate (*वाद-विवाद*) | Live rebuttal, structured counter-arguments | Full debate session |
| **5.11** | Regional Spoken Varieties | Delhi Hindi, Mumbai (*Bambaiya*), UP/Awadhi/Bhojpuri flavor, Kolkata Bazaar Hindi | Recognize 4 regional speech styles |
| **5.12** | The Hindi–Urdu Continuum | Expressing the exact same thought in *Shuddh Hindi*, everyday Hindustani, and Perso-Arabic Urdu style | Translate 5 sentences across all 3 registers |
| **5.13** | Media & Press Interviews | Answering unscripted, challenging questions | Live interview simulation |
| **5.14** | Talk Shows & Panel Discussions | Turn-taking, interrupting politely, summarizing | Summarize a panel debate |
| **5.15** | 3-Way Register Mastery | Casual friend ↔ Corporate client ↔ Formal stage | Retell one incident in 3 distinct registers |
| **5.16** | C1 Master Review | All C1 skills | C1 Speaking Test |

---

### Advanced Tracks (C2 & Specialist Modules)

Built modularly according to learner demand (10–20 lessons per track):

| Track | Content | Lessons |
|---|---|---|
| **T1 India Travel, Medical Tourism & Transit** | Hospitals (Vellore CMC, Apollo Chennai/Kolkata, Delhi AIIMS), doctor consultations, medical reports, pharmacies, Indian Railways (IRCTC), immigration, hotels, shopping | 20 |
| **T2 Cross-Border Business, Trade & Import/Export** | Land ports (Benapole/Petrapole), LC/customs terminology, wholesale markets (Burrabazar, Chandni Chowk, Surat textiles), price & contract negotiation | 15 |
| **T3 Gulf & Overseas Workplace Hindustani** | Construction, hospitality, driving, retail, and supervisor communication where spoken Hindi/Urdu serves as the daily lingua franca | 15 |
| **T4 Bollywood, Music & Pop Culture** | Film dialogues, poetic song vocabulary, web-series slang, and entertainment commentary | 12 |
| **T5 Official / Administrative Hindi (*राजभाषा*)** | Government notices, banking, legal terms, and broadcast journalism | 12 |
| **T6 Interpreting Bangla ↔ Hindi** | Consecutive interpreting, medical/business interpreting, false-friend traps, rapid register switching | 15 |
| **T7 Urdu Script & Vocabulary Bridge** | Connecting Devanagari Hindi to Nastaliq Urdu for learners who want bi-scriptal South Asian fluency | 10 |

---

## 4. Lesson Template (Consistent Across All Levels)

Every lesson (15–20 minutes, 8–14 items) follows the app's audio-ladder and interactive drill flow:

1. **Warm-up (2 min):** Review 3 due items from the spaced-repetition queue.
2. **Listen & Shadow (3 min):** Listen to the lesson's core patterns via the speed ladder (`0.8x` Hindi → `1.15x` Bangla meaning → `0.9x` Hindi → `1.0x` Hindi → `1200ms` pause for learner echo).
3. **New Items (5 min):**
   - **Stage 0:** `letter` / `sound` items → practice `word` items → minimal-pair contrast items.
   - **A1+:** 2–3 `word` items (nouns tagged with `gender: "m"` or `"f"`) → 2–4 `sentence` items with word-by-word `tokens` and postposition/gender glosses.
4. **6-Way Pattern Drill (4 min):** Every A1+ lesson drills one core sentence across 6 transformations:
   1. **Affirmative:** `मैं हर रोज़ हिंदी बोलता हूँ।` *(f: बोलती हूँ)*
   2. **Negative:** `मैं हर रोज़ हिंदी नहीं बोलता हूँ।` *(f: नहीं बोलती हूँ)*
   3. **Yes/No Question:** `क्या आप हर रोज़ हिंदी बोलते हैं?` *(f: बोलती हैं)*
   4. **WH-Question:** `आप कब हिंदी बोलते हैं?`
   5. **Respect Switch (`आप` ↔ `तुम`):** `तुम हर रोज़ हिंदी बोलते हो।` *(f: बोलती हो)*
   6. **Tense / Aspect Switch (or Future from 1.14 / Past `ने` from 2.2):** `मैं कल हिंदी बोलूँगा।` *(f: बोलूँगी)*
5. **Speak / Speech Check (3 min):** See the Bangla prompt, speak the Hindi aloud into the microphone (`SpeechCheckCard` with `hi-IN` speech recognition or self-rating fallback), then hear the model answer.
6. **Role-Play Dialogue (from Unit 1.10, 3 min):** 4 `dialogue_line` items (`speaker: "A"` and `"B"`) using `PairPracticeVoiceCard`.
7. **Lesson Quiz (2 min):** 8–10 auto-generated questions (`QuizGenerator`: audio → Bangla meaning, Bangla → Hindi target, gender agreement choice, postposition choice). Scoring ≥ 70% marks the lesson completed (`DONE`).

---

## 5. Skill Strands & Hard Points for Bangla Speakers

| Strand | Stage 0–A1 | A2–B1 | B2–C1 |
|---|---|---|---|
| **Pronunciation** | Flat `अ`, final & medial schwa deletion, `व/ब`, `स/श`, nuqta `ज़/फ़` | Phrase linking, natural stress, compound verb rhythm | Fast native speech, poetic meter (*Chhand*), formal diction |
| **Gender & Case** | Noun gender (`m/f`), oblique singular (`कमरे में`), `का/की/के`, present/future agreement | Ergative `ने` object agreement, oblique plural (`कमरों में`), past agreement | Effortless agreement across complex relative clauses |
| **Script** | Devanagari vowels, matras, vargas, conjuncts, with Bangla phonetic hint (`bn_pron`) | Reading unassisted Devanagari + Hinglish chat (Unit 3.13) | Fast reading of official forms, news, and literature |
| **Vocabulary** | Shared Bangla–Hindi words + False Friends warning | Daily life, healthcare, travel, workplace verbs | *Shuddh Hindi* (Sanskritized), Hindustani idioms & proverbs |
| **Register** | `आप / तुम / तू` basics | Polite requests, workplace vs casual friend | 3-way switch: Colloquial ↔ *Shuddh Hindi* ↔ Hindustani |

### Grammar Points with Dedicated Contrast Drills for Bangla Speakers

| Point | Why Bangla Speakers Struggle | How the Course Drills It |
|---|---|---|
| **Noun & Verb Gender** | Bangla has zero grammatical gender (`আমি যাই` is identical for male and female) | Every noun displays `পুং` (masculine) or `স্ত্রী` (feminine). Every gender-inflected sentence stores `variant_f` so learners can toggle and hear both male (`जाता हूँ`) and female (`जाती हूँ`) forms. |
| **Oblique Case before Postpositions** | Bangla adds case endings directly (`ঘর → ঘরে`); Hindi changes masculine `-आ` nouns to `-ए` before any postposition (`कमरा → कमरे में`, `लड़का → लड़के को`) | Dedicated A1 drills pairing nominative (`यह बड़ा कमरा है`) with oblique (`इस बड़े कमरे में`). |
| **Ergative `ने` (*ne*) in the Past** | In Bangla (`আমি ভাত খেয়েছি / আমি গিয়েছি`), transitive and intransitive past verbs work the same way. In Hindi, transitive past verbs lock the subject with `ने` and agree with the **object** (`राहुल ने रोटी खाई` — fem. verb!) | 3 full units (2.2, 2.10, 3.7) contrast intransitive (`मैं गया / वह गई`) vs transitive (`मैंने आम खाया / मैंने चाय पी`). |
| **`चाहिए` vs `चाहता हूँ`** | Bangla uses `চাই` for both nouns and verbs | Contrast pairs: Noun + `चाहिए` (`मुझे पानी चाहिए`) vs Verb-infinitive + `चाहता हूँ` (`मैं पानी पीना चाहता हूँ`). |
| **`सकना` vs `आना` for "Can"** | Bangla uses `পারি` for both ability and learned skill (`আমি যেতে পারি` / `আমি সাঁতার কাটতে পারি`) | Contrast pairs: permission/possibility `सकना` (`मैं आज आ सकता हूँ`) vs learned skill `आना` (`मुझे तैरना आता है / मुझे हिंदी आती है`). |

---

## 6. Assessment

| Check | When | Format | Pass Rule |
|---|---|---|---|
| **Lesson Quiz** | End of every lesson | 8–10 multiple-choice & audio questions | ≥ 70% marks the lesson `DONE` (never blocks browsing) |
| **Unit Speaking Task** | End of every unit | Oral prompt checked by `hi-IN` speech recognition or self-rating | Feedback only |
| **Level Speaking Test** | End of Stage 0, A1, A2, B1, B2, C1 | 10 recorded prompts covering the level's "can-do" goals | ≥ 70% unlocks the level completion badge |
| **Gender & `ने` Mastery Check** | End of A1 & A2 | 20 rapid forced-choice agreement items (`का/की/के`, `खाया/खाई`, `गया/गई`) | ≥ 80% accuracy |

---

## 7. Content Data Model & ESCB JSON Schema (`schema_version: 1`)

To work seamlessly with `EscbJsonParser.kt`, `ContentImporter.kt`, and `LessonPlayer.kt`, Hindi course files use the exact same `schema_version: 1` JSON structure as English, Japanese, and Urdu, while authoring unit files in `android/tools/hindi/units/`.

### Authoring Unit Item Format (`tools/hindi/units/*.json`)

```json
{
  "type": "sentence",
  "target": "मैं रोज़ सुबह सात बजे उठता हूँ।",
  "bn": "আমি প্রতিদিন সকাল সাতটায় উঠি।",
  "bn_pron": "ম্যাঁয় রোজ় সুবহ সাত বজে উঠতা হুঁ",
  "variant_f": "मैं रोज़ सुबह सात बजे उठती हूँ।",
  "variant_f_pron": "ম্যাঁয় রোজ় সুবহ সাত বজে উঠতি হুঁ",
  "tokens": [
    {"t": "मैं", "bn": "আমি"},
    {"t": "रोज़", "bn": "প্রতিদিন"},
    {"t": "सुबह", "bn": "সকাল"},
    {"t": "सात बजे", "bn": "সাতটায়"},
    {"t": "उठता", "bn": "উঠি (পুং)"},
    {"t": "हूँ", "bn": "হুঁ · হই/করি (আমি)"}
  ]
}
```

### Compiled Asset Format (`app/src/main/assets/spoken_hindi_standard_a1.json`)

```json
{
  "schema_version": 1,
  "course": {
    "id": "hi-standard-zero-a1",
    "target_lang": "hi",
    "base_lang": "bn",
    "title_bn": "হিন্দি স্ট্যান্ডার্ড কোর্স: শূন্য থেকে A1",
    "title_target": "हिंदी: शून्य से A1",
    "source": "Hindi-Spoken-Curriculum-Plan.md, roadmap phase 1 (Stage 0 + A1)",
    "note": "Draft content. A native Hindi reviewer and a Bangla reviewer must check every item before release.",
    "welcome_text": "হিন্দি স্পোকেন কোর্সে আপনাকে স্বাগতম! প্রতিটি অক্ষর, শব্দ ও বাক্য শুনুন এবং জোরে জোরে বলুন।"
  },
  "ladder_default": [
    { "play": "target", "speed": 0.8 },
    { "play": "bn", "speed": 1.15 },
    { "play": "target", "speed": 0.9 },
    { "play": "target", "speed": 1.0 },
    { "pause_ms": 1200 }
  ],
  "stats": {
    "lessons": 105,
    "items": 1200
  },
  "parts": [ ... ]
}
```

### Field Rules (`tools/hindi/build_hindi_course.py`)

| Field | Required | Rule |
|---|---|---|
| `id` | Auto-generated | Prefix `hi-std-` (e.g. `hi-std-s0-01-l01-001`, `hi-std-a1-07-l02-003`). |
| `type` | Yes | `sound`, `letter`, `word`, `phrase`, `sentence`, `dialogue_line`, `pattern`. |
| `target` | Yes | Standard Devanagari script (`[\u0900-\u097F]`), including proper nuqta where applicable and purna viram (`।`) or `?` / `!`. No Latin or Bangla letters inside `target` so `hi-IN` TTS reads cleanly. |
| `bn` | Yes | Natural Bangla meaning read by the Bangla TTS voice. |
| `bn_pron` | Yes | Bangla-script pronunciation hint showing schwa deletion and nuqta sounds (`ज़` = `জ়`, `फ़` = `ফ়`, `ख़` = `খ়`, `क़` = `ক়`, `ग़` = `ग়`, `ं/ँ` = `ঁ`, `है` = `হ্যায়`, `हैं` = `হ্যাঁয়`). For nouns with `gender`, the build script appends ` · পুং` or ` · স্ত্রী`. |
| `variant_f` | When speaker/listener gender changes the form | Stored into `exampleTarget` (and `variant_f_pron` into `exampleBn`) in the compiled JSON, matching the Urdu speaker-gender swap mechanism! |
| `gender` | For noun `word` items | `"m"` or `"f"`. |
| `tokens` | Yes for `word`, `phrase`, `sentence`, `dialogue_line`, `pattern` | Ordered pieces of `target`. Joining `t` without spaces/punctuation (`।?!,`) must match `target` without spaces/punctuation. |
| `speaker` | `dialogue_line` only | `"A"` or `"B"`. |

---

## 8. Content Production Pipeline

1. **Unit JSON Authoring:** Create per-unit source files in `android/tools/hindi/units/s0-01.json` … `a1-15.json` following `android/tools/hindi/UNIT_FORMAT.md`.
2. **Automated Validation & Build (`android/tools/hindi/build_hindi_course.py`):**
   - Verifies Devanagari Unicode range (`\u0900-\u097F`), rejects stray Latin/Bangla characters in `target`, verifies token concatenation matches `target`, enforces `variant_f` + `variant_f_pron` pairing, and compiles `android/app/src/main/assets/spoken_hindi_standard_a1.json`.
3. **Native Hindi Review:** Checks natural spoken register, gender agreement, ergative `ने`, and nuqta placement.
4. **Bangla Review:** Checks naturalness of `bn` meanings and consistency of `bn_pron` schwa-drop hints.
5. **On-Device TTS Verification:** Test playback at `0.8x` and `1.0x` on Android devices with Google TTS `hi-IN` offline voice.

---

## 9. Isolation & Android App Integration Architecture

The Hindi course must not alter English, Japanese, or Urdu behavior. All changes are additive and scoped by language/ID prefix.

| Rule | Implementation |
|---|---|
| **Separate Content** | Hindi content lives in `app/src/main/assets/spoken_hindi_*.json` (starting with `spoken_hindi_standard_a1.json`). |
| **Separate IDs** | All Hindi part, lesson, and item IDs start with `hi-` (specifically `hi-std-` for the standard course). |
| **Separate Settings** | Speaker gender preference stored under `learn_hi_speaker_gender` in `AppPreferences.kt`. |
| **Separate Route & Card** | Dedicated Home showcase card (`language = "hindi"`, bundle `hindi_course`) and LearnHome filtering. |

### Exact Android Code Touchpoints for Phase 1 Implementation

1. **`LearningModels.kt` (`com.gigabyte.bookstore.learning.domain.model`)**:
   - Add `HI` to `enum class SpeechLang { EN, BN, JA, UR, HI }`.
   - Update `targetLangForId(id: String)`:
     ```kotlin
     fun targetLangForId(id: String): SpeechLang = when {
         id.startsWith("ur-") -> SpeechLang.UR
         id.startsWith("jp-") -> SpeechLang.JA
         id.startsWith("hi-") -> SpeechLang.HI
         else -> SpeechLang.EN
     }
     ```
   - Update `LadderStep.encode` and `LadderStep.decode` to support `"hi"` alongside `"en", "bn", "ja", "ur"`.
2. **`TtsStepEngine.kt` (`com.gigabyte.bookstore.learning.domain.audio`)**:
   - Add `val HINDI_LOCALES = listOf(Locale("hi", "IN"), Locale("hi"))`.
   - Resolve `SpeechLang.HI` in `onInit()` and expose `val hindiAvailable: StateFlow<Boolean?>` so the lesson screen can show a banner if the offline Hindi TTS voice is missing.
3. **`EscbJsonParser.kt` & `ContentImporter.kt` (`com.gigabyte.bookstore.learning.data.content`)**:
   - Map `"target"` when `targetLang == "hi"` and `"hi"` in `readLadder()` to `SpeechLang.HI`.
   - Add `"spoken_hindi_standard_a1.json"` to `ContentImporter.ASSET_NAMES`.
4. **`UrduSpeakerVariant.kt` (`com.gigabyte.bookstore.learning.domain.model`)**:
   - Extend `forUrduSpeaker(female: Boolean)` (or add `forGenderedSpeaker(female: Boolean)`) to apply the exact same `exampleTarget` / `exampleBn` female-form swap when `id.startsWith("hi-")` (removing Devanagari punctuation `'।'`, `'?'`, `'!'`, `','` when aligning female tokens).
5. **`SpeechCheckCard.kt` & `SpeechMatch.kt` (`com.gigabyte.bookstore.learning.presentation.lesson` / `domain.speech`)**:
   - Support `SpeechLang.HI` with recognizer locale `"hi-IN"`, normalizing Devanagari punctuation (`।`, `?`, `!`, `,`) and nuqta variants (`क/क़`, `ज/ज़`, `फ/फ़`) so speech recognition matches fairly regardless of whether the recognizer outputs nuqta.
6. **`LessonScreen.kt` & `LessonViewModel.kt`**:
   - Show the female-speaker toggle ("নারী রূপ শুনুন ও দেখুন") and `SpeechCheckCard` for `hi-` lessons just like `ur-` lessons, while rendering Devanagari in clean left-to-right layout with generous line height for top/bottom matras.
7. **`LearnHomeScreen.kt`, `LearnHomeViewModel.kt`, `HomeScreen.kt`, & `PaymentScreen.kt`**:
   - Add `isHindi = language.equals("hindi", ignoreCase = true)` branch in `LearnHomeScreen.kt` and `LearnHomeViewModel.kt`.
   - Add the Hindi Spoken Course card on `HomeScreen.kt` (`bundleId = "hindi_course"`, price `৳100`) navigating to `learn?lang=hindi`.

---

## 10. Phased Roadmap

| Phase | Content / Milestone | Size | Done When |
|---|---|---|---|
| **Phase 0** | `SpeechLang.HI` (`hi-IN` TTS), Devanagari rendering, nuqta-tolerant `SpeechMatch`, and female-variant swap unit tests | App plumbing | Unit tests pass; `hi-IN` TTS & speech check verified |
| **Phase 1** | **Stage 0 + Level A1** (`s0-01`…`s0-10` + `a1-01`…`a1-15`) | 25 units, 105 lessons, ~1,200 items | `build_hindi_course.py --check` passes with 0 errors; `spoken_hindi_standard_a1.json` imported and playable |
| **Phase 2** | **Level A2** (Past, Ergative `ने`, Travel & Hospital Hindi) | 15 units, 60 lessons | A2 speaking test & `ने` accuracy drill ≥ 80% |
| **Phase 3** | **Level B1** (Conditionals, Relative clauses, Causatives, Hinglish) | 16 units, 70 lessons | B1 speaking test passes |
| **Phase 4** | **Level B2** (*Shuddh Hindi* vs Hindustani, Interviews, Meetings) | 16 units, 70 lessons | Native review of professional units complete |
| **Phase 5** | **Level C1** (Idioms, Proverbs, Dohe, Debate, Regional Varieties) | 16 units, 70 lessons | C1 speaking test passes |
| **Phase 6** | **Advanced Tracks (T1–T7)** | 7 tracks × 10–20 lessons | T1 (India Travel & Medical Tourism) and T2 (Cross-Border Trade) released first |

---

## 11. Architectural & Pedagogical Decisions

### 11.1 Bangla Sound Hint (`bn_pron`) Instead of Roman Hindi
**Decision:** Do not use Roman/Latin transliteration as a pronunciation aid. Every item in Stage 0 and A1 carries a Bangla-script phonetic hint (`bn_pron`) that explicitly marks:
- Schwa deletion (e.g., `कमरा` → `কম্‌রা`, `समझना` → `সমঝ্‌না`, `कमल` → `কমল`).
- Nuqta and non-Bangla sounds (`ज़` = `জ়`, `फ़` = `ফ়`, `ख़` = `খ়`, `क़` = `ক়`, `ग़` = `গ়`).
- Nasal vowels (`ँ/ं` = `ঁ`, e.g., `मैं` = `ম্যাঁয়`, `हैं` = `হ্যাঁয়`, `हूँ` = `হুঁ`).
- From A2, the hint can be hidden by default (tap to reveal); from B1, learners read Devanagari directly. (Roman Hindi/Hinglish is taught specifically in Unit 3.13 for reading chat messages.)

**Reason:** Roman Hindi encourages English vowel habits and hides dental vs retroflex distinctions (`t/d` vs `ṭ/ḍ`) that Bangla script represents with 100% precision (`ত/দ` vs `ট/ড`).

### 11.2 Devanagari Font & Typography
**Decision:** Unlike Urdu (which requires a bundled Nastaliq font and RTL layout), Android ships with high-clarity system Devanagari fonts (Noto Sans Devanagari) and left-to-right layout. Use `22.sp–26.sp` font size and `1.5x` line height on Hindi target text so superscript matras (`े, ै, ं, ँ`) and subscript matras (`ु, ू, ृ`) never clip.

### 11.3 Speaker Gender Toggle (`learn_hi_speaker_gender`)
**Decision:** Just like Urdu, Hindi verbs and adjectives inflect for the speaker's gender in first-person (`मैं जाता हूँ` vs `मैं जाती हूँ`) and second-person (`आप कैसे हैं?` vs `आप कैसी हैं?`). Store the female variant in `variant_f` / `variant_f_pron` in the unit files (mapped to `exampleTarget` / `exampleBn` in the asset JSON) and allow the learner to toggle between male and female forms in the lesson screen.

### 11.4 Standard Spoken Variety
**Decision:** Teach standard educated spoken Hindi (Delhi/All-India standard) using natural everyday vocabulary in Stage 0–B1 (e.g. teaching both `कोशिश` and `प्रयास`, `ज़रूर` and `अवश्य`, `साल` and `वर्ष` where appropriate), and systematically introducing formal *Shuddh Hindi* in B2.

**Reason:** Learners visiting India for healthcare, tourism, or trade need the natural spoken Hindi people actually speak on the street, in hospitals, and in offices—while also being able to read formal signs and announcements (`प्रवेश निषेध`, `प्रतीक्षालय`, `आपातकालीन`).

### 11.5 Nuqta-Tolerant Speech Recognition (`hi-IN`)
**Decision:** Enable on-device `hi-IN` speech recognition from Stage 0 Unit 0.1 as **feedback only** (never a gate), with self-rating (`😀 / 😐 / 😟`) fallback. In `SpeechMatch.kt`, normalize nuqta characters (`क़→क, ख़→ख, ग़→ग, ज़→ज, फ़→फ, ड़→ड, ढ़→ढ`) and nasal anusvara/chandrabindu (`ँ→ं`) during comparison.

**Reason:** Android's `hi-IN` speech recognizer inconsistently outputs nuqta dots even when the speaker pronounces `ज़` or `फ़` accurately. Normalizing nuqta during string comparison prevents false mismatches.

### 11.6 Priority Order of Advanced Tracks
**Decision:** Build **T1 (India Travel, Medical Tourism & Transit)** first, followed by **T2 (Cross-Border Business & Trade)** and **T3 (Gulf & Overseas Workplace)**.

**Reason:** Hundreds of thousands of Bangladeshi learners travel to India every year for medical treatment (Vellore, Chennai, Kolkata, Delhi), tourism, and cross-border commerce, or use spoken Hindi/Hindustani in Gulf workplaces.

---

## 12. Implementation Status

**Phase 1 (Stage 0 + A1) is complete and integrated into the app as draft content.**

| Component | Location / Details |
|---|---|
| **Unit Sources (25 files)** | `android/tools/hindi/units/s0-01.json` … `s0-10.json` (Stage 0, 45 lessons, 444 items)<br>`android/tools/hindi/units/a1-01.json` … `a1-15.json` (A1, 60 lessons, 735 items) |
| **Format & Rules** | `android/tools/hindi/UNIT_FORMAT.md` |
| **Build & Check Tool** | `android/tools/hindi/build_hindi_course.py` |
| **Compiled App Asset** | `android/app/src/main/assets/spoken_hindi_standard_a1.json`<br>(**25 units, 105 lessons, 1,179 items**, 0 validation errors) |
| **Android Entry Points** | Home screen showcase card → Learn (`lang=hindi`) → course key `hi_standard`, part prefix `hi-std-` |
| **Payment & Bundle** | Bundle `hindi_course`, ৳100 (Payment & Approval screens). Home card shows price or "✓ আনলকড", and tap always opens course. |
| **Audio & Voice** | `SpeechLang.HI` → `hi-IN` (`TtsStepEngine.kt`); lesson warning when device lacks Hindi offline voice |
| **Female Speaker Variants (11.3)** | Preference key `learn_hi_speaker_gender`; build script stores female form in example slot; `forUrduSpeaker()` dynamically swaps it for `hi-` items |
| **Speech Check (11.5)** | `SpeechCheckCard.kt` configured for `hi-IN` with nuqta & nasalization normalization (`SpeechMatch.kt`), feedback-only with self-rating fallback |
| **Unit Tests** | `HindiSupportTest.kt` (ladder encoding/decoding, parser mapping, female speaker swap) and `SpeechMatchTest.kt` (nuqta & punctuation normalization) |


