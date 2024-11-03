package com.example.jetpackapp.viajesBD

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Definir la base de datos y las tablas
class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "ViajesDB.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Detalles"
        const val COLUMN_ID = "id"
        const val COLUMN_DETAIL = "detail"
        const val COLUMN_TIME = "time"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_DETAIL TEXT,"
                + "$COLUMN_TIME TEXT" + ")")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Método para agregar un nuevo detalle
    fun addDetail(detail: String, time: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_DETAIL, detail)
            put(COLUMN_TIME, time)
        }
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }

    // Método para obtener todos los detalles
    fun getAllDetalles(): List<Pair<String, String>> {
        val detalles = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val cursor: Cursor = db.query(TABLE_NAME, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val detailIndex = cursor.getColumnIndex(COLUMN_DETAIL)
                val timeIndex = cursor.getColumnIndex(COLUMN_TIME)

                // Verifica que los índices no sean -1
                if (detailIndex != -1 && timeIndex != -1) {
                    val detail = cursor.getString(detailIndex)
                    val time = cursor.getString(timeIndex)
                    detalles.add(Pair(detail, time))
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return detalles
    }
}
