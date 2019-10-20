package ifpr.br.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import ifpr.br.tcc.Login.DBHelper;

public class AddCachorro extends AppCompatActivity {
    private void enabledFullScreenMode(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enabledFullScreenMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cachorro);
    }

    public void cadastrarCachorro(View view) throws IOException {
        EditText nomeCadastroCachorro = findViewById(R.id.nomeCadastroCachorro);
        String nome = nomeCadastroCachorro.getText().toString();

        EditText idadeCadastroCachorro = findViewById(R.id.idadeCadastroCachorro);
        String idade = idadeCadastroCachorro.getText().toString();

        EditText pesoCadastroCachorro =  findViewById(R.id.pesoCadastroCachorro);
        String peso = pesoCadastroCachorro.getText().toString();

        EditText alturaCadastroCachorro = findViewById(R.id.alturaCadastroCachorro);
        String altura = alturaCadastroCachorro.getText().toString();

        EditText racaCadastroCachorro = findViewById(R.id.racaCadastroCachorro);
        String raca = nomeCadastroCachorro.getText().toString();


        int resposta = DBHelper.insertIntoCachorro(nome, idade, peso, altura, raca);

        if(resposta ==  1){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        }
        if(resposta == 0){
            Toast.makeText(this, "Cadastro falhou!", Toast.LENGTH_SHORT).show();
        }


}}
