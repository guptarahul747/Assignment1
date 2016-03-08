package developer.com.assignment_1.ui.activity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import developer.com.assignment_1.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initData();
    }

    private void initViews() {

        llHorizontal = (LinearLayout) findViewById(R.id.llHorizontal);
    }


    private void initData() {

        int deviceWidth = getDeviceWidth(this);

        for (int i = 0; i < 5; i++) {

            TextView textView = new TextView(this);
            textView.setText("Item " + (i + 1));
            textView.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(deviceWidth / 3, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(layoutParams);
            llHorizontal.addView(textView);
        }
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


}
