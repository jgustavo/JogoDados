package com.jgnsoftware.jogodados;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    Float saldo = 1000.00f;
    Spinner spinner;
    Button buttonJogar;
    TextView textViewNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        buttonJogar = (Button) findViewById(R.id.button);
        textViewNome = (TextView) findViewById(R.id.textViewNome);

        textViewDinheiro = (TextView) findViewById(R.id.textViewDinheiro);
        spinner = (Spinner) findViewById(R.id.spinner);

        List<String> numeros = Arrays.asList("1","2","3","4","5","6");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                        numeros);
        spinner.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        String nome = extras.getString("nome");
        float valor = extras.getFloat("valor");
        saldo = valor;
        textViewNome.setText(nome);
        textViewDinheiro.setText("R$ " + String.format("%.2f",saldo));

    }

    public void playDice(View view) {
        Random r = new Random();
        int valorSorteado = r.nextInt(6)+1;
        int id = R.drawable.dado1;
        //textView.setText(String.valueOf(valorSorteado));

        switch (valorSorteado) {
            case 1: id = R.drawable.dice1;
            break;
            case 2: id = R.drawable.dice2;
            break;
            case 3: id = R.drawable.dice3;
            break;
            case 4: id = R.drawable.dice4;
            break;
            case 5: id = R.drawable.dice5;
            break;
            case 6: id = R.drawable.dice6;
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

        textViewDinheiro.setText("R$ " + String.format("%.2f",saldo));

        Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT );
        toast.show();
        if (saldo <=0) {
            showDialog();
        }


    }



    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Game Over!!!!!");
        builder.setMessage("Seu dinheiro acabou. Deseja Continuar?");

        builder.setPositiveButton(" Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                    saldo = 1000f;
                 }
        });
        builder.setNegativeButton(" Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                    buttonJogar.setEnabled(false);
                    Intent intent = new Intent( MainActivity.this , LoginActivity.class );
                    startActivity(intent);
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
