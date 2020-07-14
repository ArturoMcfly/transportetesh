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

public class gestorParadas extends AppCompatActivity {
    private EditText txtid, txtRuta,txtNombre,txtlatitud,txtlongitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_paradas);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        txtid=(EditText)findViewById(R.id.txtGestorIdParada);
        txtRuta=(EditText)findViewById(R.id.txtGestorRutaIdParada);
        txtNombre=(EditText)findViewById(R.id.txtGestorNombreParada);
        txtlatitud=(EditText)findViewById(R.id.txtLatitudParada);
        txtlongitud=(EditText)findViewById(R.id.txtLongitudParada);
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
                String v1=txtRuta.getText().toString();
                String v2=txtNombre.getText().toString();
                String v3=txtlatitud.getText().toString();
                String v4=txtlongitud.getText().toString();
                String v5;
                if(!v1.isEmpty()&&!v2.isEmpty()&&!v3.isEmpty()&&!v4.isEmpty()){
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "libreria", null, 1);
                    SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
                    int contador=1;
                    int bucle=1;
                    v5=""+contador;
                    do {

                        Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_paradas where id_paradsa =" + v5 + "", null);
                        if (fila.getCount() > 0) {
                            contador++;
                            v5=""+contador;
                            Toast.makeText(this, ""+v5, Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(this, ""+v5, Toast.LENGTH_SHORT).show();
                            bucle=0;
                        }
                    }while(bucle!=0);
                    ContentValues registro = new ContentValues();
                    registro.put("id_paradsa", v5);
                    registro.put("id_ruta", v1);
                    registro.put("nombre", v2);
                    registro.put("latitud", v3);
                    registro.put("longitud", v4);
                    BaseDeDatos.insert("tbl_paradas", null, registro);
                    BaseDeDatos.close();
                    Toast.makeText(this, "El registro se ha guardado", Toast.LENGTH_SHORT).show();
                    txtRuta.setText("");
                    txtNombre.setText("");
                    txtlatitud.setText("");
                    txtlongitud.setText("");
                }
                break;
            }
            case R.id.icon_delete:{
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                String v1=txtid.getText().toString();

                if(!v1.isEmpty()){
                    int cant=BaseDeDatos.delete("tbl_paradas","id_paradsa="+v1,null);
                    BaseDeDatos.close();
                    txtid.setText("");
                    txtRuta.setText("");
                    txtNombre.setText("");
                    txtlatitud.setText("");
                    txtlongitud.setText("");

                    Toast.makeText(this, "El registro fue eliminado" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "debes llenar todos los campos" , Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.icon_update:{
                String v5=txtid.getText().toString();
                String v1=txtRuta.getText().toString();
                String v2=txtNombre.getText().toString();
                String v3=txtlatitud.getText().toString();
                String v4=txtlongitud.getText().toString();
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                if(!v1.isEmpty()&&!v2.isEmpty()&&!v3.isEmpty()&&!v4.isEmpty()&&!v5.isEmpty()) {

                    ContentValues registro=new ContentValues();
                    registro.put("id_paradsa", v5);
                    registro.put("id_ruta", v1);
                    registro.put("nombre", v2);
                    registro.put("latitud", v3);
                    registro.put("longitud", v4);
                    int cantidad=BaseDeDatos.update("tbl_paradas",registro,"id_paradsa="+v5,null);
                    BaseDeDatos.close();
                    if(cantidad==1){
                        txtid.setText("");
                        txtRuta.setText("");
                        txtNombre.setText("");
                        txtlatitud.setText("");
                        txtlongitud.setText("");
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
                    Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_paradas where id_paradsa=" + v1, null);
                    if (fila.moveToFirst()) {
                        txtRuta.setText(fila.getString(1));
                        txtNombre.setText(fila.getString(2));
                        txtlatitud.setText(fila.getString(3));
                        txtlongitud.setText(fila.getString(4));


                        BaseDeDatos.close();
                    }
                    else {
                        Toast.makeText(this, "No existe la parada solicitada" , Toast.LENGTH_SHORT).show();

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
