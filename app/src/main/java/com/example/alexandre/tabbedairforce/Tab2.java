package com.example.alexandre.tabbedairforce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.alexandre.tabbedairforce.Constantes.TempS;
import static com.example.alexandre.tabbedairforce.Constantes.alt;
import static com.example.alexandre.tabbedairforce.Constantes.qnhS;

/**
 * Created by alexandre on 21/10/17.
 */

public class Tab2 extends Fragment {

    private View rootView;

    /* une fois instanciée, il est plus facile d'agir sur son contenu car la vue est créée */
    private static Tab2 _tab;

    public static Tab2 getInstance(){
        if(_tab == null)
            _tab = new Tab2();
        return _tab;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab2, container, false);
        updateFragment();
        return rootView;
    }

    public void updateFragment(){

        if (!TextUtils.isEmpty(Constantes.alt) && !TextUtils.isEmpty(Constantes.qnhS) && !TextUtils.isEmpty(Constantes.TempS)) {
            int altAD = Integer.parseInt(alt);
            int QNH = Integer.parseInt(qnhS);
            int Temp = Integer.parseInt(TempS);
            int[] resultats = TakeOffCalculation.calculation("Dur", altAD, QNH, Temp);
            ((TextView) rootView.findViewById(R.id.R7)).setText(Integer.toString(resultats[3]));
            ((TextView) rootView.findViewById(R.id.D7)).setText(Integer.toString(resultats[2]));
            ((TextView) rootView.findViewById(R.id.R9)).setText(Integer.toString(resultats[1]));
            ((TextView) rootView.findViewById(R.id.D9)).setText(Integer.toString(resultats[0]));
            resultats = TakeOffCalculation.calculation("Herbe", altAD, QNH, Temp);
            ((TextView) rootView.findViewById(R.id.R7B)).setText(Integer.toString(resultats[3]));
            ((TextView) rootView.findViewById(R.id.D7B)).setText(Integer.toString(resultats[2]));
            ((TextView) rootView.findViewById(R.id.R9B)).setText(Integer.toString(resultats[1]));
            ((TextView) rootView.findViewById(R.id.D9B)).setText(Integer.toString(resultats[0]));
        } else {
            ((TextView) rootView.findViewById(R.id.R7)).setText("?");
            ((TextView) rootView.findViewById(R.id.D7)).setText("?");
            ((TextView) rootView.findViewById(R.id.R9)).setText("?");
            ((TextView) rootView.findViewById(R.id.D9)).setText("?");
            ((TextView) rootView.findViewById(R.id.R7B)).setText("?");
            ((TextView) rootView.findViewById(R.id.D7B)).setText("?");
            ((TextView) rootView.findViewById(R.id.R9B)).setText("?");
            ((TextView) rootView.findViewById(R.id.D9B)).setText("?");
        }
    }

}
