package com.example.nemuiin_test.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nemuiin_test.R
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null
        )
        Text(text = "Hello!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#1892FA")),
            modifier = Modifier.padding(top = 30.dp)
        )
        Text(text = "Apa yang ingin Anda laporkan?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
            color = Color(android.graphics.Color.parseColor("#1892FA"))
        )

        val context: Context = LocalContext.current

        Button(
            onClick = {
                val intent = Intent(context, activity_formHilang::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(start = 40.dp, end = 40.dp, top = 50.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC5DFF8)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Barang Hilang",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
                val intent = Intent(context, activity_formTemuan::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 40.dp, end = 40.dp, top = 20.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC5DFF8)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Barang Temuan",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}