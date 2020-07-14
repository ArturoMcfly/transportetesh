package com.greemcfly.mexitransit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class menuAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_retorno:{
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            }
            case R.id.icon_map:{
                Intent i=new Intent(this,rutasSistema.class);
                startActivity(i);
                break;
            }
            case R.id.icon_ruta:{
                Intent i=new Intent(this,rutasMapa.class);
                startActivity(i);
                break;
            }
            case R.id.icon_Salir:{
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            }
            default: {
                break;
            }
        }

        return true;
    }
    public void usuarios(View view){
        Intent i=new Intent(this,gestorUsuario.class);
        startActivity(i);
    }
    public void ruta(View view){
        Intent i=new Intent(this,gestorRutas.class);
        startActivity(i);
    }
    public void paradas(View view){
        Intent i=new Intent(this,gestorParadas.class);
        startActivity(i);
    }
}
