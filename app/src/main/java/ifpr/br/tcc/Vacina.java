package ifpr.br.tcc;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Vacina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacina);
    }
    public void irAdicionarVacina(View view){
        Intent vacinafds = new Intent(Vacina.this, AddVacina.class );
        startActivity(vacinafds);

    }

}
