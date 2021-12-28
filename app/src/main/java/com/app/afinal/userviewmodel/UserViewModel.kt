package com.app.afinal.userviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.afinal.database.database
import com.app.afinal.model.model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readalldata = database.getDatabase(application).userdao().realalldata()

    fun insert(user : model)
    {
        viewModelScope.launch(Dispatchers.IO) {
            database.getDatabase(getApplication()).userdao().insert(user)
        }
    }

    fun delete(user : model)
    {
        viewModelScope.launch(Dispatchers.IO) {
            database.getDatabase(getApplication()).userdao().delete(user)
        }
    }

    fun deleteall()
    {
        viewModelScope.launch(Dispatchers.IO) {
            database.getDatabase(getApplication()).userdao().deleteall()
        }
    }

    fun update(user : model)
    {
        viewModelScope.launch(Dispatchers.IO) {
            database.getDatabase(getApplication()).userdao().update(user)
        }
    }

}