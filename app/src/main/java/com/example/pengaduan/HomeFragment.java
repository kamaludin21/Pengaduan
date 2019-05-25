package com.example.pengaduan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static maes.tech.intentanim.CustomIntent.customType;

public class HomeFragment extends Fragment {

    FloatingActionButton add;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        add = (FloatingActionButton) v.findViewById(R.id.fab_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addForm();
            }
        });

        ((MainActivity) getActivity()).setActionBarTitle("Beranda");

        return v;
    }

    private void addForm() {

        Intent i = new Intent(getActivity(), FormActivity.class);
        startActivity(i);
        customType(getActivity(),"up-to-bottom");

    }

}
