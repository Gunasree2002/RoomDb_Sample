package com.example.roomdbsample

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContentText(

    @NonNull
    @PrimaryKey(autoGenerate = true) var id: Int =0,
    var content : String
)
