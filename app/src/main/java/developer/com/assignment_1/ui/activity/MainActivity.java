package developer.com.assignment_1.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import developer.com.assignment_1.R;
import developer.com.assignment_1.adapter.ViewpagerAdapter;
import developer.com.assignment_1.widgets.CirclePageIndicator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llHorizontal;
    private ViewPager viewPager;
    private CirclePageIndicator pageIndicator;
    private TextView txtItem;
    private Button btnRed;
    private Button btnBlue;
    private Button btnGreen;
    private LinearLayout llButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initData();
    }

    private void initViews() {

        llHorizontal = (LinearLayout) findViewById(R.id.llHorizontal);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        pageIndicator = (CirclePageIndicator) findViewById(R.id.pageIndicator);

        txtItem = (TextView) findViewById(R.id.txtItem);
        btnRed = (Button) findViewById(R.id.btnRed);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        llButtons = (LinearLayout) findViewById(R.id.llButtons);

    }


    private void initData() {

        int deviceWidth = getDeviceWidth(this);

        for (int i = 0; i < 5; i++) {

            final TextView textView = new TextView(this);
            textView.setText("Item " + (i + 1));

            textView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(deviceWidth / 3, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(layoutParams);
            llHorizontal.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    txtItem.setText(textView.getText().toString());
                }
            });

        }

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(viewpagerAdapter);
        pageIndicator.setViewPager(viewPager);

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);


    }


    public int getDeviceWidth(Context context) {

        int width = 400;
        int height = 600; // just intialising it to default value in case if there is any problem getting screen width
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        if (android.os.Build.VERSION.SDK_INT >= 13) {
            Point size = new Point();
            display.getSize(size);
            width = size.x;
            height = size.y;
        } else {
            width = display.getWidth();
            height = display.getHeight();
        }
        return width;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnRed:
                llButtons.setBackgroundColor(Color.RED);

                break;
            case R.id.btnBlue:
                llButtons.setBackgroundColor(Color.BLUE);

                break;
            case R.id.btnGreen:
                llButtons.setBackgroundColor(Color.GREEN);

                break;
        }
    }
}