package org.harundemir.happyholiday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.harundemir.happyholiday.ui.theme.HappyHolidayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyHolidayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HolidayGreetingWithImage(message = stringResource(id = R.string.happy_holiday_text), from = "Android")
                }
            }
        }
    }
}

@Composable
fun HolidayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.nature)
    Box() {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        HolidayGreetingWithText(message = message, from = from)
    }
}

@Composable
fun HolidayGreetingWithText(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HolidayGreetingWithImagePreview() {
    HappyHolidayTheme {
        HolidayGreetingWithImage(message = stringResource(R.string.happy_holiday_text), from = "Android")
    }
}