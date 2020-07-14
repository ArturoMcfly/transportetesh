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

public class gestorUsuario extends AppCompatActivity {
    private EditText txtid, txtNombre,txtCoreo,txtTipo,txtContrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestor_usuario);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        txtid=(EditText)findViewById(R.id.txtGestorIdUsuario);
        txtNombre=(EditText)findViewById(R.id.txtGestorNombreUsuario);
        txtCoreo=(EditText)findViewById(R.id.txtGestorCorreoUsuario);
        txtTipo=(EditText)findViewById(R.id.txtGestorTipoUsuario);
        txtContrasenia=(EditText)findViewById(R.id.txtGestorcontraseniaUsuario);
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
                String v1=txtNombre.getText().toString();
                String v2=txtCoreo.getText().toString();
                String v3=txtTipo.getText().toString();
                String v4=txtContrasenia.getText().toString();
                String v5;
                if(!v1.isEmpty()&&!v2.isEmpty()&&!v3.isEmpty()&&!v4.isEmpty()){
                    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "libreria", null, 1);
                    SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
                    int contador=1;
                    int bucle=1;
                    v5=""+contador;
                    do {

                        Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_usuario where id_usuario =" + v5 + "", null);
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
                    registro.put("id_usuario", v5);
                    registro.put("nombre", v1);
                    registro.put("correo", v2);
                    registro.put("tipo", v3);
                    registro.put("contrasenia", v4);
                    BaseDeDatos.insert("tbl_usuario", null, registro);
                    BaseDeDatos.close();
                    Toast.makeText(this, "El registro se ha guardado", Toast.LENGTH_SHORT).show();
                    txtNombre.setText("");
                    txtCoreo.setText("");
                    txtContrasenia.setText("");
                    txtTipo.setText("");
                }

                break;
            }
            case R.id.icon_delete:{
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                String v1=txtid.getText().toString();

                if(!v1.isEmpty()){
                    int cant=BaseDeDatos.delete("tbl_usuario","id_usuario="+v1,null);
                    BaseDeDatos.close();
                    txtid.setText("");
                    txtNombre.setText("");
                    txtCoreo.setText("");
                    txtTipo.setText("");
                    txtContrasenia.setText("");

                    Toast.makeText(this, "El registro fue eliminado" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "debes llenar todos los campos" , Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.icon_update:{
                String v5=txtid.getText().toString();
                String v1=txtNombre.getText().toString();
                String v2=txtCoreo.getText().toString();
                String v3=txtTipo.getText().toString();
                String v4=txtContrasenia.getText().toString();
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"libreria",null,1);
                SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
                if(!v1.isEmpty()&&!v2.isEmpty()&&!v3.isEmpty()&&!v4.isEmpty()&&!v5.isEmpty()) {

                    ContentValues registro=new ContentValues();
                    registro.put("id_usuario",v5);
                    registro.put("nombre",v1);
                    registro.put("correo",v2);
                    registro.put("tipo",v3);
                    registro.put("contrasenia",v4);
                    int cantidad=BaseDeDatos.update("tbl_usuario",registro,"id_usuario="+v5,null);
                    BaseDeDatos.close();
                    if(cantidad==1){
                        txtid.setText("");
                        txtNombre.setText("");
                        txtTipo.setText("");
                        txtCoreo.setText("");
                        txtContrasenia.setText("");
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
                    Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_usuario where id_usuario=" + v1, null);
                    if (fila.moveToFirst()) {
                        txtNombre.setText(fila.getString(1));
                        txtCoreo.setText(fila.getString(2));
                        txtTipo.setText(fila.getString(3));
                        txtContrasenia.setText(fila.getString(4));


                        BaseDeDatos.close();
                    }
                    else {
                        Toast.makeText(this, "No existe el usuario" , Toast.LENGTH_SHORT).show();

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
