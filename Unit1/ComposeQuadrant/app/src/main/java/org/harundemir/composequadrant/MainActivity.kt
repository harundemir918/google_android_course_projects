package org.harundemir.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.harundemir.composequadrant.ui.theme.ComposeQuadrantTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    QuadrantList()
                }
            }
        }
    }
}

@Composable
fun QuadrantList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            Quadrant(
                title = "Text composable",
                description = "Displays text and follows Material Design guidelines.",
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            Quadrant(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                color = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, color: Color, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = description, textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantListPreview() {
    ComposeQuadrantTheme {
        QuadrantList()
    }
}