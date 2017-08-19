package com.example.android.android_me.Helper;

import android.content.Intent;

import com.example.android.android_me.Fragment.Fragment_body;
import com.example.android.android_me.Fragment.Fragment_head;
import com.example.android.android_me.Fragment.Fragment_leg;

/**
 * Created by henriquescutari on 8/19/17.
 */

public class Create {

    public static Fragment_head createHead(Intent context, int index){
        Fragment_head headFragment = new Fragment_head();
        headFragment.setList(ImageAssets.getHeads());

        if(index == 0){
            index = context.getIntExtra(ImageAssets.headIndex, 0);
        }

        headFragment.setImage(index);

        return headFragment;
    }

    public static Fragment_body createBody(Intent context, int index){
        Fragment_body bodyFragment = new Fragment_body();

        bodyFragment.setList(ImageAssets.getBodies());

        if(index == 0) {
            index = context.getIntExtra(ImageAssets.bodyIndex, 0);
        }

        bodyFragment.setImage(index);

        return bodyFragment;
    }

    public static Fragment_leg createLeg(Intent context, int index){
        Fragment_leg legFragment = new Fragment_leg();

        legFragment.setList(ImageAssets.getLegs());

        if(index == 0){
            index = context.getIntExtra(ImageAssets.legIndex, 0);
        }

        legFragment.setImage(index);

        return legFragment;
    }
}
