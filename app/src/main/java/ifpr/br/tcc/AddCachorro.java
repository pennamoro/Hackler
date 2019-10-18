package ifpr.br.tcc;

import androidx.appcompat.app.AppCompatActivity;
import ifpr.br.tcc.Login.DBHelper;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

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


    //Método que adiciona um novo cachorro
    // nome,idade,peso,altura,raça
  /*  public void cadastrarCachorro(View view) throws IOException{

        EditText nomeCadastroCachorro = (EditText) findViewById(R.id.nomeCadastroCachorro);
        String nomeCachorro = nomeCadastroCachorro.getText().toString();

        EditText idadeCadastroCachorro = (EditText) findViewById(R.id.idadeCadastroCachorro);
        String idadeCachorro = idadeCadastroCachorro.getText().toString();

        EditText pesoCadastroCachorro = (EditText) findViewById(R.id.pesoCadastroCachorro);
        String pesoCachorro = pesoCadastroCachorro.getText().toString();

        EditText alturaCadastroCachorro = (EditText) findViewById(R.id.alturaCadastroCachorro);
        String alturaCachorro = alturaCadastroCachorro.getText().toString();

        EditText racaCadastroCachorro = (EditText) findViewById(R.id.racaCadastroCachorro);
        String racaCachorro = racaCadastroCachorro.getText().toString();

        int resposta = DBHelper.insertIntoCachorro(id,dono_email, nome, idade, porte, raca);



    }
*/
}
