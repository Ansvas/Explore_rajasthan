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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class JaipurActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaipur);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_faculty);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitle("UDAIPUR");
        toolbar.setNavigationIcon(R.drawable.mainarrow);
        toolbar.setTitleTextColor(Color.WHITE);
        listView=(ListView)findViewById(R.id.listView_staff);
        textView=(TextView)findViewById(R.id.textView_staff);
        arrayList=new ArrayList();
        arrayList.add("Udaipur City Palace");
        arrayList.add("Lake Palace");
        arrayList.add("Jag Mandir");
        arrayList.add("Lake Pichola");
        arrayList.add("Shilpgram");
        arrayList.add("Haldighat");
        arrayList.add("Jaisamand Lake");
        arrayList.add("Fateh Sagar Lake");
        arrayList.add("Ahar Museum");
        arrayList.add("Gulab Bagh and Zoo");
        StaffAdapter staffAdapter=new StaffAdapter();
        listView.setAdapter(staffAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent i=new Intent(JaipurActivity.this,UdaipurLakeActivity.class);
                    startActivity(i);
                }


            }
        });
    }
    public class StaffAdapter extends BaseAdapter
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
            if(convertView==null)
            {
                convertView=layoutInflater.inflate(R.layout.stafffile,parent,false);
            }
            TextView staff=(TextView)convertView.findViewById(R.id.textView_staff);
            staff.setText(arrayList.get(position));
            return convertView;
        }


    }
}
