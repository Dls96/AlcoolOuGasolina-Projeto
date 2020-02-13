package com.example.calcularcombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Variável que guarda o valor de tempo em millis, do "Carregamento" da tela
    private static int SPLASH_LOAD = 3000;

    //Instânciando as classes
    AnimationDrawable animation; //Animation irá criar a animação do carregamento da progressbar
    ImageView imageLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Localizando a widget que é a imagem de loading.
        imageLoading = findViewById(R.id.imageLoading);

        //Retirando a barra superior e removendo a elevação dela
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setElevation(0);
        }

        //Função que irá fazer a contagem dada pela variável splash_load e então a 2ª activity será chamada
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_LOAD);

        //'Startando' a animação
        animation = (AnimationDrawable) imageLoading.getDrawable();
        animation.start();
    }
}
