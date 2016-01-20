package com.example.sakitomo.teacherschedule;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yangf on 2016/1/20.
 */
public class CourseInTableActivity extends Activity {
    protected TextView empty;

    protected TextView monColum;

    protected TextView tueColum;

    protected TextView wedColum;

    protected TextView thrusColum;

    protected TextView friColum;

    protected RelativeLayout course_table_layout;

    protected int aveWidth;

    protected int screenWidth;

    protected int gridHeight = 80;

    private ArrayList<OfficeHour> listOfOfficeHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail_in_table);

        empty = (TextView) this.findViewById(R.id.test_empty);
        monColum = (TextView) this.findViewById(R.id.test_monday_course);
        tueColum = (TextView) this.findViewById(R.id.test_tuesday_course);
        wedColum = (TextView) this.findViewById(R.id.test_wednesday_course);
        thrusColum = (TextView) this.findViewById(R.id.test_thursday_course);
        friColum = (TextView) this.findViewById(R.id.test_friday_course);

        course_table_layout = (RelativeLayout) this.findViewById(R.id.test_course_rl);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        int aveWidth = width / 6;

        empty.setWidth(aveWidth);
        monColum.setWidth(aveWidth);
        tueColum.setWidth(aveWidth);
        wedColum.setWidth(aveWidth);
        thrusColum.setWidth(aveWidth);
        friColum.setWidth(aveWidth);

        this.screenWidth = width;
        this.aveWidth = aveWidth;
        init();

        Bundle bd = getIntent().getExtras();

        listOfOfficeHours = (ArrayList<OfficeHour>)bd.getSerializable("listOfHours");

        for(OfficeHour oh : listOfOfficeHours)
        {
            addNewCourseIntoTable(oh.getDayOfWeek(),oh.getStartTime(),oh.getDuration(),oh.getTeacherName(),oh.getOfficeRoom());

        }


        //addNewCourseIntoTable(2, 8, 3, "Fode", 2233);
        //addNewCourseIntoTable(2, 9, 3, "Zeroug", 2235);
        //addNewCourseIntoTable(4,12,1,"Fode",2233);
    }

    protected void init() {

        int maxHours = 10;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        //height of screen

        int height = dm.heightPixels;
        gridHeight = height / maxHours;

        for(int i = 1; i <= maxHours; i ++){

            for(int j = 1; j <= 6; j ++){

                TextView tx = new TextView(CourseInTableActivity.this);
                tx.setId((i - 1) * 6  + j);

                if(j < 6)
                    tx.setBackgroundResource(R.drawable.course_text_view_bg);
                else
                    tx.setBackgroundResource(R.drawable.course_table_last_colum);
                //relativeLayout
                RelativeLayout.LayoutParams rp = new RelativeLayout.LayoutParams(
                        aveWidth ,gridHeight);
                //set text-align
                tx.setGravity(Gravity.CENTER);
                //set font
                if (Build.VERSION.SDK_INT < 23) {
                    tx.setTextAppearance(this, R.style.courseTableText);
                }
                else
                {
                    tx.setTextAppearance(R.style.courseTableText);
                }
                //if the first column（1 to 12）
                if(j == 1)
                {
                    String hourDef = (i+7)+":00  "+"\t"+(i+8)+":00";

                    //tx.setText(String.valueOf(i));
                    tx.setText(hourDef);
                    rp.width = aveWidth ;
                    //setRelativeLayout
                    if(i == 1)
                        rp.addRule(RelativeLayout.BELOW, empty.getId());
                    else
                        rp.addRule(RelativeLayout.BELOW, (i - 1) * 6);
                }
                else
                {
                    rp.addRule(RelativeLayout.RIGHT_OF, (i - 1) * 6  + j - 1);
                    rp.addRule(RelativeLayout.ALIGN_TOP, (i - 1) * 6  + j - 1);
                    tx.setText("");
                }

                tx.setLayoutParams(rp);
                course_table_layout.addView(tx);
            }
        }

    }


    public void addNewCourseIntoTable(int dayOfWeek, int hourOfDay, int duration, String teacherName, int officeRoom)
    {
        int totalCourse=1;
        int[] background = {R.drawable.courseBlue,R.drawable.courseGrey,R.drawable.courseGreen,R.drawable.courseYellow,
                R.drawable.courseRed};
        //---------add new courseInfo into table ---------------------
        TextView courseInfo = new TextView(CourseInTableActivity.this);
        courseInfo.setId(1000*dayOfWeek + hourOfDay);

        courseInfo.setText(hourOfDay + ":00");
        //textview hight
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(aveWidth,duration*gridHeight);


        rlp.topMargin = gridHeight*(hourOfDay-8);
        rlp.addRule(RelativeLayout.RIGHT_OF, dayOfWeek);
        //align-text center
        courseInfo.setGravity(Gravity.CENTER);
        //set backgroud color

        courseInfo.setBackgroundResource(background[0]);
        courseInfo.setTextSize(12);
        courseInfo.setLayoutParams(rlp);
        courseInfo.setTextColor(Color.WHITE);
        // setAlpha
        courseInfo.getBackground().setAlpha(222);

        course_table_layout.addView(courseInfo);
    }



}
