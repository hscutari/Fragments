package com.example.android.android_me.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.Helper.ImageAssets;
import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henriquescutari on 8/5/17.
 */

public class Fragment_body extends Fragment {

    private static final String IMG_ID = "image_id";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> _Imgs;
    int index = 0;

    public void setList(List<Integer> imgs){
        _Imgs = imgs;
    }

    public void setImage(int position){
        index = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View vHead = inflater.inflate(R.layout.fragment_layout_body, container, false);

        if(savedInstanceState != null){
            index = savedInstanceState.getInt(LIST_INDEX);
            _Imgs = savedInstanceState.getIntegerArrayList(IMG_ID);
        }

        final ImageView img = (ImageView) vHead.findViewById(R.id.imgBofy);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index < _Imgs.size() -1){
                    index ++;
                }else{
                    index = 0;
                }

                img.setImageResource(_Imgs.get(index));
            }
        });


        img.setImageResource(ImageAssets.getBodies().get(index));

        return vHead;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMG_ID, (ArrayList<Integer>)_Imgs);
        outState.putInt(LIST_INDEX, index);
    }
}
