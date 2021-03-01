package com.dojo.agendabackup;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContatoAdaptador extends BaseAdapter {

    private final List<Contato> contatos;
    private final Activity activity;

    public ContatoAdaptador(List<Contato> contatos, Activity activity) {
        this.contatos = contatos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.contatos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View linha = convertView;
        Contato contato = contatos.get(position);
        Bitmap bitmap;

        if(linha == null){
            linha = this.activity.getLayoutInflater().inflate(R.layout.celula_contato, parent , false);
        }

        TextView nome = linha.findViewById(R.id.nomeCelula);
        TextView email = linha.findViewById(R.id.emailCelula);
        TextView site = linha.findViewById(R.id.siteCelula);
        TextView endereco = linha.findViewById(R.id.enderecoCelula);
        TextView telefone = linha.findViewById(R.id.telefoneCelula);
        ImageView foto = linha.findViewById(R.id.fotoCelula);

        if(position%2 == 0){
            linha.setBackgroundColor(activity.getResources().getColor(R.color.corImpar));
        }else{
            linha.setBackgroundColor(activity.getResources().getColor(R.color.corPar));
        }

        nome.setText(contato.getNome());
        telefone.setText(contato.getTelefone());

        if(email != null){
            email.setText(contato.getEmail());
        }
        if(endereco != null){
            endereco.setText(contato.getEndereco());
        }
        if(site != null){
            site.setText(contato.getSite());
        }
        if(contato.getFoto() != null){
            bitmap = BitmapFactory.decodeFile(contato.getFoto());
        }else{
            bitmap = BitmapFactory.decodeResource(activity.getResources(),R.drawable.usuario);
        }
        foto.setImageBitmap(bitmap);

        return linha;
    }
}
