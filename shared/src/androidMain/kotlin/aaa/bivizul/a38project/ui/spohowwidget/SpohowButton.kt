package aaa.bivizul.a38project.ui.spohowwidget

import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWIB
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
actual fun SpohowButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String
) {

    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        GlideImage(
            imageModel = { SPOHOWIB },
            modifier = Modifier.fillMaxWidth().height(100.dp),
            imageOptions = ImageOptions(
                alignment = Alignment.Center
            )
        )
        Text(
            text = text,
            modifier = modifier.padding(horizontal = 18.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )
    }

}