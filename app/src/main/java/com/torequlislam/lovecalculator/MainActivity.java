package com.torequlislam.lovecalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText t1;
    String string1,string2;
     String sharebody,body;
     TextView v1;

    // private Bundle data;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button b1 = (Button) findViewById(R.id.start);


        final TextView v1 = (TextView) findViewById(R.id.textview1);
        final EditText t1 = (EditText) findViewById(R.id.edittext1);
        final EditText t2 = (EditText) findViewById(R.id.edittext2);




        t1.setText("");
        t2.setText("");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(getApplicationContext(), "Hello world", Toast.LENGTH_LONG).show();
                 string1 = t1.getText().toString().toUpperCase();
                 string2 = t2.getText().toString().toUpperCase();

                int[] a1;
                a1 = new int[500];
                int[] a2;
                a2 = new int[500];

                int i, j, k1, k2, l, m, n, p, r, X, Y, sum1 = 0, sum2 = 0, SUM1 = 0, SUM2 = 0, per1, per2;
                float tmp1, tmp2;
                for (r = 65; r <= 122; r++) {
                    if (r >= 65 && r <= 90) {
                        a1[r] = r - 64;
                    } else if (r >= 97 && r <= 122) {
                        a1[r] = r - 96;
                    }
                }

                for (j = 65; j <= 122; j++) {
                    if (j >= 65 && j <= 90) {
                        a2[j] = j - 64;
                    } else if (j >= 97 && j <= 122) {
                        a2[j] = j - 96;
                    }
                }

                sum1 = 0;

                for (i = 0; i < t1.length(); i++) {
                    k1 = string1.charAt(i);
                    sum1 += a1[k1];

                }
                // tmp1=sum1;

                for (; ; ) {
                    sum2 = 0;
                    for (l = 0; ; l++) {
                        m = sum1 % 10;
                        sum2 += m;
                        n = sum1 / 10;
                        sum1 = n;
                        if (n < 1)
                            break;
                    }
                    sum1 = sum2;
                    tmp1 = sum1;
                    if (sum2 < 10)
                        break;
                }
                //printf("%.2f \n",temp1);

                SUM1 = 0;

                for (p = 0; p < t2.length(); p++) {
                    k2 = string2.charAt(p);
                    SUM1 += a2[k2];
                }
                //printf("%lld \n",SUM1);
                for (; ; ) {
                    SUM2 = 0;
                    for (l = 0; ; l++) {
                        X = SUM1 % 10;
                        SUM2 += X;
                        Y = SUM1 / 10;
                        SUM1 = Y;
                        if (Y < 1)
                            break;
                    }
                    SUM1 = SUM2;
                    tmp2 = SUM1;
                    if (SUM2 < 10)
                        break;
                }
                //printf("%.2f\n",temp2);
                if (string1.equals("") && string2.equals("")) {
                    tmp1 = 1;
                    tmp2 = 1;
                }

                if (tmp1 < tmp2) {
                    per1 = (int) ((tmp1 / tmp2) * 100);

                    v1.setText("" + per1 + "%");
                    body=Integer.toString(per1);
                    //printf("%.2f %%\n",per1);
                    // Toast.makeText(getApplicationContext(), "" + per1, Toast.LENGTH_LONG).show();
                } else {
                    per2 = (int) ((tmp2 / tmp1) * 100);
                    v1.setText("" + per2 + "%");
                    body=Integer.toString(per2);
                    // printf("%.2f %%\n",per2);
                    // Toast.makeText(getApplicationContext(), "" + per2, Toast.LENGTH_LONG).show();

                }

                sharebody = string1 +" & "+ string2 +" Love's each other "+ body+"%.";


            }
        });



         Button b2= (Button)findViewById(R.id.share);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                //String shareBody=; //= "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });


    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
