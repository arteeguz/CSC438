package com.example.postcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postcardapp.ui.theme.PostCardAppTheme

// Main Function
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

//Define the colors that will be used in the app
val LightGray = Color(0xFFF5F5F5)
val Golden = Color(0xFFDAA520)
val DarkGray = Color(0xFF333333)
val MediumGray = Color(0xFF555555)

////////////////////////////////////////////////////////////////////////////////

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 150.sp,
            color = Color.Blue
        )
        Text(
            text = from,
            fontSize = 36.sp
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PostcardPreview(){
    PostCardAppTheme {
        GreetingText(message = "What's up CSI", from = "Guz")
    }
}