package ifpr.br.tcc;

import androidx.appcompat.app.AppCompatActivity;
import ifpr.br.tcc.Login.DBHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

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
        String nomeCachorro = nomeCadastroCachorro.getText().toString();

        EditText idadeCadastroCachorro = findViewById(R.id.idadeCadastroCachorro);
        String idadeCachorro = idadeCadastroCachorro.getText().toString();

        EditText pesoCadastroCachorro = findViewById(R.id.pesoCadastroCachorro);
        String pesoCachorro = pesoCadastroCachorro.getText().toString();

        EditText alturaCadastroCachorro = findViewById(R.id.alturaCadastroCachorro);
        String alturaCachorro = alturaCadastroCachorro.getText().toString();

        EditText racaCadastroCachorro = findViewById(R.id.racaCadastroCachorro);
        String racaCadastro = racaCadastroCachorro.getText().toString();

        EditText peso = findViewById(R.id.pesoCadastroCachorro);
        String pesoString = pesoCadastroCachorro.getText().toString();
        Double pesoDouble = Double.parseDouble(pesoString);

        EditText altura = findViewById(R.id.alturaCadastroCachorro);
        String alturaString = alturaCadastroCachorro.getText().toString();
        Double alturaDouble = Double.parseDouble(alturaString);

        String porte = "";
        if(pesoDouble < 6 && alturaDouble <= 33){
            porte = "Mini";
        } else if(pesoDouble >= 6  && pesoDouble < 15 && alturaDouble > 33 && alturaDouble <= 43  ){
            porte = "Pequeno";
        } else if(pesoDouble >= 15 && pesoDouble < 25 && alturaDouble > 43 && alturaDouble <= 60){
            porte = "Médio";
        } else if(pesoDouble >= 25 && pesoDouble < 45 && alturaDouble > 60 && alturaDouble <= 70){
            porte = "Grande";
        } else if(pesoDouble >= 45 && pesoDouble < 90 && alturaDouble > 70){
            porte = "Gigante";
        }
        Bundle porteBundle = new Bundle();
        porteBundle.putString("porte", porte );


        int resposta = DBHelper.insertIntoCachorro(nomeCachorro, idadeCachorro, pesoCachorro, alturaCachorro, racaCadastro);

        if(resposta ==  1){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

            Intent addCachorro = new Intent(this, Cachorro.class);
            addCachorro.putExtras(porteBundle);
            startActivity(addCachorro);

        }

        if(resposta == 0){
            Toast.makeText(this, "Cadastro falhou!", Toast.LENGTH_SHORT).show();

            Intent naoAddCachorro = new Intent(this, Cachorro.class);
            startActivity(naoAddCachorro);
        }
    }



}
