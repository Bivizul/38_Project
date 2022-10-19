package aaa.bivizul.a38project.ui.spohowwidget

import aaa.bivizul.a38project.domain.util.Spohowcon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
actual fun Spohowibl() {

    val spohoworient = LocalConfiguration.current.orientation
    val spohowImgModel = when (spohoworient) {
        Configuration.ORIENTATION_PORTRAIT -> Spohowcon.SPOHOWBV
        else -> Spohowcon.SPOHOWBH
    }

    GlideImage(
        imageModel = { spohowImgModel },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    )

}