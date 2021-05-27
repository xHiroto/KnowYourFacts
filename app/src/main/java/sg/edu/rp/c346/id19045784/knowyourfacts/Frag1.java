package sg.edu.rp.c346.id19045784.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Frag1 extends Fragment implements RssReader.RssCallback {

    Button btnChangeColor;
    LinearLayout frag1Layout;
    Button btnRetreiveRSS;
    RssReader rssReader;
    TextView tv1, tv2;
    WebView wv1, wv2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        btnChangeColor = view.findViewById(R.id.btnChangeColor);
        frag1Layout = view.findViewById(R.id.LinearLayoutFrag1);
        tv1 = view.findViewById(R.id.textView);
        tv2 = view.findViewById(R.id.textView3);
        wv1 = view.findViewById(R.id.wv1);
        wv2 = view.findViewById(R.id.wv2);
        btnRetreiveRSS = view.findViewById(R.id.btnRetrieve);
        rssReader = new RssReader(this);



        btnRetreiveRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] url = new String[]{"https://www.channelnewsasia.com/rssfeeds/8395986"};
                rssReader.loadFeeds(url);
            }
        });

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

                frag1Layout.setBackgroundColor(color);
                wv1.setBackgroundColor(color);
                wv2.setBackgroundColor(color);
            }
        });
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        return view;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
            rssReader.destroy();
    }


    public void rssFeedsLoaded(List<RSS> rssList) {
        // Feeds loaded, do whatever you want to do with them.
        RSS item = rssList.get(0);
        tv1.setText(item.getChannel().getItems().get(1).getTitle());
        wv1.loadData(item.getChannel().getItems().get(0).getDescription(), "text/html; charset-utf-8", "utf-8");


        tv2.setText(item.getChannel().getItems().get(1).getTitle());
        wv2.loadData(item.getChannel().getItems().get(1).getDescription(), "text/html; charset-utf-8", "utf-8");
    }

    public void unableToReadRssFeeds(String errorMessage) {
        // Oops, library was unable to parse your feed url.
        Toast.makeText(getActivity(), "Failed Loading RSS", Toast.LENGTH_SHORT).show();
    }
    
}