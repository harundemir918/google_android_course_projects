package org.harundemir.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.harundemir.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskDoneColumn()
                }
            }
        }
    }
}

@Composable
fun TaskDoneColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TaskDoneIcon()
        TaskDoneTitle()
        TaskDoneDescription()
    }
}

@Composable
fun TaskDoneIcon() {
    Image(painter = painterResource(id = R.drawable.ic_task_completed), contentDescription = null)
}

@Composable
fun TaskDoneTitle() {
    Text(
        text = "All tasks completed",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun TaskDoneDescription() {
    Text(text = "Nice work!", fontSize = 16.sp)
}

@Preview(showBackground = true)
@Composable
fun TaskDoneColumnPreview() {
    TaskManagerTheme {
        TaskDoneColumn()
    }
}