package com.app.afinal.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.afinal.model.model

@Dao
interface userdao {

    @Insert
    fun insert(user : model)

    @Delete
    fun delete(user : model)

    @Query("delete from student")
    fun deleteall()

    @Query("select * from student order by id asc")
    fun realalldata() : LiveData<List<model>>

    @Update
    fun update(user : model)
}