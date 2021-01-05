package com.example.carownersdata;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class FragmentList extends Fragment  {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    EditText etNameFloat, etModelFloat, etContactFloat;
    Spinner spnBrandFloat;
    private FloatingActionButton fab;
    private String brand;
    Button btnAdd, btnCancel;

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new CarAdapter(this.getActivity(), MyApplication.cars);
        recyclerView.setAdapter(myAdapter);

        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(onAddingListener());




    }
    private View.OnClickListener onAddingListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.add_dialog);
                dialog.setTitle("Add New Owner details");
                dialog.setCancelable(false); //dialog box not dismiss after touching the screen

                etNameFloat = (EditText) dialog.findViewById(R.id.etNameFloat);
                etModelFloat = (EditText) dialog.findViewById(R.id.etModelFloat);
                etContactFloat = (EditText) dialog.findViewById(R.id.etContactFloat);
                spnBrandFloat = (Spinner) dialog.findViewById(R.id.spnBrandFloat);
                btnAdd = dialog.findViewById(R.id.btnAdd);
                btnCancel = dialog.findViewById(R.id.btnCancel);



                //set spinner adapter
                ArrayList<String> brandlist = new ArrayList<String>();
                brandlist.add("Mercedes");
                brandlist.add("Nissan");
                brandlist.add("Volkswagen");
                ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, brandlist);
                spnBrandFloat.setAdapter(spnAdapter);

                //set handling event for buttoons
                spnBrandFloat.setOnItemSelectedListener(OnItemselectedListener());
                btnAdd.setOnClickListener(OnConfirmListener(etModelFloat, etNameFloat, etContactFloat, dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));
                dialog.setOnKeyListener(new Dialog.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {

                        if(keyCode == KeyEvent.KEYCODE_BACK) {
                            dialog.dismiss();
                        }
                        return false;
                    }
                });



                dialog.show();

            }

            private View.OnClickListener onCancelListener(final Dialog dialog) {
                return new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                };

            }

            private View.OnClickListener OnConfirmListener(final EditText etModelFloat, final EditText etnamefloat, final EditText etContactFloat, final Dialog dialog) {
                return new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyApplication.cars.add(new Car(etModelFloat.getText().toString().trim(), "Some detail about the new added car", etNameFloat.getText().toString().trim(), etContactFloat.getText().toString().trim(), brand));
                        dialog.dismiss();
                        myAdapter.notifyDataSetChanged();

                    }

                };
            }

            private AdapterView.OnItemSelectedListener OnItemselectedListener() {
                return new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0)
                            brand = "Mercedes";
                        else if (position == 1)
                            brand = "Nissan";
                        else
                            brand = "Volkswagen";

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                };
            }
        };
    }


}