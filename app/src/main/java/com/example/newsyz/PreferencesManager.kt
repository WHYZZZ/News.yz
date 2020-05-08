package com.example.newsyz

import android.app.assist.AssistContent
import android.content.Context

object PreferencesManager {
    private const val PREF_EMAIL = "email"
    private const val IS_LOGGED_IN = "state"

    fun saveEmail(context: Context, email: String){
        getPrefs(context).edit().putString(PREF_EMAIL, email).apply()
    }

    fun getEmail(context: Context) =
        getPrefs(context).getString(PREF_EMAIL,"")

    fun saveState(context: Context, logged_in: Boolean){
        getPrefs(context).edit().putBoolean(IS_LOGGED_IN, logged_in).apply()
    }

    fun getState(context: Context)=
        getPrefs(context).getBoolean(IS_LOGGED_IN,false)

    private fun getPrefs(context: Context)=
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
}