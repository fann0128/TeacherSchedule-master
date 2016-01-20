package com.example.sakitomo.teacherschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by yangf on 2016/1/20.
 */
public class ListViewAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<OfficeHour> list = new ArrayList<OfficeHour>();
    private Context context;



    public ListViewAdapter(ArrayList<OfficeHour> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;

    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.course_detail, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);

        String courseDesc = "";

        if(list.get(position).getDayOfWeek() ==1)
        {
            courseDesc += parent.getResources().getString(R.string.mon);
        }
        else  if(list.get(position).getDayOfWeek() ==2)
        {
            courseDesc += parent.getResources().getString(R.string.tue);
        }
        else  if(list.get(position).getDayOfWeek() ==3)
        {
            courseDesc +=  parent.getResources().getString(R.string.wed);
        }
        else  if(list.get(position).getDayOfWeek() ==4)
        {
            courseDesc += parent.getResources().getString(R.string.thu);
        }
        else
        {
            courseDesc += parent.getResources().getString(R.string.fri);
        }

        courseDesc += " "+list.get(position).getStartTime()+":00 - "+list.get(position).getEndTime()+":00";



        listItemText.setText(courseDesc);

        //Handle buttons and add onClickListeners
        Button btnSche = (Button)view.findViewById(R.id.btnSche);
        Button btnEmail = (Button)view.findViewById(R.id.btnEmail);


        btnSche.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                Intent intent = new Intent("com.example.sakitomo.teacherschedule.CourseInTableActivity");

                Bundle officeHours = new Bundle();
                ArrayList<OfficeHour> listOfHours = new ArrayList<OfficeHour>();

                listOfHours.add(list.get(position));

                officeHours.putSerializable("listOfHours", listOfHours);
                intent.putExtras(officeHours);


                parent.getContext().startActivity(intent);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                Toast toast = Toast.makeText(context,"you clicked Email",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return view;
    }


}
