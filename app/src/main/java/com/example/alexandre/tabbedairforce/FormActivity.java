package com.example.alexandre.tabbedairforce;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FormActivity extends Fragment {

    private static final String TAG = "TakeOffLog";
    protected TextWatcher myTextWatcher;

    private static String makeFragmentName(int viewPagerId, int index) {
        return "android:switcher:" + viewPagerId + ":" + index;
    }

    protected void callCalculation(View view) {



        String alt = ((EditText) view.findViewById(R.id.editTextAltitude)).getText().toString();
        String qnhS = ((EditText) view.findViewById(R.id.editTextQNH)).getText().toString();
        String TempS = ((EditText) view.findViewById(R.id.editTextTemp)).getText().toString();

        FragmentManager fragMan = getActivity().getSupportFragmentManager();
        Tab2 tab2 =  (Tab2) fragMan.findFragmentById(R.id.container);

        if (!TextUtils.isEmpty(alt) && !TextUtils.isEmpty(qnhS) && !TextUtils.isEmpty(TempS)) {
            int altAD = Integer.parseInt(alt);
            int QNH = Integer.parseInt(qnhS);
            int Temp = Integer.parseInt(TempS);
            int[] resultats = TakeOffCalculation.calculation("Dur", altAD, QNH, Temp);
            ((TextView) tab2.getView().findViewById(R.id.R7)).setText(Integer.toString(resultats[3]));
            ((TextView) tab2.getView().findViewById(R.id.D7)).setText(Integer.toString(resultats[2]));
            ((TextView) tab2.getView().findViewById(R.id.R9)).setText(Integer.toString(resultats[1]));
            ((TextView) tab2.getView().findViewById(R.id.D9)).setText(Integer.toString(resultats[0]));
            resultats = TakeOffCalculation.calculation("Herbe", altAD, QNH, Temp);
            ((TextView) tab2.getView().findViewById(R.id.R7B)).setText(Integer.toString(resultats[3]));
            ((TextView) tab2.getView().findViewById(R.id.D7B)).setText(Integer.toString(resultats[2]));
            ((TextView) tab2.getView().findViewById(R.id.R9B)).setText(Integer.toString(resultats[1]));
            ((TextView) tab2.getView().findViewById(R.id.D9B)).setText(Integer.toString(resultats[0]));
        }else {
            ((TextView) tab2.getView().findViewById(R.id.R7)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.D7)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.R9)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.D9)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.R7B)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.D7B)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.R9B)).setText("?");
            ((TextView) tab2.getView().findViewById(R.id.D9B)).setText("?");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.formulaire, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e(TAG, "onTextChanged : " + charSequence);
                callCalculation(view);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
/*
        EditText editTextAltitude = (EditText) findViewById(R.id.editTextAltitude);
        editTextAltitude.addTextChangedListener(myTextWatcher);
        EditText editTextQNH = (EditText) findViewById(R.id.editTextQNH);
        editTextQNH.addTextChangedListener(myTextWatcher);*/

        ((EditText) getView().findViewById(R.id.editTextAltitude)).addTextChangedListener(myTextWatcher);
        ((EditText) getView().findViewById(R.id.editTextQNH)).addTextChangedListener(myTextWatcher);
        ((EditText) getView().findViewById(R.id.editTextTemp)).addTextChangedListener(myTextWatcher);
/*
        ((RadioGroup) getView().findViewById(R.id.RadioDH)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                callCalculation(view);
            }
        });
*/



    }


}
