package com.example.android.yummy.MainActivities;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.android.yummy.apiCalls.photoRequest;
import com.example.android.yummy.R;
import com.google.maps.model.Photo;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class photos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        Photo[] photos = RestaurantActivity.detailedRequest.placeDetails.photos;
        if(photos.length != 0){
            TextView errorMessage = (TextView) findViewById(R.id.ErrorMessage);
            errorMessage.setVisibility(View.GONE);
            new photoRequest(photos, this);
        }
    }

    public void afterRequest(ArrayList<Bitmap> pictures){
        LinearLayout mainView = (LinearLayout) findViewById(R.id.MainView);
        for(int i =0; i < pictures.size(); i++){
            ImageView imageView1 = new ImageView(this);
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1000);
            layoutParams1.setMargins(0,20,0,0);
            imageView1.setImageBitmap(pictures.get(i));
            imageView1.setLayoutParams(layoutParams1);
            mainView.addView(imageView1);


        }

    }
}
