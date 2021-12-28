package com.app.afinal.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.afinal.dao.userdao
import com.app.afinal.model.model
import kotlin.coroutines.coroutineContext

@Database(entities = [model::class], version = 1, exportSchema = false)
abstract class database : RoomDatabase(){

    abstract fun userdao() : userdao

    companion object{

        @Volatile
        private var INSTANCE : database? = null

        fun getDatabase(context: Context):database
        {
            val tempinstance = INSTANCE
            if(tempinstance!=null)
            {
                return tempinstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext,
                    database::class.java,
                    "user_database").build()

                INSTANCE = instance
                return instance
            }
        }
    }
}