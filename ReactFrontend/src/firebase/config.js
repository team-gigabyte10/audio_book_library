import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";
import { getDatabase } from "firebase/database";
import { getAuth } from "firebase/auth";

export const firebaseConfig = {
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
export const app = initializeApp(firebaseConfig);

// Initialize Auth
export const auth = getAuth(app);

// Initialize Firestore
export const db = getFirestore(app);

// Initialize Storage
export const storage = getStorage(app);

// Initialize Realtime Database (as fallback/companion)
export const rtdb = getDatabase(app);

