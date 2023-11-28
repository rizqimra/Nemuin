package com.example.nemuiin_test.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nemuiin_test.R
import com.example.nemuiin_test.screen.BarangTemuan
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme
import com.example.nemuiin_test.screen.FirebaseHelper

class ListBarangTemuanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nemuiin_testTheme {
                ListBarangTemuanContent()
            }
        }
    }
}

@Composable
fun ListBarangTemuanContent() {
    var barangList by remember { mutableStateOf(emptyList<BarangTemuan>()) }

    LaunchedEffect(true) {
        FirebaseHelper.getBarangTemuanList { list ->
            barangList = list
        }
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(barangList) { barang ->
                BarangItem(barang = barang)
            }
        }
    }
}

@Composable
fun BarangItem(barang: BarangTemuan) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Nama Barang: ${barang.namaBarang}")
        Text(text = "Lokasi: ${barang.lokasi}")
        Text(text = "Tanggal Kehilangan: ${barang.tanggal}")
        Text(text = "Detail Barang: ${barang.detail}")
        Text(text = "Pelapor: ${barang.namaPelapor}")
        Text(text = "Kontak Pelapor: ${barang.kontak}")
    }
}

@Preview(showBackground = true)
@Composable
fun ListBarangTemuanPreview() {
    Nemuiin_testTheme {
        ListBarangHilangContent()
    }
}
