package aaa.bivizul.a38project.ui.spohowwidget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun SpohowButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
)