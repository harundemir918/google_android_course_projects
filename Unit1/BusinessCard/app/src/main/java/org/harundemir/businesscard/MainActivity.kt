package org.harundemir.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.harundemir.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                CardApp()
            }
        }
    }
}

@Composable
fun CardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF003972)
    ) {
        CardBody()
    }
}

@Composable
fun CardBody() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CardInfo()
        CardContact()
    }
}

@Composable
fun CardInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.androidlogo),
            contentDescription = null,
            modifier = Modifier.aspectRatio(5f)
        )
        Text(text = "Android", fontSize = 30.sp, color = Color.White)
        Text(text = "Android Developer", color = Color.Green)
    }
}

@Composable
fun CardContact() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        CardContactRow(iconId = R.drawable.ic_baseline_phone_24, text = "+90 505 505 05 05")
        CardContactRow(iconId = R.drawable.ic_baseline_share_24, text = "@AndroidDev")
        CardContactRow(iconId = R.drawable.ic_baseline_email_24, text = "android@dev.com")
    }
}

@Composable
fun CardContactRow(iconId: Int, text: String) {
    Surface(
        color = Color.Transparent,
        modifier = Modifier.width(200.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                tint = Color.Green
            )
            Text(
                text = text,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardBodyPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF003972)
        ) {
            CardBody()
        }
    }
}