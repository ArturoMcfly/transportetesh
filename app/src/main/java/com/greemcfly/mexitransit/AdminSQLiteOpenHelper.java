package com.greemcfly.mexitransit;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table tbl_usuario(id_usuario int primary key, nombre text, correo text,tipo text,contrasenia text)");
        BaseDeDatos.execSQL("create table tbl_rutas(id_ruta int primary key, nombre1 text, nombre2 text,latitud1 text,latitud2 text,longitud1 text, longitud2 text)");
        BaseDeDatos.execSQL("create table tbl_paradas(id_paradsa int primary key,id_ruta int, nombre text, latitud text,longitud text,foreign key (id_ruta)references tbl_rutas(id_ruta)on delete cascade on update cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
