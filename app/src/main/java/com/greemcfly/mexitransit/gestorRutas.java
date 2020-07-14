package com.greemcfly.mexitransit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class gestorRutas extends AppCompatActivity {
    private EditText txtid, txtNombre1,txtNombre2,txtlatitud1,txtlatitud2,txtLongitud1,txtLongitud2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_rutas);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        txtid=(EditText)findViewById(R.id.txtIdRuta);
        txtNombre1=(EditText)findViewById(R.id.txtNombreUno);
        txtNombre2=(EditText)findViewById(R.id.txtNombreDos);
        txtlatitud1=(EditText)findViewById(R.id.txtLatitudUno);
        txtlatitud2=(EditText)findViewById(R.id.txtLatitudDos);
        txtLongitud1=(EditText)findViewById(R.id.txtLongitudUno);
        txtLongitud2=(EditText)findViewById(R.id.txtLongitudDos);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_retorno:{
                Intent i=new Intent(this,menuAdmin.class);

                startActivity(i);
                break;
            }
            case R.id.icon_save:{
                String v1=txtNombre1.getText().toString();
                String v2=txtNombre2.getText().toString();
                String v3=txtlatitud1.getText().toString();
                String v4=txtlatitud2.getText().toString();
                String v5=txtLongitud1.getText().toString();
                String v6=txtLongitud2.getText().toString();
                String v7;
                if(!v1.isEmpty()&&!v2.isEmpty()&&!v3.isEmpty()&&!v4.isEmpty()&&!v5.isEmpty()&&!v6.isEmpty()){
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "libreria", null, 1);
                    SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
                    int contador=1;
                    int bucle=1;
                    v7=""+contador;
                    do {

                        Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_rutas where id_ruta =" + v7 + "", null);
                        if (fila.getCount() > 0) {
                            contador++;
                            v7=""+contador;
                            Toast.makeText(this, ""+v7, Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(this, ""+v7, Toast.LENGTH_SHORT).show();
                            bucle=0;
                        }
                    }while(bucle!=0);
                    ContentValues registro = new ContentValues();
                    registro.put("id_ruta", v7);
                    registro.put("nombre1", v1);
                    registro.put("nombre2", v2);
                    registro.put("latitud1", v3);
                    registro.put("latitud2", v4);
                    registro.put("longitud1", v5);
                    registro.put("longitud2", v6);

                    BaseDeDatos.insert("tbl_rutas", null, registro);
                    BaseDeDatos.close();
                    Toast.makeText(this, "El registro se ha guardado", Toast.LENGTH_SHORT).show();
                    txtNombre1.setText("");
                    txtNombre2.setText("");
                    txtlatitud2.setText("");
                    txtlatitud1.setText("");
                    txtLongitud1.setText("");
                    txtLongitud2.setText("");
                }
                break;
            }
            case R.id.icon_delete:{
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                String v1=txtid.getText().toString();

                if(!v1.isEmpty()){
                    int cant=BaseDeDatos.delete("tbl_rutas","id_ruta="+v1,null);
                    BaseDeDatos.close();
                    txtid.setText("");
                    txtNombre1.setText("");
                    txtNombre2.setText("");
                    txtlatitud1.setText("");
                    txtlatitud2.setText("");
                    txtLongitud2.setText("");
                    txtLongitud2.setText("");

                    Toast.makeText(this, "El registro fue eliminado" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "debes llenar todos los campos" , Toast.LENGTH_SHORT).show();
                }



                break;
            }
            case R.id.icon_update:{
                String v7=txtid.getText().toString();
                String v1=txtNombre1.getText().toString();
                String v2=txtNombre2.getText().toString();
                String v3=txtlatitud1.getText().toString();
                String v4=txtlatitud2.getText().toString();
                String v5=txtLongitud1.getText().toString();
                String v6=txtLongitud2.getText().toString();
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                if(!v1.isEmpty()&&!v2.isEmpty()&&!v3.isEmpty()&&!v4.isEmpty()&&!v5.isEmpty()) {

                    ContentValues registro=new ContentValues();
                    registro.put("id_ruta", v7);
                    registro.put("nombre1", v1);
                    registro.put("nombre2", v2);
                    registro.put("latitud1", v3);
                    registro.put("latitud2", v4);
                    registro.put("longitud1", v5);
                    registro.put("longitud2", v6);
                    int cantidad=BaseDeDatos.update("tbl_rutas",registro,"id_ruta="+v5,null);
                    BaseDeDatos.close();
                    if(cantidad==1){
                        txtid.setText("");
                        txtNombre1.setText("");
                        txtNombre2.setText("");
                        txtlatitud2.setText("");
                        txtlatitud1.setText("");
                        txtLongitud1.setText("");
                        txtLongitud2.setText("");
                        Toast.makeText(this, "se modifico con exito" , Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "no exite el registro" , Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Necesitas llenar todos los campos" , Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.icon_find:{
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                String v1=txtid.getText().toString();
                if(!v1.isEmpty()) {
                    Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_rutas where id_ruta=" + v1, null);
                    if (fila.moveToFirst()) {
                        txtNombre1.setText(fila.getString(1));
                        txtNombre2.setText(fila.getString(2));
                        txtlatitud1.setText(fila.getString(3));
                        txtlatitud2.setText(fila.getString(4));
                        txtLongitud1.setText(fila.getString(5));
                        txtLongitud2.setText(fila.getString(6));



                        BaseDeDatos.close();
                    }
                    else {
                        Toast.makeText(this, "No existe la ruta solicitada" , Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(this, "debes llenar todos los campos" , Toast.LENGTH_SHORT).show();
                }
                break;
            }
            default: {
                break;
            }
        }
        return true;
    }
}
