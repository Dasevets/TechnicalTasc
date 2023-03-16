package com.example.technicaltask.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.technicaltask.model.UserDB

@Dao
interface UserDao {

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): List<UserDB>


    @Insert(entity = UserDB::class)
    fun insertUser(user: UserDB)

    @Query("SELECT * FROM users_table WHERE firstName LIKE :search")
    fun searchUserByFirstName(search: String) : List<UserDB>

}

