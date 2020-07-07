package com.example.lottery;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.TextView;

        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.LinkedHashMap;
        import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private SimpleAdapter adapter;
    private LinkedList<HashMap<String, String>> data;
    private String[] from = {"title", "num0", "num1", "num2", "num3", "num4", "num5"};
    private int[] to = {R.id.item_title, R.id.item_num0, R.id.item_num1, R.id.item_num2, R.id.item_num3, R.id.item_num4, R.id.item_num5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        initview();
    }

    public void initview() {

        data = new LinkedList<>();
        adapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        list.setAdapter(adapter);

    }

    public void lottery(View view) {
        int[] lotternum = createlottery();
        HashMap<String, String> row = new HashMap<>();
        row.put(from[0], "第" + data.size() + 1 + "組");
        for(int i =0; i<6 ; i++)
        {
            row.put(from[i+1],""+lotternum[i]);
        }
        data.add(row);
        adapter.notifyDataSetChanged();
        list.smoothScrollToPosition(data.size()-1); //將畫面移動到新增的位置

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