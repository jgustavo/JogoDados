package com.jgnsoftware.jogodados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextValor = (EditText) findViewById(R.id.editTextValor);
    }

    public void onClick(View view) {
        Intent intent = new Intent( LoginActivity.this , MainActivity.class );
        intent.putExtra("nome",editTextNome.getEditableText().toString());
        intent.putExtra("valor",Float.valueOf(editTextValor.getEditableText().toString()));
        startActivity(intent);
    }
}
