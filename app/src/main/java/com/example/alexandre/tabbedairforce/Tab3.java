package com.example.alexandre.tabbedairforce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alexandre on 21/10/17.
 */

public class Tab3 extends Fragment {

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
        View rootView = inflater.inflate(R.layout.tab3, container, false);
        return rootView;
    }

}
