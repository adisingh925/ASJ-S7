package com.app.afinal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class model(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "first name") val fname : String,
    @ColumnInfo(name = "last name") val lname : String
)
