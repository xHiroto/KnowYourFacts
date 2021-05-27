package sg.edu.rp.c346.id19045784.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Frag1 extends Fragment {

    Button btnChangeColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        btnChangeColor = getView().findViewById(R.id.btnChangeColor);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getView().setBackgroundColor(Color.parseColor("#BFDBFF"));
            }
        });
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        return view;
    }
}