package com.example.sandwichmenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FraIMC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FraIMC extends Fragment {

    View v;
    String txt;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FraIMC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FraIMC.
     */
    // TODO: Rename and change types and number of parameters
    public static FraIMC newInstance(String param1, String param2) {
        FraIMC fragment = new FraIMC();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_imc, container, false);

        EditText edtAlt, edtPeso;
        Button btnCalc;
        TextView txtResult;

        edtAlt = v.findViewById(R.id.FraIMC_edtAlt);
        edtPeso = v.findViewById(R.id.FraIMC_edtPeso);
        btnCalc = v.findViewById(R.id.FraIMC_btnCalc);
        txtResult = v.findViewById(R.id.FraIMC_txtResult);

        btnCalc.setOnClickListener(view -> {

            if ((edtAlt.getText().length() == 0) || (edtPeso.getText().length() == 0)) {
                Toast.makeText(getActivity(),"Digite um valor válido!", Toast.LENGTH_SHORT).show();
            } else {
                float alt, peso, imc;

                alt = Float.parseFloat(edtAlt.getText().toString());
                peso = Float.parseFloat(edtPeso.getText().toString());
                imc = peso / (alt * alt);

                String imcF = new DecimalFormat("#.00").format(imc);

                if (imc < 18.5) {
                    txt = "abaixo do peso!";

                } else if (imc >= 18.5 && imc < 25) {
                    txt = "com o peso ideal!";

                } else if (imc >= 25 && imc < 30) {
                    txt = "com execesso de peso!";

                } else if (imc >= 30 && imc < 35) {
                    txt = "com obesidade!";

                } else {
                    txt = "com obesidade mórbida!";
                }

                txtResult.setText(String.format("O seu IMC é: %s \n" + "Você está %s", imcF, txt));
            }

        });

        return v;
    }
}