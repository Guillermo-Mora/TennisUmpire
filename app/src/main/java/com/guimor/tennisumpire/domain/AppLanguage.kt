package com.guimor.tennisumpire.domain

import com.guimor.tennisumpire.R

const val SYSTEM_DEFAULT_LANGUAGE = "system_default_language"
enum class AppLanguage(
    val code: String,
    val displayName: Int,
) {
    SYSTEM(code = SYSTEM_DEFAULT_LANGUAGE, displayName = R.string.system),
    ENGLISH(code = "en", displayName = R.string.english),
    SPANISH(code = "es", displayName = R.string.spanish);
}