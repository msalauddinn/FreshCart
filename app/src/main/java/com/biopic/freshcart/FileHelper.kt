package com.biopic.freshcart

import android.content.Context
import java.io.FileNotFoundException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

const val FILE_NAME = "freshcart.txt"

fun writeData(user : User, context : Context) {
    val fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
    val oos = ObjectOutputStream(fos)
    oos.writeObject(user)
    oos.close()
}

fun readData(context: Context) : User {
    var user : User

    try {
        val fis = context.openFileInput(FILE_NAME)
        val ois = ObjectInputStream(fis)
        user = ois.readObject() as User
        ois.close()
    } catch (e : FileNotFoundException) {
        return User("", "", "")
    }

    return user
}