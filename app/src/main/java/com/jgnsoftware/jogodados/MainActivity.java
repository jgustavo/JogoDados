package com.jgnsoftware.jogodados;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    EditText editText;
    TextView textViewResultado;
    TextView textViewDinheiro;
    Float saldo = 200.00f;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        textViewDinheiro = (TextView) findViewById(R.id.textViewDinheiro);
        spinner = (Spinner) findViewById(R.id.spinner);

        List<String> numeros = Arrays.asList("1","2","3","4","5","6");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                        numeros);
        spinner.setAdapter(adapter);

    }

    public void playDice(View view) {
        Random r = new Random();
        int valorSorteado = r.nextInt(6)+1;
        int id = R.drawable.dado1;
        //textView.setText(String.valueOf(valorSorteado));

        switch (valorSorteado) {
            case 1: id = R.drawable.dado1;
            break;
            case 2: id = R.drawable.dado2;
            break;
            case 3: id = R.drawable.dado3;
            break;
            case 4: id = R.drawable.dado4;
            break;
            case 5: id = R.drawable.dado5;
            break;
            case 6: id = R.drawable.dado6;
        }

        imageView.setImageResource(id);

        int valorApostado = Integer.parseInt(spinner.getSelectedItem().toString());

        String mensagem = "";


        if (valorApostado == valorSorteado) {
            mensagem = "Você Ganhou!!!!!";
            saldo += 100;
        } else {
            mensagem = "Você Perdeu!!!!!";
            saldo -=100;
        }

        textViewDinheiro.setText("R$ " + String.valueOf(saldo));

        Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT );
        toast.show();
        if (saldo <=0) {
            showDialog();
        }


    }



    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" Mensagem de teste ");
        builder.setTitle(" Título da caixa ");
        builder.setPositiveButton(" Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Método executado ao pressionar o botão
                 }
        });
        builder.setNegativeButton(" Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Método executado ao pressionar o botão
                }
        });
        builder.setNeutralButton(" Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Método executado ao pressionar o botão
                 }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }








    public void jogar(View view) {



        int numero = Integer.parseInt(editText.getText().toString());

        Random r = new Random();

        int valorSorteado = r.nextInt(6)+1;

        textView.setText(String.valueOf(valorSorteado));


        imageView.setImageResource(R.drawable.dado2);



    }
}
