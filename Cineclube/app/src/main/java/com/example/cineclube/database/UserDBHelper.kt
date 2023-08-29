package com.example.cineclube.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cineclube.model.UserModel

class UserDBHelper(context: Context) : SQLiteOpenHelper(context, "database.db", null, 1) {

    val sql = arrayOf(
        "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE, password TEXT)",
        "INSERT INTO users (username, password) VALUES ('admin','pass')",
        "INSERT INTO users (username, password) VALUES ('user1','pass1')",
        "INSERT INTO users (username, password) VALUES ('user2','pass2')",
        "INSERT INTO users (username, password) VALUES ('user3','pass3')",
    )

    override fun onCreate(db: SQLiteDatabase) {
        sql.forEach {
            db.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val res = db.insert("users", null, contentValues)
        db.close()
        return res
    }

    fun updateUser(id: Int, username: String, password: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val res = db.update("users", contentValues, "id=?", arrayOf((id.toString())))
        db.close()
        return res
    }

    fun deleteUser(id: Int): Int {
        val db = this.writableDatabase
        val res = db.delete("users", "id=?", arrayOf((id.toString())))
        db.close()
        return res
    }

    fun getUser(username: String, password: String): UserModel {
        val db = this.readableDatabase
        val c = db.rawQuery(
            "SELECT * FROM users WHERE username=? AND password=?",
            arrayOf(username, password)
        )
        var userModel = UserModel()

        if (c.count == 1) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val usernameIndex = c.getColumnIndex("username")
            val passwordIndex = c.getColumnIndex("password")

            userModel = UserModel(
                id = c.getInt(idIndex),
                username = c.getString(usernameIndex),
                password = c.getString(passwordIndex)
            )
        }
        db.close()
        return userModel
    }

    fun login(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val c = db.rawQuery(
            "SELECT * FROM users WHERE username=? AND password=?",
            arrayOf(username, password)
        )
        var userModel = UserModel()

        return if (c.count == 1) {
            db.close()
            true
        } else {
            db.close()
            false
        }
    }
}