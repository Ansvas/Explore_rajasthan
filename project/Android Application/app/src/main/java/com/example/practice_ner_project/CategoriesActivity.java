package com.example.practice_ner_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Integer> arrayList;
    ArrayList<String> namelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_category);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setTitle("Famous Products");
        toolbar.setNavigationIcon(R.drawable.mainarrow);
        toolbar.setTitleTextColor(Color.WHITE);
        gridView=(GridView)findViewById(R.id.gridview_category);
        arrayList=new ArrayList<>();
        arrayList.add(R.drawable.abcjew);
        arrayList.add(R.drawable.bpaint);
        arrayList.add(R.drawable.carpets);
        arrayList.add(R.drawable.fabricworks);
        arrayList.add(R.drawable.leatherwear);
        arrayList.add(R.drawable.metalcarving);
        arrayList.add(R.drawable.pottery);
        arrayList.add(R.drawable.puppets);
        namelist=new ArrayList<>();
        namelist.add("Jewellery");
        namelist.add("Painting");
        namelist.add("Carpets");
        namelist.add("Fabric Works");
        namelist.add("Leather Works");
        namelist.add("Metal Carving");
        namelist.add("Pottery");
        namelist.add("Puppets");
        GridAdapter gridAdapter=new GridAdapter();
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent i=new Intent(CategoriesActivity.this,JewelleryActivity.class);
                    startActivity(i);
                }

            }
        });

    }
    public class GridAdapter extends BaseAdapter
    {

        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null)
            {
                convertView=layoutInflater.inflate(R.layout.customadapterstates,parent,false);
            }
            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView_states);
            imageView.setImageResource(arrayList.get(position));
            TextView textView=(TextView)convertView.findViewById(R.id.txt_customAdapter);
            textView.setText(namelist.get(position));
            return convertView;
        }
    }
    }
