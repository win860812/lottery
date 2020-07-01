package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private TextView[] g1 = new TextView[6];
    private int[] g1n = {R.id.g1_n1, R.id.g1_n2, R.id.g1_n3
            , R.id.g1_n4, R.id.g1_n5, R.id.g1_n6};

    private TextView[] g2 = new TextView[6];
    private int[] g2n = {R.id.g2_n1, R.id.g2_n2, R.id.g2_n3
            , R.id.g2_n4, R.id.g2_n5, R.id.g2_n6};

    private TextView[] g3 = new TextView[6];
    private int[] g3n = {R.id.g3_n1, R.id.g3_n2, R.id.g3_n3
            , R.id.g3_n4, R.id.g3_n5, R.id.g3_n6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    public void initview() {
        for (int i = 0; i < g1.length; i++) {
            g1[i] = findViewById(g1n[i]);
            g1[i].setText("-");
        }
        for (int i = 0; i < g2.length; i++) {
            g2[i] = findViewById(g2n[i]);
            g2[i].setText("-");
        }
        for (int i = 0; i < g3.length; i++) {
            g3[i] = findViewById(g3n[i]);
            g3[i].setText("-");
        }

    }

    public void lottery(View view) {
        int[] num1 = createlottery();
        for(int i=0 ; i<g1.length;i++)
        {
            g1[i].setText(""+num1[i]);
        }

        int[] num2 = createlottery();
        for(int i=0 ; i<g1.length;i++)
        {
            g2[i].setText(""+num2[i]);
        }

        int[] num3 = createlottery();
        for(int i=0 ; i<g1.length;i++)
        {
            g3[i].setText(""+num3[i]);
        }

    }

    public int[] createlottery() {
        HashSet<Integer> nums = new HashSet<>();
        while (nums.size() < 6) {
            nums.add((int) (Math.random() * 49 + 1));
        }
        int i = 0;
        int[] ret = new int[6];
        for (Integer num : nums) {
            ret[i] = num;
            i++;
        }
        return ret;
    }
}