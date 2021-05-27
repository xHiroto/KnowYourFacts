package sg.edu.rp.c346.id19045784.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag2 extends Fragment {

    Button btnChangeColour;
    TextView tv2;
    LinearLayout ll2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        ll2 = view.findViewById(R.id.ll2);
        tv2 = view.findViewById(R.id.frag2TV);
        btnChangeColour = view.findViewById(R.id.changeColorBtn);

        btnChangeColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Random is to randomise an integer
                Random random = new Random();

                //from the integer, get the colour and then display it.
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

                ll2.setBackgroundColor(color);
            }
        });

        return view;


    }
}