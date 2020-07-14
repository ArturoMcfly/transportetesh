package com.greemcfly.mexitransit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Poner el icono
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        txt1=(EditText)findViewById(R.id.txtNombre);
        txt2=(EditText)findViewById(R.id.txtContrasenia);
    }



    public void inicio(View view){
        String usuario=txt1.getText().toString();
        String contra=txt2.getText().toString();
        if(!usuario.isEmpty()&&!contra.isEmpty()){
            AdminSQLiteOpenHelper admin=new com.greemcfly.mexitransit.AdminSQLiteOpenHelper(this,"libreria",null,1);
            SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();
            Cursor fila=BaseDeDatos.rawQuery("Select * from tbl_usuario where nombre like '"+usuario+"'and contrasenia like'"+contra+"'",null);
            if(fila.moveToFirst()) {
                String id = fila.getString(0);
                String usuarioCargado = fila.getString(1);
                String correo=fila.getString(2);
                String tipo = fila.getString(3);
                String contrasenia = fila.getString(4);
                BaseDeDatos.close();
                Toast.makeText(this, "bienvenido"+usuarioCargado , Toast.LENGTH_SHORT).show();
                if(tipo.equals("Administrador")){
                    Intent registrar=new Intent(this,menuAdmin.class);
                    registrar.putExtra("dato",id);
                    startActivity(registrar);
                    Toast.makeText(this, "bienvenido" , Toast.LENGTH_SHORT).show();
                }else {
                    Intent registrar = new Intent(this,menu.class);
                    registrar.putExtra("dato", id);
                    startActivity(registrar);
                    Toast.makeText(this, "bienvenido", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "usuario y/o contraseña incorrectos" , Toast.LENGTH_SHORT).show();
            }


        }
        else {
            Toast.makeText(this, "llena todos campos", Toast.LENGTH_SHORT).show();

        }
    }
    public void Registro(View view){
        Intent i=new Intent(this,Registro.class);
        startActivity(i);
    }
}
