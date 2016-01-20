package com.example.sakitomo.teacherschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Teacher> listOfTeachers;
    private static TextView[] arrayText;

    // all matched timeSpan




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVariables();
        setSpinner();



    }

    private void updateListView( ArrayList<String> listOfTimeSpans)
    {

        //instantiate custom adapter
        MyCoursesListView adapter = new MyCoursesListView(listOfTimeSpans,this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listViewResult);
        lView.setAdapter(adapter);
    }
    private void updateListViewByOfficeHour ( ArrayList<OfficeHour> listOfTimeSpans)
    {

        //instantiate custom adapter
        ListViewAdapter adapter = new ListViewAdapter(listOfTimeSpans,this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listViewResult);
        lView.setAdapter(adapter);
    }

    private void setVariables() {
        listOfTeachers = new ArrayList<>();
        listOfTeachers.add(new Teacher("Salima Hassaine", new Availability(new TimeSpan(1, 12, 13), new TimeSpan(3, 14, 16),new TimeSpan(4, 15, 16))));
        listOfTeachers.add(new Teacher("Nariman Mansour", new Availability(new TimeSpan(0, 15, 18),new TimeSpan(4, 15, 16))));
        listOfTeachers.add(new Teacher("Fode Toure", new Availability(new TimeSpan(0, 10, 12), new TimeSpan(4, 15, 16))));
        listOfTeachers.add(new Teacher("Mohamed Zeroug", new Availability(new TimeSpan(2, 14, 15), new TimeSpan(4, 10, 11))));

        arrayText = new TextView[5];
        arrayText[0] = (TextView)findViewById(R.id.txtTimeSpan0);
        arrayText[1] = (TextView)findViewById(R.id.txtTimeSpan1);
        arrayText[2] = (TextView)findViewById(R.id.txtTimeSpan2);
        arrayText[3] = (TextView)findViewById(R.id.txtTimeSpan3);
        arrayText[4] = (TextView)findViewById(R.id.txtTimeSpan4);
    }

    private void setSpinner() {
        Spinner spinner = (Spinner)findViewById(R.id.cboTeacher);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nameTeachers, android.R.layout.simple_spinner_item);
        ArrayAdapter<Teacher> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listOfTeachers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Teacher item = (Teacher)parent.getItemAtPosition(position);
                TextView text = (TextView)findViewById(R.id.txtTeacher);
                text.setText(getString(R.string.text_lblName) + item);

                Availability availability = item.getAvailability();

                ArrayList<String> listOfAllSpans = new ArrayList<String>();
                ArrayList<OfficeHour> listOfOfficeHours = new ArrayList<OfficeHour>();


                for (int i = 0; i < 5; i++) {

                    ArrayList<TimeSpan> list = availability.getList(i);


                   if (!list.isEmpty()) {
                        arrayText[i].setBackgroundColor(0xFFEECCCC);
                        arrayText[i].setText(list.get(0).getStart() + "-" + list.get(0).getEnd());
                        listOfAllSpans.add(list.get(0).getStart() + ":00-" + list.get(0).getEnd() + ":00");
                        listOfOfficeHours.add(new OfficeHour(3311,item.getName(),i+1,list.get(0).getStart(),list.get(0).getEnd(),"C#","ComputerScience"));

                    } else {
                        arrayText[i].setBackgroundColor(0xFFFFFFFF);
                        arrayText[i].setText("");

                    }
                }
                //updateListView(listOfAllSpans);
                updateListViewByOfficeHour(listOfOfficeHours);
                //Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
