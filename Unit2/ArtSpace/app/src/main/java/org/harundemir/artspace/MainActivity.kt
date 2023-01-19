package org.harundemir.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.harundemir.artspace.ui.theme.ArtSpaceTheme
import org.harundemir.artspace.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceApp() {
    val artList: MutableList<ArtModel> = mutableListOf(
        ArtModel(
            image = R.drawable.art_1,
            title = "View of a building",
            author = "Andrea Giardini"
        ),
        ArtModel(
            image = R.drawable.art_2,
            title = "Large building next to the bridge",
            author = "Bastien Nvs"
        ),
        ArtModel(
            image = R.drawable.art_3,
            title = "An empty subway station",
            author = "Platon Matakaev"
        ),
        ArtModel(
            image = R.drawable.art_4,
            title = "A narrow alley way",
            author = "John Vicente"
        ),
        ArtModel(
            image = R.drawable.art_5,
            title = "A mountain covered in snow",
            author = "Ben Karpinski"
        )
    )
    var currentIndex by remember {
        mutableStateOf(0)
    }
    ArtColumn(art = artList[currentIndex], onPrevious = {
        if (currentIndex > 0) {
            currentIndex--
        } else {
            currentIndex = artList.size - 1
        }
    }, onNext = {
        if (currentIndex < artList.size - 1) {
            currentIndex++
        } else {
            currentIndex = 0
        }
    })
}

@Composable
fun ArtColumn(
    modifier: Modifier = Modifier,
    art: ArtModel,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        ArtImage(image = art.image)
        ArtInfo(title = art.title, author = art.author)
        ArtControls(onPrevious = onPrevious, onNext = onNext)
    }
}

@Composable
fun ArtImage(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun ArtInfo(title: String, author: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = author)
    }
}

@Composable
fun ArtControls(onPrevious: () -> Unit, onNext: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(modifier = Modifier.weight(1f), onClick = onPrevious) {
            Text(text = stringResource(R.string.previous))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(modifier = Modifier.weight(1f), onClick = onNext) {
            Text(text = stringResource(R.string.next))
        }
    }
}

data class ArtModel(
    val image: Int,
    val title: String,
    val author: String,
)