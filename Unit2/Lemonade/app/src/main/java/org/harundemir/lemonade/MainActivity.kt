package org.harundemir.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.harundemir.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeColumn(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun LemonadeColumn(modifier: Modifier = Modifier) {
    var lemonadeText by remember {
        mutableStateOf("Tap the lemon tree to select a lemon")
    }
    var lemonadeImage by remember {
        mutableStateOf(R.drawable.lemon_tree)
    }
    var tapCount by remember {
        mutableStateOf(1)
    }
    var currentTap by remember {
        mutableStateOf(0)
    }
    var status by remember {
        mutableStateOf(1)
    }
    when (status) {
        1 -> {
            lemonadeText = "Tap the lemon tree to select a lemon"
            lemonadeImage = R.drawable.lemon_tree
            tapCount = 1
            currentTap = 0
        }
        2 -> {
            tapCount = (2..4).random()
            currentTap = 0
            lemonadeText = "Keep tapping the lemon to squeeze it"
            lemonadeImage = R.drawable.lemon_squeeze
        }
        3 -> {
            lemonadeText = "Tap the lemonade to drink it"
            lemonadeImage = R.drawable.lemon_drink
            tapCount = 1
            currentTap = 0
        }
        4 -> {
            lemonadeText = "Tap the empty glass to start again"
            lemonadeImage = R.drawable.lemon_restart
            tapCount = 1
            currentTap = 0
        }
        else -> {
            lemonadeText = "Tap the lemon tree to select a lemon"
            lemonadeImage = R.drawable.lemon_tree
            tapCount = 1
            currentTap = 0
            status = 1
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = lemonadeText)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (status == 2 && currentTap < tapCount) {
                    currentTap++
                } else status++
            }
        ) {
            Image(painter = painterResource(id = lemonadeImage), contentDescription = "Lemon Image")
        }
    }
}
