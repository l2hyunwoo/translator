package io.github.l2hyunwoo.translator.core.presentation

import io.github.l2hyunwoo.translator.core.domain.language.Language

actual class UiLanguage(
    actual val language: Language,
    val imageName: String
) {
    actual companion object {
        actual fun byCode(langCode: String): UiLanguage {
            return allLanguages.find { it.language.langCode == langCode }
                ?: throw IllegalArgumentException("Invalid or unsupported language code: $langCode")
        }

        actual val allLanguages: List<UiLanguage>
            get() = Language.entries.map { language ->
                UiLanguage(
                    language = language,
                    imageName = language.langName.lowercase()
                )
            }
    }
}
