package com.example.roomdbsample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContentText::class],version = 1)
abstract class RoomDb : RoomDatabase() {
    abstract fun RoomDao(): RoomDao
}