package io.github.l2hyunwoo.translator.android.translate.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.l2hyunwoo.translator.android.R
import io.github.l2hyunwoo.translator.android.core.theme.LightBlue
import io.github.l2hyunwoo.translator.core.presentation.UiLanguage

@Composable
fun LanguageDropDown(
    language: UiLanguage,
    isOpen: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onSelect: (UiLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = onDismiss
        ) {
            UiLanguage.allLanguages.forEach { language ->
                LanguageDropdownItem(
                    language = language,
                    onClick = { onSelect(language) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = language.drawableRes,
                contentDescription = language.language.langName,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = language.language.langName,
                color = LightBlue,
            )
            Icon(
                imageVector = if (isOpen) {
                    Icons.Default.KeyboardArrowUp
                } else {
                    Icons.Default.KeyboardArrowDown
                },
                contentDescription = if (isOpen) {
                    stringResource(id = R.string.close)
                } else {
                    stringResource(id = R.string.open)
                },
                tint = LightBlue,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Preview
@Composable
fun OpenedDropDownPreview() {
    LanguageDropDown(
        language = UiLanguage.byCode("ko"),
        isOpen = true,
        onClick = {},
        onDismiss = {},
        onSelect = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview
@Composable
fun ClosedDropDownPreview() {
    LanguageDropDown(
        language = UiLanguage.byCode("ko"),
        isOpen = false,
        onClick = {},
        onDismiss = {},
        onSelect = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
