package com.teste.appjokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView escolhaApp = findViewById(R.id.escolhaApp);
        TextView textResultado = findViewById(R.id.textResultado);
        int numeroAleatorio = new Random().nextInt(3); // 0.1.2
        String[] opcoes = {
                "Pedra",
                "Papel",
                "Tesoura"
        };
        String opcaoApp = opcoes[numeroAleatorio];
        switch (opcaoApp) {
            case "Pedra":
                escolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                escolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                escolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")
        ) { //App Ganhador
            textResultado.setText("Você Perdeu :(");
        } else if (
                (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel") ||
                        (opcaoSelecionada == "Papel" && opcaoApp == "Pedra") ||
                        (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura")
        ) { //Usuario Ganhador
            textResultado.setText("Você Ganhou :)");
        }else { //Empate
            textResultado.setText("Empate :|");
        }

    }


    public void selecionarPedra(View view) {
        System.out.println("Pedra selecionada");
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view) {
        System.out.println("Papel selecionado");
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view) {
        System.out.println("Tesoura selecionada");
        this.opcaoSelecionada("Tesoura");
    }
}