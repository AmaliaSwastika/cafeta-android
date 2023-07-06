package com.example.project11;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    ViewFlipper flipper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView bb3 = view.findViewById(R.id.bb3);
        bb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Cart.class);
                startActivity(intent);
            }
        });

        recyclerViewList = view.findViewById(R.id.view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

        ArrayList<ListDomain> news = new ArrayList<>();
        news.add(new ListDomain("Sate Kambing \n Rp 350.000", "pics1"));
        news.add(new ListDomain("Sate Ayam \n Rp 350.000", "pics2"));
        news.add(new ListDomain("Sate Taichan \n Rp 350.000", "pics3"));


        adapter = new NewAdapter(news);
        recyclerViewList.setAdapter(adapter);

        recyclerViewList = view.findViewById(R.id.views);

        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManagers);

        ArrayList<ListDomain> newss = new ArrayList<>();
        newss.add(new ListDomain("Mr.Apple \n Rp 35.000", "pic1s"));
        newss.add(new ListDomain("Mr.Lemon \n  Rp 35.000", "pic2s"));
        newss.add(new ListDomain("Mr.Anggur \n Rp 35.000", "pic3s"));

        adapter = new NewAdapter(newss);
        recyclerViewList.setAdapter(adapter);

        int imgarray[] = {R.drawable.slid1, R.drawable.slid2, R.drawable.slid3};
        flipper = view.findViewById(R.id.flipper);

        for (int i = 0; i < imgarray.length; i++) {
            showimage(imgarray[i]);
        }

        return view;


    }
    public void showimage(int img){
        ImageView imageview = new ImageView(getContext());
        imageview.setBackgroundResource(img);

        flipper.addView(imageview);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        flipper.setInAnimation(getContext(), android.R.anim.slide_out_right);
    }
}
