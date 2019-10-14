package ifpr.br.tcc.Card;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import ifpr.br.tcc.Agua;
import ifpr.br.tcc.Cachorro;
import ifpr.br.tcc.Comida;
import ifpr.br.tcc.R;
import ifpr.br.tcc.Vacina;

public class CardFragment extends Fragment {

    private CardView cardView;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        ImageView icone = (ImageView) view.findViewById(R.id.icone);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView text = (TextView) view.findViewById(R.id.text);
        Button button = (Button)view.findViewById(R.id.button);

        if (getArguments().getInt("position" ) == 0 ) {
            title.setText(String.format("Dog"));
            text.setText (String.format("Informações sobre seu cão"));
            icone.setImageResource(R.drawable.paw);
            button.setText(String.format("Cachorro"));
        }
        else if (getArguments().getInt("position" ) == 1 ) {
            title.setText(String.format("Vacinas"));
            text.setText (String.format("Quais vacinas ele já tomou ou precisa tomar?"));
            icone.setImageResource(R.drawable.vacina);
            button.setText(String.format("Vacina"));
        }
        else if (getArguments().getInt("position" ) == 2 ) {
            title.setText(String.format("Água"));
            text.setText (String.format("Quanto de Água se deve dar?"));
            icone.setImageResource(R.drawable.agua);
            button.setText(String.format("Água"));
        }
        else if (getArguments().getInt("position" ) == 3 ) {
            title.setText(String.format("Comida"));
            text.setText (String.format("Quanto de comida dar para seu cão?"));
            icone.setImageResource(R.drawable.comida);
            button.setText(String.format("Comida"));
        }
        /*else if (getArguments().getInt("position" ) == 4 ) {
            title.setText(String.format("Configurações"));
            text.setText (String.format("Configurações do app"));
            icone.setImageResource(R.drawable.config);
        }*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getArguments().getInt("position" ) == 0 ) {
                    Intent intentdog = new Intent(getContext(), Cachorro.class);
                    startActivity(intentdog);
                }
                else if (getArguments().getInt("position" ) == 1) {
                    Intent intentdog = new Intent(getContext(), Vacina.class);
                    startActivity(intentdog);
                }
                else if (getArguments().getInt("position" ) == 2 ) {
                    Intent intentdog = new Intent(getContext(), Agua.class);
                    startActivity(intentdog);
                }
                else if (getArguments().getInt("position" ) == 3) {
                    Intent intentdog = new Intent(getContext(), Comida.class);
                    startActivity(intentdog);
                }




            }
        });

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}