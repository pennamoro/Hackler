package ifpr.br.tcc;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Comida extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 5000; //8horas

    private ImageButton mButtonInformacoes;

    private CountDownTimer mContagem;

    private long mTempoRestanteEmMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);

        startTimer();

    }


    public void startTimer() {
        mContagem = new CountDownTimer(mTempoRestanteEmMillis, 1000 ) { //1 min
            @Override
            public void onTick(long  millisAteTerminar) {
                mTempoRestanteEmMillis = millisAteTerminar;
            }

            @Override
            public void onFinish() {
                resetTimer();
                startTimer();
                Toast.makeText(getApplicationContext(),"zap", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void resetTimer() {
        mContagem.cancel();
        mTempoRestanteEmMillis = START_TIME_IN_MILLIS;
    }

}
