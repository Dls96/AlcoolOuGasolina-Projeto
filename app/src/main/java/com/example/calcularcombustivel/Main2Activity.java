package com.example.calcularcombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    //Instânciando as classes...
    EditText editTextGasolina,editTextAlcool;
    Button btnCalcular;
    TextView textViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Localizando as widgets
        editTextAlcool = findViewById(R.id.editAlcool);
        editTextGasolina = findViewById(R.id.editGasolina);
        btnCalcular = findViewById(R.id.buttonCalcular);
        textViewRes = findViewById(R.id.textViewRes);

        //Função ao clique do botão
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criando variaveis que irão pegar o texto escrito nas caixas de preço
                final String verificaEditAlcool = editTextAlcool.getText().toString();
                final String verificaEditGasolina = editTextGasolina.getText().toString();

                //Criando variáveis que irão pegar o valor escrito nas caixas de preço e transformá-las em float.
                final Float precoAlcool = Float.valueOf(verificaEditAlcool);
                final Float precoGasolina = Float.valueOf(verificaEditGasolina);

                //Variável que irá guardar o resultado do cálculo
                final Float resCalculo = precoAlcool / precoGasolina;

                //verificando se o usuário deixou alguma caixa vazia
                if(verificaEditAlcool.equals("") || verificaEditGasolina.equals("")){
                    Toast.makeText(getApplicationContext(),"Verifique os campos primeiro.",Toast.LENGTH_LONG).show();
                }else{
                    // se as caixas estiverem completas...
                    if(resCalculo > 0.7){
                        //Mostra ao usuário o texto abaixo se o resultado for maior que 0.7
                        textViewRes.setText("Melhor abastecer com Gasolina !");
                    }else{
                        //Se não, mostra o texto abaixo.
                        textViewRes.setText("Abasteça com Álcool");
                    }
                }
            }
        });
    }
}