package com.hansung.android.project_nicerestaurantapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "ActivityLifeCycle";
    static MyAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.i(TAG, getLocalClassName() + ".onCreate");

        // 데이터 원본 준비
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.food_img1, R.string.food1, R.string.foodprice1, R.string.foodstar1));
        data.add(new MyItem(R.drawable.food_img2, R.string.food2, R.string.foodprice2, R.string.foodstar2));
        data.add(new MyItem(R.drawable.food_img3, R.string.food3, R.string.foodprice3, R.string.foodstar3));
        data.add(new MyItem(R.drawable.food_img4, R.string.food4, R.string.foodprice4, R.string.foodstar4));

        //어댑터 생성
        adapter = new MyAdapter(this, R.layout.item, data);//item.xml에정의


        //어댑터 연결
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        ImageButton btn = (ImageButton)findViewById(R.id.call_Button1);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent implicit_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-760-1234"));
                startActivity(implicit_intent);
            }
        });

        //리스트뷰 클릭 시 액티비티 적용
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Food.class);
                int img =((MyItem)adapter.getItem(position)).mimg;
                int name = ((MyItem)adapter.getItem(position)).nName;
                int price = ((MyItem)adapter.getItem(position)).nprice;
                int star = ((MyItem)adapter.getItem(position)).star;

                intent.putExtra("foodimg", img);
                intent.putExtra("foodname", name);
                intent.putExtra("foodprice", price);
                intent.putExtra("foodstar", star);
                startActivity(intent);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getLocalClassName() + ".onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getLocalClassName() + ".onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getLocalClassName() + ".onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getLocalClassName() + ".onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getLocalClassName() + ".onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getLocalClassName() + ".onDestroy");
    }

}
