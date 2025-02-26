package com.example.postcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postcardapp.ui.theme.PostCardAppTheme

// Main Activity - Entry point of the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable edge-to-edge display (full screen)
        setContent {
            PostCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard() // Call our business card composable
                }
            }
        }
    }
}

// Define custom colors for our business card
val LightGray = Color(0xFFF5F5F5)   // Light grayish white for text
val Golden = Color(0xFFDAA520)      // Golden color for accents
val DarkGray = Color(0xFF333333)    // Dark gray for background
val MediumGray = Color(0xFF555555)  // Medium gray for gradient

// Main composable function for the business card
@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    // Main container with textured background (gradient gives a subtle texture)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(DarkGray, MediumGray, DarkGray)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Card content centered in the box
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Profile Image
            ProfileImage()

            Spacer(modifier = Modifier.height(24.dp))

            // Name
            Text(
                text = "Artem Guz",
                color = Golden,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Divider line
            Divider(
                color = Golden.copy(alpha = 0.5f),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(horizontal = 40.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contact Information
            ContactInformation()
        }
    }
}

// Composable function for the profile image with golden border
@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    // Profile image in a circle with golden border
    Box(
        modifier = modifier
            .size(160.dp)
            .clip(CircleShape)
            .background(Golden),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.headshot), // Using your headshot.jpeg image
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
    }
}

// Composable function for displaying contact information
@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    // Contact information column
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Email with icon
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
                tint = Golden,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "artem.guz@cix.csi.cuny.edu",
                color = LightGray,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // LinkedIn with icon
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person, // Using Person icon as LinkedIn isn't in default icons
                contentDescription = "LinkedIn",
                tint = Golden,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "linkedin.com/in/arteeguz/",
                color = LightGray,
                fontSize = 16.sp
            )
        }
    }
}

// Preview function to see how the business card looks
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    PostCardAppTheme {
        BusinessCard()
    }
}