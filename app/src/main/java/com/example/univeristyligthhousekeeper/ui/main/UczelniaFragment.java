package com.example.univeristyligthhousekeeper.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.univeristyligthhousekeeper.MainActivityTabbed;
import com.example.univeristyligthhousekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UczelniaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UczelniaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UczelniaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button historyButton;
    private Button descriptionButton;
    private Button numbersButton;
    private Button contactButton;
    private ConstraintLayout historyInclude;
    private ConstraintLayout descriptionInclude;
    private ConstraintLayout numbersInclude;
    private ConstraintLayout contactInclude;


    private OnFragmentInteractionListener mListener;

    public UczelniaFragment() {
        // Required empty public constructor
    }


    public static UczelniaFragment newInstance() {
        UczelniaFragment fragment = new UczelniaFragment();
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
        View v = inflater.inflate(R.layout.fragment_uczelnia2, container, false);

        historyButton = v.findViewById(R.id.historyButton);
        contactButton = v.findViewById(R.id.contactButton);
        descriptionButton = v.findViewById(R.id.descriptionButton);
        numbersButton = v.findViewById(R.id.numbersButton);
        historyInclude = v.findViewById(R.id.includeHistory);
        numbersInclude = v.findViewById(R.id.includeNumbers);
        descriptionInclude = v.findViewById(R.id.includeDescription);
        contactInclude = v.findViewById(R.id.includeContact);

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (historyInclude.getVisibility() == View.VISIBLE) historyInclude.setVisibility(View.GONE);
                else if (historyInclude.getVisibility() == View.GONE) historyInclude.setVisibility(View.VISIBLE);
            }
        });

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contactInclude.getVisibility() == View.VISIBLE) contactInclude.setVisibility(View.GONE);
                else if (contactInclude.getVisibility() == View.GONE) contactInclude.setVisibility(View.VISIBLE);
            }
        });

        descriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (descriptionInclude.getVisibility() == View.VISIBLE) descriptionInclude.setVisibility(View.GONE);
                else if (descriptionInclude.getVisibility() == View.GONE) descriptionInclude.setVisibility(View.VISIBLE);
            }
        });

        numbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numbersInclude.getVisibility() == View.VISIBLE) numbersInclude.setVisibility(View.GONE);
                else if (numbersInclude.getVisibility() == View.GONE) numbersInclude.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
