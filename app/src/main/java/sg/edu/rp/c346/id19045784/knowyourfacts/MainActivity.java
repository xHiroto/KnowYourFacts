package sg.edu.rp.c346.id19045784.knowyourfacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnReadLtr;
    ViewPager vPager;

    MyFragmentPagerAdapter adapter;
    ArrayList<Fragment> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReadLtr = findViewById(R.id.btnReadLtr);
        vPager = findViewById(R.id.viewpager1);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnReadLtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_next:
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max - 1) {
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                    return true;

                }
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}