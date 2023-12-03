package com.example.nemuiin_test.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LandingPage(navController: NavController, modifier: Modifier = Modifier) {
    Surface(
        color = Color(android.graphics.Color.parseColor("#1892FA")),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 200.dp)
        ) {
            Text(
                text = "nemuin",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = androidx.compose.ui.graphics.Color.White
            )
            Text(
                text = "Lapor Barang Hilang dan Temuan",
                fontSize = 28.sp,
                fontWeight = FontWeight.Light,
                color = androidx.compose.ui.graphics.Color.White
            )
        }
    }
    Surface(
        color = androidx.compose.ui.graphics.Color.White,
        modifier = Modifier
            .height(400.dp)
            .padding(top = 300.dp),
        shape = RoundedCornerShape(60.dp).copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(start = 64.dp, end = 64.dp, top = 10.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1892FA)
                )
            ) {
                Text(
                    text = "Masuk",
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { navController.navigate("register") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(start = 64.dp, end = 64.dp, top = 10.dp, bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1892FA)
                )
            ) {
                Text(
                    text = "Daftar",
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    LandingPage(navController)
}
