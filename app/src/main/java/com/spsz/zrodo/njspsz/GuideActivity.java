package com.spsz.zrodo.njspsz;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.spsz.zrodo.njspsz.Adapters.GuidePages;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
private ViewPager vp_guide;
private Button btn_guide_start;
//private LinearLayout ly_point;
private ArrayList<View> imageViews;
private GuidePages guideAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        vp_guide=(ViewPager) findViewById(R.id.guide_viewPage);
        btn_guide_start=(Button) findViewById(R.id.btn_guide_start);
        imageViews=new ArrayList<View>();
        LayoutInflater inflater=getLayoutInflater();
        imageViews.add(inflater.inflate(R.layout.one,null ,false));
        imageViews.add(inflater.inflate(R.layout.two,null ,false));
        imageViews.add(inflater.inflate(R.layout.three,null ,false));
        guideAdapter=new GuidePages(imageViews);
        vp_guide.setAdapter(guideAdapter);
        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position==2){
                    btn_guide_start.setVisibility(View.VISIBLE);
                    btn_guide_start.bringToFront();

                }else {
                    btn_guide_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
btn_guide_start.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(GuideActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
});

    }
//    public void initpoint(){
//        //获取layout
//        ly_point=(LinearLayout) findViewById(R.id.ly_point);
//        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//    //设置每一个view的偏移量
//        params.setMargins(15,0,0,0);
//        for (int i=0;i< 3;i++){
//            ImageView imageView=new ImageView(this);
//            imageView.setImageResource(R.drawable.guide_point);
//            imageView.setLayoutParams(params);
//            if (i==0){
//                imageView.setSelected(true);
//            }else {
//                imageView.setSelected(false);
//            }
//            //吧圆点导入到layoutLine
//            ly_point.addView(imageView);
//            imageViews.add(imageView);//加入imageview  的point
//        }
//    }
}
