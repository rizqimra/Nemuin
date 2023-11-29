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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nemuiin_test.R
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null
        )
        Text(text = "MASUK",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        val emailtxt = remember {
            mutableStateOf("")
        }
        val passtxt = remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = emailtxt.value,
            onValueChange = { newText -> emailtxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(start = 64.dp, end = 64.dp, top = 40.dp, bottom = 8.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )


        OutlinedTextField(
            value = passtxt.value,
            onValueChange = { newText -> passtxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 64.dp, end = 64.dp, top = 10.dp, bottom = 8.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 64.dp, end = 64.dp, top = 10.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1892FA))
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Belum memiliki akun ?",
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            fontSize = 14.sp,
            color = Color.Black
        )

        val context: Context = LocalContext.current

        ClickableText(
            text = AnnotatedString("DAFTAR"),
            onClick = { navController.navigate("register") },
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(android.graphics.Color.parseColor("#1892FA"))
            ),
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    Login(navController)
}