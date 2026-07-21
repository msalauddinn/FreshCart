package com.biopic.freshcart

import android.content.Context
import java.io.FileNotFoundException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

const val SESSION_DATA  = "SessionData.txt"

fun writeSessionData(session : Session, context : Context) {
    val fos = context.openFileOutput(SESSION_DATA, Context.MODE_PRIVATE)
    val oos = ObjectOutputStream(fos)
    oos.writeObject(session)
    oos.close()
}

fun readSessionData(context: Context) : Session {
    var session : Session

    try {
        val fis = context.openFileInput(SESSION_DATA)
        val ois = ObjectInputStream(fis)
        session = ois.readObject() as Session
        ois.close()
    } catch (e : FileNotFoundException) {
        return Session(false)
    }

    return session
}