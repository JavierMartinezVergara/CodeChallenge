package com.javiermtz.codechallenge.data.local.shared

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

const val FROM_DATABASE_NAME = "is_from_database"


class SharedPreferencesDogs @Inject constructor(private val preferences: SharedPreferences) {

  fun setFromDatabase(enabled: Boolean) {
    preferences.edit {
      putBoolean(FROM_DATABASE_NAME, enabled) }
  }

  fun isFromDatabase() = preferences.getBoolean(FROM_DATABASE_NAME, false)
}
