package com.example.android.ayudaitamita;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class InterfazBD {
    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD(Context contexto){
        con=new ConexionBD(contexto);
    }

    public void open()throws SQLiteException{
        db=con.getWritableDatabase();
    }

    public void close()throws SQLiteException{
        db.close();
    }

    public long insertarDatos(String contenido){
        ContentValues parametros;
        parametros=new ContentValues();
        parametros.put("contenido",contenido);

        open();
        long resultado=db.insert("Evento",null,parametros);
        close();
        return resultado;
    }

    public long actualizarDato(long llave,String contenido){
        ContentValues parametros;
        parametros=new ContentValues();
        parametros.put("contenido",contenido);

        //Parametros para la cláusula de where, agregar varias condiciones al where
        String id=""+llave;
        String[] arregloStrings=new String[1];
        arregloStrings[0]=id;

        open();
        long res=db.update("Evento",parametros,"_id=?",arregloStrings);
        close();
        return res;
    }

    public long borrarDato(long llave){
        open();
        //Parámetros del where
        String id=""+llave;
        String[] arregloStrings=new String[1];
        arregloStrings[0]=id;
        long res=db.delete("Evento","_id=?",arregloStrings);
        close();
        return res;
    }

    //Cursor - lector
    public Cursor todosLosDatos(){
        String query="select * from Evento;";
        open();
        Cursor lector=db.rawQuery(query,null);
        return lector;
    }

    public Evento buscarDato(long llave){
        String query="select * from Evento where _id=?;";
        open();
        String id=""+llave;
        String[] arregloStrings=new String[1];
        arregloStrings[0]=id;
        Cursor lector=db.rawQuery(query,arregloStrings);
        if(lector.moveToNext()) {//moveToNext es como Read()
            //Estoy en el primer renglon
            long llavePrimaria;
            String contenido;
            llavePrimaria=lector.getLong(0);
            contenido=lector.getString(1);
            Evento resultado=new Evento(llavePrimaria,contenido);
            return resultado;
        }
        return null;
    }

}
