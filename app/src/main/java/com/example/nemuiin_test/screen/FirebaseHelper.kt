package com.example.nemuiin_test.screen

import com.google.firebase.database.*

object FirebaseHelper {
    private const val BARANG_HILANG_PATH = "barang_hilang"
    private const val BARANG_TEMUAN_PATH = "barang_temuan"

    private val database: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference
    }

    fun getBarangHilangList(callback: (List<BarangHilang>) -> Unit) {
        val barangHilangList = mutableListOf<BarangHilang>()

        database.child(BARANG_HILANG_PATH).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val barangHilang = dataSnapshot.getValue(BarangHilang::class.java)
                    barangHilang?.let { barangHilangList.add(it) }
                }
                callback(barangHilangList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

    fun getBarangTemuanList(callback: (List<BarangTemuan>) -> Unit) {
        val barangTemuanList = mutableListOf<BarangTemuan>()

        database.child(BARANG_TEMUAN_PATH).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val barangTemuan = dataSnapshot.getValue(BarangTemuan::class.java)
                    barangTemuan?.let { barangTemuanList.add(it) }
                }
                callback(barangTemuanList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}
