package kr.hs.emirim.wodms5772.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static kr.hs.emirim.wodms5772.imagetest.R.*;

public class MainActivity extends AppCompatActivity{

    MyImage mImg;
    static final int ORIGINAL=0;
    static final int ROTATE=1;
    static final int TRANSLATE=2;
    static final int SCALE=3;
    static final int SKEW=4;
    int choose=ORIGINAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        LinearLayout linear1=(LinearLayout)findViewById(R.id.linear1);
        mImg=new MyImage(getApplicationContext());
        linear1.addView(mImg);
    }

    public void transformImage(View v){
        switch(v.getId()){
            case id.but_rotate: choose=ROTATE; break;
            case id.but_scale: choose=SCALE; break;
            case id.but_skew: choose=SKEW; break;
            case id.but_translate:choose=TRANSLATE; break;
        }
        mImg.setChoose(choose);
        mImg.invalidate();//MyImage-onDraw 다시 호출
    }

}
