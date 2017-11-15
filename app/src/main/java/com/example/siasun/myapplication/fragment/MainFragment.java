package com.example.siasun.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.siasun.myapplication.AccountInformationActivity;
import com.example.siasun.myapplication.R;

public class MainFragment extends Fragment implements View.OnClickListener{

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        init(rootView);
        return  rootView;
    }

    private void init(View rootView) {
        AppCompatButton btn_account_information = rootView.findViewById(R.id.btn_account_information);
        btn_account_information.setOnClickListener(this);
        AppCompatButton btn_account_charge = rootView.findViewById(R.id.btn_account_charge);
        btn_account_charge.setOnClickListener(this);
        AppCompatButton btn_account_password_manager = rootView.findViewById(R.id.btn_account_password_manager);
        btn_account_password_manager.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        String str = "";
        switch (v.getId()){
            case R.id.btn_account_information:
                str = "btn_account_information";
                startActivity(new Intent(getContext(),AccountInformationActivity.class));
                break;
            case R.id.btn_account_charge:
                str = "btn_account_charge";
                break;
            case R.id.btn_account_password_manager:
                str = "btn_account_password_manager";
                break;
        }
        Log.d("wcy",str + "is clicked ！");


    }
}
