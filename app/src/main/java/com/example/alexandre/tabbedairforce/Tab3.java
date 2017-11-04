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

public class Tab3 extends Fragment {

    private View rootView;

    /* une fois instanciée, il est plus facile d'agir sur son contenu car la vue est créée */
    private static Tab3 _tab;

    public static Tab3 getInstance(){
        if( _tab == null)
            _tab = new Tab3();
        return _tab;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab3, container, false);
        updateFragment();
        return rootView;
    }

    public void updateFragment(){

        if (!TextUtils.isEmpty(Constantes.alt) && !TextUtils.isEmpty(Constantes.qnhS) && !TextUtils.isEmpty(Constantes.TempS)) {
            int altAD = Integer.parseInt(alt);
            int QNH = Integer.parseInt(qnhS);
            int Temp = Integer.parseInt(TempS);
            int[] resultats = LandingCalculation.calculation("Dur", altAD, QNH, Temp);
            ((TextView) rootView.findViewById(R.id.LR7)).setText(Integer.toString(resultats[3]));
            ((TextView) rootView.findViewById(R.id.LD7)).setText(Integer.toString(resultats[2]));
            ((TextView) rootView.findViewById(R.id.LR9)).setText(Integer.toString(resultats[1]));
            ((TextView) rootView.findViewById(R.id.LD9)).setText(Integer.toString(resultats[0]));
            resultats = LandingCalculation.calculation("Herbe", altAD, QNH, Temp);
            ((TextView) rootView.findViewById(R.id.LR7B)).setText(Integer.toString(resultats[3]));
            ((TextView) rootView.findViewById(R.id.LD7B)).setText(Integer.toString(resultats[2]));
            ((TextView) rootView.findViewById(R.id.LR9B)).setText(Integer.toString(resultats[1]));
            ((TextView) rootView.findViewById(R.id.LD9B)).setText(Integer.toString(resultats[0]));
        } else {
            ((TextView) rootView.findViewById(R.id.LR7)).setText("?");
            ((TextView) rootView.findViewById(R.id.LD7)).setText("?");
            ((TextView) rootView.findViewById(R.id.LR9)).setText("?");
            ((TextView) rootView.findViewById(R.id.LD9)).setText("?");
            ((TextView) rootView.findViewById(R.id.LR7B)).setText("?");
            ((TextView) rootView.findViewById(R.id.LD7B)).setText("?");
            ((TextView) rootView.findViewById(R.id.LR9B)).setText("?");
            ((TextView) rootView.findViewById(R.id.LD9B)).setText("?");
        }
    }

}
