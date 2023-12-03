package com.example.nemuiin_test.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nemuiin_test.R
import com.example.nemuiin_test.screen.BarangTemuan
import com.example.nemuiin_test.ui.theme.Nemuiin_testTheme
import com.example.nemuiin_test.screen.FirebaseHelper

class ListBarangTemuanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nemuiin_testTheme {
                val navController = rememberNavController()
                ListBarangTemuanContent(navController)
            }
        }
    }
}

@Composable
fun ListBarangTemuanContent(navController: NavController, modifier: Modifier = Modifier) {
    var barangList by remember { mutableStateOf(emptyList<BarangTemuan>()) }

    LaunchedEffect(true) {
        FirebaseHelper.getBarangTemuanList { list ->
            barangList = list
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_new),
            contentDescription = null
        )
        Column {
            Text(
                text = "Barang Temuan",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 90.dp, start = 20.dp)
            )
            val searchtxt = remember {
                mutableStateOf(TextFieldValue(""))
            }
            SearchViewTemuan(
                state = searchtxt,
                placeHolder = "Cari disini",
                modifier = Modifier
            )
        }
    }

    Column {
        LazyColumn (contentPadding = PaddingValues(16.dp)) {
            items(barangList) { barang ->
                BarangItemTemuan(barang = barang)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = { navController.navigate("formTemuan") },
            modifier = Modifier
                .padding(16.dp)
                .size(56.dp)
                .align(Alignment.BottomEnd),
            shape = CircleShape,
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, "Tambah barang temuan")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchViewTemuan(
    state: MutableState<TextFieldValue>,
    placeHolder: String,
    modifier: Modifier
) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(2.dp, Color.LightGray, RoundedCornerShape(30.dp)),
        placeholder = {
            Text(text = placeHolder)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        ),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black, fontSize = 18.sp
        )
    )
}

@Composable
fun BarangItemTemuan(barang: BarangTemuan) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
//                navController.navigate(route= "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "${barang.namaBarang}, fontWeight = FontWeight.Bold")
                Text(text = "${barang.lokasi}")
                Text(text = "${barang.tanggal}")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListBarangTemuanPreview() {
    Nemuiin_testTheme {
        val navController = rememberNavController()
        ListBarangTemuanContent(navController)
    }
}
