package com.zurmati.preference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

/**
 * Created by BILAL ZURMATI 3-26-2022
 */
class ZeePref {

    companion object {

        private lateinit var zeePref: SharedPreferences

        fun init(key:String) {
            if (!::zeePref.isInitialized)
                zeePref = Zurmati.getContext().getSharedPreferences(key, Context.MODE_PRIVATE)

        }

        /**
         * Stores a string
         */
        fun putString(key: String, value: String) {
            zeePref.edit().putString(key, value).apply()
        }

        /**
         * Returns string stored on the key provided
         * returns "" string if no string is stored on give key
         */
        fun getString(key: String): String {
            return zeePref.getString(key, "")!!
        }

        /**
         * Returns string stored on the key provided
         * Takes key and default value as parameter
         * returns default value if no value is stored on the given key
         */
        fun getString(key: String, defValue: String): String {

            return zeePref.getString(key, defValue)!!
        }

        /**
         * Stores an integer
         */
        fun putInt(key: String, value: Int) {
            zeePref.edit().putInt(key, value).apply()
        }

        /**
         * Returns an integer stored on the key provided
         * Returns -1 if value is found on the given key
         */
        fun getInt(key: String): Int {
            return zeePref.getInt(key, -1)
        }

        /**
         * Returns an integer stored on the key provided
         * Returns default value if no value is found on given key
         */
        fun getInt(key: String, defaultValue: Int): Int {
            return zeePref.getInt(key, defaultValue)
        }

        /**
         * Stores Boolean value
         */
        fun putBoolean(key: String, value: Boolean) {
            zeePref.edit().putBoolean(key, value).apply()
        }

        /**
         * Returns boolean stored on the key provided
         * Returns false if no value found on the given key
         */
        fun getBoolean(key: String): Boolean {
            return zeePref.getBoolean(key, false)
        }

        /**
         * Returns boolean stored on the key provided
         * Returns defaultValue if no value found on the given key
         */
        fun getBoolean(key: String, defValue: Boolean): Boolean {
            return zeePref.getBoolean(key, defValue)
        }

        /**
         * Stores an incrementing integer on given key
         * starts with 1 if no previous value available
         * use getInt method to get currently increment value
         */
        fun increment(key: String) {
            var counter = zeePref.getInt(key, 0)
            counter += 1
            zeePref.edit().putInt(key, counter).apply()
        }

        /**
         * Stores a decrementing integer on given key
         * Stores 0 if no previous value found on given key
         * use getInt method to get currently increment value
         */
        fun decrement(key: String) {
            var counter = zeePref.getInt(key, 1)
            if (counter <= 0)
                counter = 0
            else
                counter -= 1
            zeePref.edit().putInt(key, counter).apply()
        }
    }

}