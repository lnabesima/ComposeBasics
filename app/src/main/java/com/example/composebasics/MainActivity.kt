package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(it)) {
                        ArticleHeader()
                        ArticleTitle("Jetpack Compose tutorial")
                        ArticleBody()
                    }
                }
            }
        }
    }
}

var paragraphs = listOf(
    "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
    "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
)


@Composable
fun ArticleHeader() {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun ArticleTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier.padding(16.dp),
        fontSize = 24.sp,
    )
}

@Composable
fun ArticleBody() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        paragraphs.forEach {
            Text(
                text = it,
                textAlign = TextAlign.Justify,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeBasicsTheme {
        Column {
            ArticleHeader()
            ArticleTitle("Jetpack Compose tutorial")
            ArticleBody()
        }
    }
}