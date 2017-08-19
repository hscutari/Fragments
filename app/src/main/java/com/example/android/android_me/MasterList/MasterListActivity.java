package com.example.android.android_me.MasterList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.android_me.BodyPart.BodyPartActivity;
import com.example.android.android_me.Fragment.Fragment_body;
import com.example.android.android_me.Fragment.Fragment_head;
import com.example.android.android_me.Fragment.Fragment_leg;
import com.example.android.android_me.Helper.Create;
import com.example.android.android_me.Helper.ImageAssets;
import com.example.android.android_me.R;

/**
 * Created by henriquescutari on 8/19/17.
 */

public class MasterListActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    int head;
    int body;
    int leg;

    private boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.horizontal_layout) != null) {

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            twoPanes = true;

            ImageView send = (ImageView) findViewById(R.id.send);
            send.setVisibility(View.GONE);

            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);

            if(savedInstanceState == null) {

                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .add(R.id.head_container, Create.createHead(getIntent(),0 ))
                        .add(R.id.body_container, Create.createBody(getIntent(),0 ))
                        .add(R.id.leg_container, Create.createLeg(getIntent(),0 ))
                        .commit();
            }
        }
        else {
            twoPanes = false;
        }
    }

    @Override
    public void onImageSelected(int imageID) {

        int bodyPart = imageID / 12;

        int listIndex = imageID - 12 * bodyPart;

        if(twoPanes){
            switch (bodyPart){
                case 0:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.head_container, Create.createHead(getIntent(), listIndex))
                            .commit();
                    break;
                case 1:
                    getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.body_container, Create.createBody(getIntent(), listIndex))
                        .commit();
                    break;
                case 2:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.leg_container, Create.createLeg(getIntent(), listIndex))
                            .commit();
                    break;
                default:break;
            }

        }else{

            switch (bodyPart){
                case 0: head = listIndex;
                    break;
                case 1: body = listIndex;
                    break;
                case 2: leg = listIndex;
                    break;
                default:break;
            }

            Bundle b = new Bundle();
            b.putInt(ImageAssets.headIndex, head);
            b.putInt(ImageAssets.bodyIndex, body);
            b.putInt(ImageAssets.legIndex, leg);

            final Intent intent = new Intent(this, BodyPartActivity.class);
            intent.putExtras(b);

            ImageView send = (ImageView) findViewById(R.id.send);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }
    }
}
