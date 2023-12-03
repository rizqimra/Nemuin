package com.example.nemuiin_test.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nemuiin_test.R
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme


@Composable
fun DetailBarang(navController: NavController, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null
        )
        Column {
            Text(
                text = "Detail Barang",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 70.dp, start = 20.dp)
            )
        }
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Card (
            modifier = Modifier
                .padding(top = 200.dp, start = 60.dp, end = 60.dp)
                .size(500.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFC5DFF8)
            )
        ) {
            //nama barang
            Text(text = "xxx", fontWeight = FontWeight.Bold, fontSize = 26.sp, modifier = Modifier.padding(start = 30.dp, top = 50.dp))
            Spacer(modifier = Modifier.height(20.dp))
            //Lokasi
            Text(text = "Lokasi", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Text(text = "xxx", fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.height(20.dp))
            //Tanggal
            Text(text = "Tanggal", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Text(text = "xxx", fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.height(20.dp))
            //Detail Barang
            Text(text = "Detail Barang", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Text(text = "xxx", fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.height(30.dp))
            //Informasi Pelapor
            Text(text = "Nama Pelapor", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Text(text = "xxx", fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Kontak yang dapat dihubungi", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
            Text(text = "xxx", fontSize = 14.sp, modifier = Modifier.padding(start = 20.dp))
        }
    }
}

@Preview
@Composable
fun DetailBarangPreview() {
    val navController = rememberNavController()
    DetailBarang(navController)
}