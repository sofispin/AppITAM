package com.example.android.ayudaitamita;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper {
    String create="create table if not exists Evento (_id integer primary key autoincrement,contenido text not null)";

    public ConexionBD(Context context){
        //Crea la base de datos
        super(context,"Recordatorios.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
