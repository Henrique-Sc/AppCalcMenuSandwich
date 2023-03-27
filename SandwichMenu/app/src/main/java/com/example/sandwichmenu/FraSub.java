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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FraSub#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FraSub extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FraSub() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FraSub.
     */
    // TODO: Rename and change types and number of parameters
    public static FraSub newInstance(String param1, String param2) {
        FraSub fragment = new FraSub();
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
        View v = inflater.inflate(R.layout.fragment_sub, container, false);

        EditText edtN1, edtN2;
        Button btnCalc;
        TextView txtResult;

        edtN1 = v.findViewById(R.id.FraSub_edtN1);
        edtN2 = v.findViewById(R.id.FraSub_edtN2);
        btnCalc = v.findViewById(R.id.FraSub_btnCalc);
        txtResult = v.findViewById(R.id.FraSub_txtResult);

        btnCalc.setOnClickListener(view -> {
           if (edtN1.getText().length() == 0 || edtN2.getText().length() == 0) {
               Toast.makeText(getActivity(), "Digite um valor válido", Toast.LENGTH_SHORT).show();
           } else {
               float n1, n2;

               n1 = Float.parseFloat(edtN1.getText().toString());
               n2 = Float.parseFloat(edtN2.getText().toString());

               txtResult.setText(String.format("%s - %s = %s", n1, n2, n1 + n2));

           }

        });

        return v;
    }
}