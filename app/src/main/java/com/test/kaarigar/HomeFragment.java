package com.test.kaarigar;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private ImageSlider imageSlider;

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
        cardItemList.add(new CardItem(R.drawable.pop1, "Home \nCleaning", "5.0", "Rs 1000"));
        cardItemList.add(new CardItem(R.drawable.pop2, "Home \nDisInfection", "4.5", "Rs 2000"));
        cardItemList.add(new CardItem(R.drawable.pop3, "Ac \nCheckup", "4.8", "Rs 1500"));
        cardItemList.add(new CardItem(R.drawable.pop4, "Ac \nRepair", "4.2", "Rs 5000"));
        cardItemList.add(new CardItem(R.drawable.pop5, "Ac \nMaintenance", "4.2", "Rs 1800"));

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

        return view;
    }
}
