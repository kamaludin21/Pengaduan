package com.example.pengaduan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pengaduan.main.MainAdapter;
import com.example.pengaduan.main.MainPresenter;
import com.example.pengaduan.main.MainView;

import java.util.List;

import static maes.tech.intentanim.CustomIntent.customType;

public class HomeFragment extends Fragment implements MainView {

    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    FloatingActionButton add;

    MainPresenter mainPresenter;
    MainAdapter mainAdapter;
    MainAdapter.ItemCLickListener itemCLickListener;
    List<FormModel> form;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        add = v.findViewById(R.id.fab_add);
        recyclerView = v.findViewById(R.id.recycler_view);
        refreshLayout = v.findViewById(R.id.swipe);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainPresenter = new MainPresenter(this);
        mainPresenter.getData();

        refreshLayout.setOnRefreshListener(
                () -> mainPresenter.getData()
        );

        itemCLickListener = (((view, position) -> {
            String kategori = form.get(position).getKategori();
            Toast.makeText(getActivity(), kategori, Toast.LENGTH_SHORT).show();
        }));

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

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);

    }

    @Override
    public void hideLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<FormModel> forms) {
        mainAdapter = new MainAdapter(getActivity(),forms, itemCLickListener);
        mainAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(mainAdapter);

        form = forms;

    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
