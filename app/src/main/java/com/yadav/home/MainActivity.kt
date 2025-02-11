package com.yadav.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yadav.home.ui.theme.HomeTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext  // Import LocalContext
import android.content.Intent  // Import Intent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables immersive edge-to-edge display
        setContent {
            HomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen() // Calls the UI function
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Upper Image Background with Logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = "Background Image",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp)),
                contentScale = ContentScale.Crop
            )

            // White Circle Background for Logo
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 50.dp)
                    .background(Color.White, shape = CircleShape)
            )

            // Logo Positioned at the Bottom Center
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 30.dp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        // CultivAI Logo
        Image(
            painter = painterResource(id = R.drawable.cultivai_logo),
            contentDescription = "CultivAI Logo",
            modifier = Modifier
                .height(120.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Description Text
        Text(
            text = "An AI-powered decision support tool to help farmers optimize crop strategies and adapt to changing climate conditions. 🌱",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(70.dp))

        // Get Started Button
        Button(
            onClick = {
                // Handle the button click by navigating to WebViewActivity
                val intent = Intent(context, WebViewActivity::class.java)
                intent.putExtra("URL", "https://cropai-bb7m.onrender.com")
                context.startActivity(intent) // Start the WebViewActivity
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF00C853)),
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally) // Explicitly center aligned
        ) {
            Text(text = "Get Started", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(48.dp)) // Extra space at the bottom for better alignment
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeTheme {
        HomeScreen()
    }
}
