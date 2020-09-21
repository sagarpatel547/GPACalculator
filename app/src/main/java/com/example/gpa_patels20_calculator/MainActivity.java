package com.example.gpa_patels20_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5;
    Button b1, re;
    TextView aa, bb, cc, dd, ee, ff, gg;
    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.tvCourse1);
        e2 = (EditText) findViewById(R.id.tvCourse2);
        e3 = (EditText) findViewById(R.id.tvCourse3);
        e4 = (EditText) findViewById(R.id.tvCourse4);
        e5 = (EditText) findViewById(R.id.tvCourse5);

        b1 = (Button) findViewById(R.id.btnSGPA);
        re = (Button) findViewById(R.id.btnReset);

        aa = (TextView) findViewById(R.id.ds1);
        bb = (TextView) findViewById(R.id.ds2);
        cc = (TextView) findViewById(R.id.ds3);
        dd = (TextView) findViewById(R.id.ds4);
        ee = (TextView) findViewById(R.id.ds5);
        ff = (TextView) findViewById(R.id.result);
        gg = (TextView) findViewById(R.id.fail);

        re.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                gg.setText("");
                ff.setText("");
                aa.setText("");
                bb.setText("");
                cc.setText("");
                dd.setText("");
                ee.setText("");
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
            }
        });

        LayoutInflater lf = getLayoutInflater();
        final View uv = lf.inflate(R.layout.pik, (ViewGroup) findViewById(R.id.happy));
        final View vv = lf.inflate(R.layout.ad, (ViewGroup) findViewById(R.id.sad));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = new Integer(e1.getText().toString()).intValue();

                int b = Integer.parseInt(e2.getText().toString());
                int c = Integer.parseInt(e3.getText().toString());
                int d = Integer.parseInt(e4.getText().toString());
                int e = Integer.parseInt(e5.getText().toString());

                String aaa = check(a);
                String bbb = check(b);
                String ccc = check(c);
                String ddd = check(d);
                String eee = check(e);

                if (aaa.equals("F") || bbb.equals("F") || ccc.equals("F") || ddd.equals("F") || eee.equals("F")) {
                    gg.setText("You must retake the course in which you have gotten an F in");
                    Toast t = new Toast(getApplicationContext());

                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(vv);
                    t.show();
                } else {
                    ff.setText("Congratulations ! You have passed all your classes for this semester");
                    Toast tt = new Toast(getApplicationContext());
                    tt.setDuration(Toast.LENGTH_LONG);
                    tt.setView(uv);
                    tt.show();
                }

                //set the grades entered in TextView
                aa.setText(aaa);
                bb.setText(bbb);
                cc.setText(ccc);
                dd.setText(ddd);
                ee.setText(eee);

                //calculate gpa
                calc(aaa);
                calc(bbb);
                calc(ccc);
                calc(ddd);
                calc(eee);
                double mark = (double) grade / 5;
                final double show = mark;

                Toast.makeText(getApplicationContext(), "Your SGPA is: " + show, Toast.LENGTH_LONG).show();

                grade = 0;
            }

            String check(int n) {
                if (n >= 90 && n <= 100) {
                    return "A";
                }
                if (n >= 80 && n <= 89) {
                    return "B";
                }
                if (n >= 70 && n <= 79) {
                    return "C";
                }
                if (n >= 60 && n <= 69) {
                    return "D";
                }
                if (n < 60) {
                    return "F";
                }
                return "M";
            }

            int calc(String z) {
                if (z.equals("A")) {
                    grade += 4;
                }
                if (z.equals("B")) {
                    grade += 3;
                }
                if (z.equals("C")) {
                    grade += 2;
                }
                if (z.equals("D")) {
                    grade += 1;
                }
                if (z.equals("F")) {
                    grade += 0;
                }
                return grade;
            }

        });
    }

}