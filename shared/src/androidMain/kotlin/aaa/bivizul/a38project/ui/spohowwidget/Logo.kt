package aaa.bivizul.a38project.ui.spohowwidget

import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWIL
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
actual fun Logo() {
    GlideImage(
        imageModel = { SPOHOWIL },
        modifier = Modifier.width(350.dp).height(150.dp),
        imageOptions = ImageOptions(
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center
        )
    )
}