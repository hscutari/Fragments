package com.example.android.android_me.MasterList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.Helper.ImageAssets;
import com.example.android.android_me.R;

/**
 * Created by henriquescutari on 8/5/17.
 */

public class MasterListFragment extends Fragment {

    OnImageClickListener mClickCallBack;

    public interface OnImageClickListener{
        void onImageSelected(int imageID);
    }

    public MasterListFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mClickCallBack.onImageSelected(i);
            }
        });

        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), ImageAssets.getAll());

        gridView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            mClickCallBack = (OnImageClickListener) context;
        }catch (ClassCastException e){

        }
    }
}
