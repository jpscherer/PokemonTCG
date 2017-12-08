package com.example.android.bluetoothchat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.services.CriarListaObjetosServico;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gabriela.sena on 08/12/2017.
 */

public class InfoCarta extends Activity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_carta);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String url = bundle.getString("imgURL");
        final int idCarta = bundle.getInt("idCarta");

        final String urlAux = url;

        new Thread(){
            public void run(){
                Bitmap bitmapImagem = null;
                try{
                    URL url = new URL(urlAux);
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    InputStream input = conexao.getInputStream();
                    bitmapImagem = BitmapFactory.decodeStream(input);
                }catch(Exception e){
                    Log.i("myExceptionTag", e.getMessage());
                }

                final Bitmap bitmap = bitmapImagem;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imagem = (ImageView) findViewById(R.id.imgCarta);
                        imagem.setVisibility(View.VISIBLE);
                        imagem.setImageBitmap(bitmap);
                    }
                });
            }
        }.start();

        Button btnTrocar = (Button) findViewById(R.id.btnTrocar);
        btnTrocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CriarListaObjetosServico.isTrocando = true){
                    MainActivity.fragment.sendMessage(String.valueOf(idCarta)+"|trocar");
                } else {
                    MainActivity.fragment.sendMessage(String.valueOf(idCarta));
                }

            }
        });
    }
}
