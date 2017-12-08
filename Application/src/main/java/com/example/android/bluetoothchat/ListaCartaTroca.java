package com.example.android.bluetoothchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.common.pokemon.Carta;
import com.example.android.services.CriarListaObjetosServico;

import java.util.List;


/**
 * Created by User on 08/12/2017.
 */

public class ListaCartaTroca extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cartas_troca);

        List<Carta> cartasParaTroca = CriarListaObjetosServico.cartasParaTroca;
        ListView listaDeCartas = (ListView) findViewById(R.id.listaCartasTroca);
        ArrayAdapter<Carta> adapter = new ArrayAdapter<Carta>(this, android.R.layout.simple_list_item_1,cartasParaTroca);
        listaDeCartas.setAdapter(adapter);

        listaDeCartas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int idCartaParaTrocar = (int) adapterView.getAdapter().getItemId(i);
                Carta carta = CriarListaObjetosServico.cartas.get(idCartaParaTrocar);
                CriarListaObjetosServico.cartas.remove(carta);
                CriarListaObjetosServico.cartas.add(CriarListaObjetosServico.cartasParaTroca.get(CriarListaObjetosServico.cartaRecebida));

                MainActivity.fragment.sendMessage(String.valueOf(idCartaParaTrocar));
            }
        });
    }
}

