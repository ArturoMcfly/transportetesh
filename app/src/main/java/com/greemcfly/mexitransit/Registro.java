package com.greemcfly.mexitransit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
private EditText txtNombreRegistro,txtCorreoRegistro, txtContraseniaRegistro;
    private String TipoDeUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        txtNombreRegistro=(EditText)findViewById(R.id.txtNombreRegistro);
        txtCorreoRegistro=(EditText)findViewById(R.id.txtCorreoRegistro);
        txtContraseniaRegistro=(EditText)findViewById(R.id.txtContraseniaRegistro);

    }
    public void guardar(View view){
        String registroNombre=txtNombreRegistro.getText().toString();
        String registroCorreo=txtCorreoRegistro.getText().toString();
        String registroContrasenia=txtContraseniaRegistro.getText().toString();
        String registroIdUsuario;
        if(registroNombre.equals("Arturo admin")||registroNombre.equals("Alberto admin")){
            TipoDeUsuario="Administrador";
        }else{
            TipoDeUsuario="Usuario";
        }
        if(!registroNombre.isEmpty()&&!registroCorreo.isEmpty()&&!registroContrasenia.isEmpty()){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "libreria", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            int contador=1;
            int bucle=1;
            registroIdUsuario=""+contador;
            do {

                Cursor fila = BaseDeDatos.rawQuery("Select * from tbl_usuario where id_usuario =" + registroIdUsuario + "", null);
                if (fila.getCount() > 0) {
                    contador++;
                    registroIdUsuario=""+contador;
                    Toast.makeText(this, ""+registroIdUsuario, Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(this, ""+registroIdUsuario, Toast.LENGTH_SHORT).show();
                    bucle=0;
                }
            }while(bucle!=0);
            ContentValues registro = new ContentValues();
            registro.put("id_usuario", registroIdUsuario);
            registro.put("nombre", registroNombre);
            registro.put("correo", registroCorreo);
            registro.put("tipo", TipoDeUsuario);
            registro.put("contrasenia", registroContrasenia);
            BaseDeDatos.insert("tbl_usuario", null, registro);
            BaseDeDatos.close();
            Toast.makeText(this, "El registro se ha guardado", Toast.LENGTH_SHORT).show();
            txtNombreRegistro.setText("");
            txtCorreoRegistro.setText("");
            txtContraseniaRegistro.setText("");
        }else{
            Toast.makeText(this, "Necesitas llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void login(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
