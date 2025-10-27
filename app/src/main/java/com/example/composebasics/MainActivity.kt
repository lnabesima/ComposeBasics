package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
                        ComposeQuadrantColumn()
                    }
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(title: String, body: String, color: Long, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(color))
            .padding(16.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(body, textAlign = TextAlign.Justify)
    }
}

@Composable
fun ComposeQuadrantRow(
    firstTitle: String,
    firstBody: String,
    firstColor: Long,
    secondTitle: String,
    secondBody: String,
    secondColor: Long,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        ComposeQuadrant(
            firstTitle, firstBody, firstColor,
            modifier = Modifier.weight(1f)
        )
        ComposeQuadrant(
            secondTitle, secondBody, secondColor,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ComposeQuadrantColumn() {
    Column(Modifier.fillMaxSize()) {
        ComposeQuadrantRow(
            "Text composable",
            "Displays text and follows the recommended Material Design guidelines.",
            0xFFEADDFF, "Image composable",
            "Creates a composable that lays out and draws a given Painter class object.",
            0xFFD0BCFF, Modifier.weight(1f)
        )
        ComposeQuadrantRow(
            "Row composable",
            "A layout composable that places its children in a horizontal sequence.",
            0xFFB69DF8,
            "Column composable",
            "A layout composable that places its children in a vertical sequence.",
            0xFFF6EDFF,
            Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeBasicsTheme {
        ComposeQuadrantColumn()
    }
}