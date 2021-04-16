package com.example.roomdbsample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomDao {
    @Insert
    fun insert(text: ContentText)

    @Query("select * from ContentText")
    fun getContent(): LiveData<List<ContentText>>
}
