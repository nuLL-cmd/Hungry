package com.automatodev.hungry.view.actvity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.automatodev.hungry.R;
import com.automatodev.hungry.model.entity.SheetEntity;
import com.automatodev.hungry.view.adapter.SheetAdapter;
import com.automatodev.hungry.view.fragment.FrOrders;
import com.automatodev.hungry.view.fragment.FrSheets;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    private CarouselView carouselView;
    private CarouselView carouselView_two_main;
    private FragmentPagerItemAdapter fr;

    private ViewPager viewpager;
    private SmartTabLayout viewpagertab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = findViewById(R.id.carouselView);
        carouselView_two_main = findViewById(R.id.carouselView2);
        viewpagertab = findViewById(R.id.viewpagertab);
        viewpager = findViewById(R.id.viewpager);

       final Random  r= new Random(193263);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setScrollBarFadeDuration(12);
                imageView.setImageResource(images[r.nextInt(images.length)]);
            }
        });

        carouselView_two_main.setPageCount(images.length);
        carouselView_two_main.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });

        fr = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("",FrSheets.class)
                .add("",FrOrders.class)
                .create());

        viewpager.setAdapter(fr);
        viewpagertab.setViewPager(viewpager);



    }


}
