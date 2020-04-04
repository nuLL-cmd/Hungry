package com.automatodev.hungry.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.automatodev.hungry.R;
import com.automatodev.hungry.model.entity.SheetEntity;
import com.automatodev.hungry.view.adapter.SheetAdapter;

import java.util.ArrayList;
import java.util.List;

public class FrSheets extends Fragment {
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    private RecyclerView recycler_main;
    private SheetAdapter sheetAdapter;
    private List<SheetEntity> sheetEntityList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       return getLayoutInflater().inflate(R.layout.fragment_sheets, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler_main = view.findViewById(R.id.recycler_main);
        sheetEntityList = new ArrayList<>();

        showData();
    }


    public void showData(){
        sheetEntityList.add(new SheetEntity("Comidaria dos Guris",images[0]
                ,133,"Restaurante", true, true,"19:00"));
        sheetEntityList.add(new SheetEntity("Sanduicheria bob",images[1]
                ,88,"Restaurante", false, false,"19:30"));
        sheetEntityList.add(new SheetEntity("Kid Abelha",images[2]
                ,75,"Sanduicheria", true, false,"20:00"));
        sheetEntityList.add(new SheetEntity("PitDog do Professor",images[3]
                ,118,"Sanduicheria", false, true,"19:30"));

        sheetEntityList.add(new SheetEntity("Comidaria dos Guris",images[0]
                ,133,"Restaurante", false, false,"19:00"));
        sheetEntityList.add(new SheetEntity("Sanduicheria bob",images[1]
                ,88,"Restaurante", false, true,"19:30"));
        sheetEntityList.add(new SheetEntity("Kid Abelha",images[2]
                ,75,"Sanduicheria", true, true,"20:00"));
        sheetEntityList.add(new SheetEntity("PitDog do Professor",images[3]
                ,118,"Sanduicheria", true, false,"19:30"));


        recycler_main.setHasFixedSize(true);
        recycler_main.setLayoutManager(new LinearLayoutManager(getActivity()));
        sheetAdapter = new SheetAdapter(getActivity(), sheetEntityList);
        recycler_main.setAdapter(sheetAdapter);



    }
}
