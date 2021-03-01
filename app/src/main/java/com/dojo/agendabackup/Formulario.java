package com.dojo.agendabackup;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null) {
            toolbar.setTitle("Editar Contato");
            toolbar.setNavigationIcon(R.drawable.ic_back2_foreground);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavUtils.navigateUpFromSameTask(Formulario.this);
                }
            });
        }

        Contato meuContato = new Contato();
        meuContato.setNome("Rodrigo");
        meuContato.setEmail("Rodrigo@gmail.com");
        meuContato.setSite("www.Rodrigo.com");
        meuContato.setTelefone("12345");
        meuContato.setEndereco("Avenida");
        meuContato.setId(new Long(10));

        /*
        Log.i("meu Log ",meuContato.getNome());
        Log.i("meu Log ",meuContato.getEmail());
        Log.i("meu Log ",meuContato.getSite());
        Log.i("meu Log ",meuContato.getTelefone());
        Log.i("meu Log ",meuContato.getEndereco());
        Log.i("meu Log ", String.valueOf(meuContato.getId()));
        Log.i("meu Log ",meuContato.toString());
         */

        FormularioHelper helper = new FormularioHelper(this);
        helper.colocaNoFormulario(meuContato);

        Contato meuContato2 = new Contato();

        meuContato2 = helper.pegaContatoDoFormulario();

        Log.i("meu Log ",meuContato2.getNome());
        Log.i("meu Log ",meuContato2.getEmail());
        Log.i("meu Log ",meuContato2.getSite());
        Log.i("meu Log ",meuContato2.getTelefone());
        Log.i("meu Log ",meuContato2.getEndereco());
        Log.i("meu Log ", String.valueOf(meuContato2.getId()));
        Log.i("meu Log ",meuContato2.toString());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                finish();
                return false;
        }
            return super.onOptionsItemSelected(item);
    }
}