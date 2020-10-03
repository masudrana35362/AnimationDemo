package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.valdesekamdem.library.mdtoast.MDToast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mListLayout;
    private ImageView mProfileImage;
    private TextView mNameText,mDescText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListLayout=findViewById(R.id.listLayout);
        mProfileImage=findViewById(R.id.profile_image);
        mNameText=findViewById(R.id.profile_name);
        mDescText=findViewById(R.id.profile_desc);
        mListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair[] pairs=new Pair[3];
                pairs[0]=new Pair<View,String>(mProfileImage,"imageTransition");
                pairs[1]=new Pair<View,String>(mNameText,"nameTransition");
                pairs[2]=new Pair<View,String>(mDescText,"descTransition");
                
                Intent shareIntent=new Intent(MainActivity.this,SharedActivity.class);
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(shareIntent,options.toBundle());
            }
        });


    }
    @Override
    public void onBackPressed() {
    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit!");
        builder.setMessage("Do you really want to exit ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            finish();
            setToast(MainActivity.this,"Hope you are coming back soon.",1);
        }
    });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            setToast(MainActivity.this,"Enjoy!",0);
        }
    });
        builder.show();
    }
    public void setToast(Context context,String message,int type){

        MDToast.makeText(context,message,MDToast.LENGTH_SHORT,type).show();
    }

}