package com.example.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;
    TextView aa,ba,ca,da,ea,fa,ga,ha;
    int grade = 0;
    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.math);
        e2 = findViewById(R.id.oops);
        e3 = findViewById(R.id.ds);
        e4 = findViewById(R.id.coa);
        e5 = findViewById(R.id.ade);
        e6 = findViewById(R.id.bio);

        b1 = findViewById(R.id.but);
        b2 = findViewById(R.id.re);
        share = findViewById(R.id.share);

        aa = findViewById(R.id.ds1);
        ba = findViewById(R.id.ds2);
        ca = findViewById(R.id.ds3);
        da = findViewById(R.id.ds4);
        ea = findViewById(R.id.ds5);
        fa = findViewById(R.id.ds6);
        ga = findViewById(R.id.pass);
        ha = findViewById(R.id.fail);

        b2.setOnClickListener((v)->{
            e1.setText(" ");
            e2.setText(" ");
            e3.setText(" ");
            e4.setText(" ");
            e5.setText(" ");
            aa.setText(" ");
            ba.setText(" ");
            ca.setText(" ");
            da.setText(" ");
            ea.setText(" ");
            fa.setText(" ");
            ga.setText(" ");
            ha.setText(" ");
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a = new Integer(e1.getText().toString());
                int b = Integer.parseInt(e2.getText().toString());
                int c = Integer.parseInt(e3.getText().toString());
                int d = Integer.parseInt(e4.getText().toString());
                int e = Integer.parseInt(e5.getText().toString());
                int f = Integer.parseInt(e6.getText().toString());

                String aaa = check(a);
                String bbb = check(b);
                String ccc = check(c);
                String ddd = check(d);
                String eee = check(e);
                String fff = check(f);

                if(aaa.equals("F") || bbb.equals("F") || ccc.equals("F") || ddd.equals("F") || eee.equals("F") || fff.equals("F")){

                    ga.setText("YOU HAVE FAILED");

                }
                else{
                    ha.setText("ALL CLEARED");
                }
                aa.setText(aaa);
                ba.setText(bbb);
                ca.setText(ccc);
                da.setText(ddd);
                ea.setText(eee);
                fa.setText(fff);

                calc(aaa);
                calc(bbb);
                calc(ccc);
                calc(ddd);
                calc(eee);
                calc(fff);
                calc(fff);
                double mark = (double) grade / 6;
                final double show = mark;
                if (show >10 ){
                    int perfect = 10;
                    Toast.makeText(MainActivity.this, "YOUR CGPA IS --> " + perfect, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "YOUR CGPA IS : " + show, Toast.LENGTH_SHORT).show();
                }grade = 0;

                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this , SendPage.class);
                        startActivity(intent);
                    }
                });

            }

            String check(int n){
                if( n >= 95 && n <= 100 ){
                    return "O";
                }
                if( n >= 80 && n <= 94 ){
                    return "A+";
                }
                if( n >= 75 && n <= 79 ){
                    return "A";
                }
                if( n >= 65 && n <= 74){
                    return "B+";
                }
                if( n >= 55 && n <= 64 ){
                    return "B";
                }
                if( n >= 45 && n <= 54 ){
                    return "C";
                }
                if( n >= 40 && n <=44 ){
                    return "D";
                }
                if( n < 40){
                    return "F";
                }
                return "ML";
            }

            int calc(String z){
                if(z.equals("O")){
                    grade += 10;
                }
                if (z.equals("A+")){
                    grade += 9;
                }
                if (z.equals("A")){
                    grade += 8;
                }
                if (z.equals("B+")){
                    grade += 7;
                }
                if (z.equals("B")){
                    grade += 6;
                }
                if (z.equals("C+")){
                    grade += 5;
                }
                if (z.equals("C")){
                    grade += 4;
                }
                if (z.equals("D")){
                    grade += 3;
                }
                if (z.equals("F")){
                    grade +=2;
                }
                return grade;
            }

        });



    }
}
