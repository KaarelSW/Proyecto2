// Import the functions you need from the SDKs you need

import { initializeApp } from "firebase/app";

import { getAnalytics } from "firebase/analytics";

// TODO: Add SDKs for Firebase products that you want to use

// https://firebase.google.com/docs/web/setup#available-libraries


// Your web app's Firebase configuration

// For Firebase JS SDK v7.20.0 and later, measurementId is optional

const firebaseConfig = {

  apiKey: "AIzaSyA0U0_0FKqTJkQP0LoH5pbM2pr5hDR7FIg",

  authDomain: "snariox.firebaseapp.com",

  databaseURL: "https://snariox-default-rtdb.europe-west1.firebasedatabase.app",

  projectId: "snariox",

  storageBucket: "snariox.appspot.com",

  messagingSenderId: "563835592323",

  appId: "1:563835592323:web:4d37a4e6bf5b42b850c5b6",

  measurementId: "G-PMPKERL0LD"

};


// Initialize Firebase

const app = initializeApp(firebaseConfig);

const analytics = getAnalytics(app);