package aaa.bivizul.a38project.android

import aaa.bivizul.a38project.domain.util.checkSpohownet
import aaa.bivizul.a38project.domain.util.getSpohowdlg
import aaa.bivizul.a38project.ui.root.RootComponent
import aaa.bivizul.a38project.ui.root.RootContent
import aaa.bivizul.a38project.ui.spohowwidget.Spohowibl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.defaultComponentContext

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFAA4C12),
            background = Color(0xD0423328),
            secondary = Color(0xFF000000),
            surface = Color(0xF3686868),
            onPrimary = Color(0xFFFFFFFF),
            onBackground = Color(0xFFFFFFFF),
        )
    } else {
        lightColors(
            primary = Color(0xFFF06C1A),
            background = Color(0xD0ECB992),
            secondary = Color(0xFF000000),
            surface = Color(0xF3E7E7E7),
            onSurface = Color(0xFF000000),
            onPrimary = Color(0xF3FFFFFF),
            onBackground = Color(0xFFFFFFFF),
        )
    }
    val typography = Typography(
        h1 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            fontSize = 96.sp,
            letterSpacing = (-1.5).sp
        ),
        h2 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            fontSize = 60.sp,
            letterSpacing = (-0.5).sp
        ),
        h3 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 48.sp,
            letterSpacing = 0.sp
        ),
        h4 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 34.sp,
            letterSpacing = 0.25.sp
        ),
        h5 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            letterSpacing = 0.sp
        ),
        h6 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            letterSpacing = 0.15.sp
        ),
        body1 = TextStyle(
            fontFamily = FontFamily(Font(aaa.bivizul.a38project.R.font.myriad_pro_black_semi_condensed)),
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 18.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(12.dp),
        medium = RoundedCornerShape(18.dp),
        large = RoundedCornerShape(24.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkSpohownet(this)) {
            val root = RootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Spohowibl()
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background)
                        )
                        RootContent(rootModel = root)
                    }
                }
            }
        } else {
            getSpohowdlg(this)
        }
    }
}
