package org.harundemir.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.harundemir.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleContent(
                        image = R.drawable.bg_compose_background,
                        title = "Jetpack Compose tutorial",
                        summary = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        description = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleContent(image: Int, title: String, summary: String, description: String) {
    Column {
        ArticleImage(image = image)
        ArticleTitle(title = title)
        ArticleSummary(summary = summary)
        ArticleDescription(description = description)
    }
}

@Composable
fun ArticleImage(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ArticleTitle(title: String) {
    Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
}

@Composable
fun ArticleSummary(summary: String) {
    Text(
        text = summary,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun ArticleDescription(description: String) {
    Text(
        text = description,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ArticleContentPreview() {
    ComposeArticleTheme {
        ArticleContent(
            image = R.drawable.bg_compose_background,
            title = "Jetpack Compose tutorial",
            summary = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            description = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}