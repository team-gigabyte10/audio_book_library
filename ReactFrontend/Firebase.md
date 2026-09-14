npm install firebase

// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyC0sUtQ-SsE-IazJNg9AwP-JmQ_xJMR1iY",
  authDomain: "book-store-bec15.firebaseapp.com",
  databaseURL: "https://book-store-bec15-default-rtdb.firebaseio.com",
  projectId: "book-store-bec15",
  storageBucket: "book-store-bec15.firebasestorage.app",
  messagingSenderId: "1096744232990",
  appId: "1:1096744232990:web:186080c3ec42ad7a33660f",
  measurementId: "G-8YSJN6PWZT"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);


npm install -g firebase-tools


