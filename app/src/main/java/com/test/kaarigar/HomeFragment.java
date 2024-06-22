package com.test.kaarigar;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.test.kaarigar.categories.AcrepairCategory;
import com.test.kaarigar.categories.AppliancesCategory;
import com.test.kaarigar.categories.BeautyCategory;
import com.test.kaarigar.categories.CleaningCategory;
import com.test.kaarigar.categories.ElectronicsCategory;
import com.test.kaarigar.categories.PaintingCategory;
import com.test.kaarigar.categories.PlumbingCategory;
import com.test.kaarigar.categories.ShiftingCategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private ImageSlider imageSlider;
    private Button searchButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem(R.drawable.microwave, "Microwave \nRepairing", "4.7", "Rs 1000"));
        cardItemList.add(new CardItem(R.drawable.furniture_shifting, "Furniture \nShifting", "4.2", "Rs 1800"));
        cardItemList.add(new CardItem(R.drawable.sofa, "Sofa  \nCleaning", "4.2", "Rs 1800"));
        cardItemList.add(new CardItem(R.drawable.exterior, "Exterior \npainting", "4.0", "Rs 20000"));
        cardItemList.add(new CardItem(R.drawable.tv, "Tv \nRepair", "4.2", "Rs 18000"));

        cardAdapter = new CardAdapter(cardItemList);
        recyclerView.setAdapter(cardAdapter);

        // Setup ImageSlider
        imageSlider = view.findViewById(R.id.image_slider);

        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner5, ScaleTypes.FIT));

        imageSlider.setImageList(imageList, ScaleTypes.FIT);

        // Setup Search Button
        searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        });

        ImageView notify = view.findViewById(R.id.notificationmain);
        notify.setOnClickListener(v -> {
            Intent gotonotifypage = new Intent(getActivity(),notificationActivity.class);
            startActivity(gotonotifypage);
        });

        ImageView ac = view.findViewById(R.id.acrepair);
        ImageView bty = view.findViewById(R.id.beauty);
        ImageView apl = view.findViewById(R.id.appliance);
        ImageView elc = view.findViewById(R.id.electronics);
        ImageView cln = view.findViewById(R.id.cleaning);
        ImageView paint = view.findViewById(R.id.painting);
        ImageView plum = view.findViewById(R.id.plumbing);
        ImageView shft = view.findViewById(R.id.shifting);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goac = new Intent(getActivity(), AcrepairCategory.class);
                startActivity(goac);
            }
        });
        bty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gobty = new Intent(getActivity(), BeautyCategory.class);
                startActivity(gobty);
            }
        });

        apl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goapl = new Intent(getActivity(), AppliancesCategory.class);
                startActivity(goapl);
            }
        });

        elc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goelc = new Intent(getActivity(), ElectronicsCategory.class);
                startActivity(goelc);
            }
        });

        cln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gocln = new Intent(getActivity(), CleaningCategory.class);
                startActivity(gocln);
            }
        });

        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gopaint = new Intent(getActivity(), PaintingCategory.class);
                startActivity(gopaint);
            }
        });

        plum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goplum = new Intent(getActivity(), PlumbingCategory.class);
                startActivity(goplum);
            }
        });

        shft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goshft = new Intent(getActivity(), ShiftingCategory.class);
                startActivity(goshft);
            }
        });

        return view;
    }
}
