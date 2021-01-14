package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Componentes
    private TextView textGorjeta, textTotal, textPorcentagem;
    private EditText editValor;
    private SeekBar seekBarGorjeta;

    //dados
    private double porcentagem = 0, gorjeta, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        editValor = findViewById(R.id.valorId);
        textGorjeta = findViewById(R.id.gorjetaId);
        textTotal = findViewById(R.id.totalId);
        textPorcentagem = findViewById(R.id.porcentagemId);
        seekBarGorjeta = findViewById(R.id.seekBarId);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                porcentagem = i;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public  void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor!", Toast.LENGTH_LONG).show();
        } else {

            //converter string para double
            double valor = Double.parseDouble(valorRecuperado);
            gorjeta = valor * porcentagem / 100;
            total = valor + gorjeta;

            textGorjeta.setText("R$: " + Math.round(gorjeta));
            textTotal.setText("R$: " + total);

        }

    }

    public void clickLogo(View view){
        Toast.makeText(this, "Desenvolvido pelo Lucas Vieira!", Toast.LENGTH_SHORT).show();
    }
}