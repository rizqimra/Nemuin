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
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nemuiin_test.R
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme
import com.google.android.material.search.SearchBar
import com.google.firebase.database.FirebaseDatabase

data class BarangHilang(
    val namaBarang: String,
    val lokasi: String,
    val tanggal: String,
    val detail: String,
    val namaPelapor: String,
    val kontak: String
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormHilang(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Form Kehilangan",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#1892FA")),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Informasi Barang
        Text("Informasi Barang",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            color = Color(android.graphics.Color.parseColor("#1892FA")),
            modifier = Modifier.padding(start = 30.dp))
        Spacer(modifier = Modifier.height(8.dp))

        // Nama Barang
        val namaBarangtxt = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = namaBarangtxt.value,
            onValueChange = { newText -> namaBarangtxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 45.dp, end = 64.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Nama Barang")}
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Lokasi
        val lokasitxt = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = lokasitxt.value,
            onValueChange = { newText -> lokasitxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 45.dp, end = 64.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Lokasi")}
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Tanggal Kehilangan
        val tanggaltxt = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = tanggaltxt.value,
            onValueChange = { newText -> tanggaltxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 45.dp, end = 64.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Tanggal")}
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Detail Barang
        val detailtxt = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = detailtxt.value,
            onValueChange = { newText -> detailtxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 45.dp, end = 64.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Detail Barang")}
        )
        Spacer(modifier = Modifier.height(15.dp))

        // Informasi Pelapor
        Text("Informasi Pelapor",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            color = Color(android.graphics.Color.parseColor("#1892FA")),
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Nama Pelapor
        val namaLaportxt = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = namaLaportxt.value,
            onValueChange = { newText -> namaLaportxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 45.dp, end = 64.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Nama Pelapor")}
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Kontak yang Dapat Dihubungi
        val kontaktxt = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = kontaktxt.value,
            onValueChange = { newText -> kontaktxt.value = newText },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 45.dp, end = 64.dp),
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 16.sp
            ),
            label = { Text(text = "Kontak")}
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button Simpan
        val buttonModifier = Modifier
            .fillMaxWidth()
            .height(45.dp) // Tinggi tombol
            .padding(horizontal = 125.dp) // Padding horizontal
        Button(
            onClick = {
                val database = FirebaseDatabase.getInstance()
                val reference = database.getReference("barang_hilang")

                val barangHilang = BarangHilang(
                    namaBarangtxt.value,
                    lokasitxt.value,
                    tanggaltxt.value,
                    detailtxt.value,
                    namaLaportxt.value,
                    kontaktxt.value
                )

                reference.push().setValue(barangHilang)

                navController.navigate("listBarangHilang")
            },
            modifier = buttonModifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1892FA)),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Lapor",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
        }
    }

}

@Preview
@Composable
fun FormHilangPreview() {
    val navController = rememberNavController()
    FormHilang(navController)
}