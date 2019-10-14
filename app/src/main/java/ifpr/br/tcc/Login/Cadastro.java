package ifpr.br.tcc.Login;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import ifpr.br.tcc.R;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrarUsuario(View view) throws IOException {

        EditText nomeCadastro = (EditText) findViewById(R.id.nomeCadastro);
        String nome = nomeCadastro.getText().toString();

        EditText idadeCadastro = (EditText) findViewById(R.id.senhaCadastro);
        String idade = idadeCadastro.getText().toString();

        EditText emailCadastro = (EditText) findViewById(R.id.emailCadastro);
        String email = emailCadastro.getText().toString();

        EditText senhaCadastro = (EditText) findViewById(R.id.emailCadastro);
        String senha = senhaCadastro.getText().toString();

        EditText cepCadastro = (EditText) findViewById(R.id.emailCadastro);
        String cep = cepCadastro.getText().toString();


        int resposta = DBHelper.insertIntoUsuario(nome, idade,email,senha, cep);

        if(resposta ==  1){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        }
        if(resposta == 0){
            Toast.makeText(this, "Cadastro falhou!", Toast.LENGTH_SHORT).show();
        }
    }
}