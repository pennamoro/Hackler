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


       int resposta = DBHelper.insertIntoCachorro(nomeCachorro, idadeCachorro, pesoCachorro, alturaCachorro, racaCadastro);

        if(resposta ==  1){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

            Intent addCachorro = new Intent(this, Cachorro.class);
            startActivity(addCachorro);
        }

        if(resposta == 0){
            Toast.makeText(this, "Cadastro falhou!", Toast.LENGTH_SHORT).show();

            Intent naoAddCachorro = new Intent(this, Cachorro.class);
            startActivity(naoAddCachorro);
        }
    }

}
