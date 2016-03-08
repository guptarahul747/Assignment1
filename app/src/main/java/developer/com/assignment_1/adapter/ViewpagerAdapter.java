package developer.com.assignment_1.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rahul on 8/3/16.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter{

    private Context context;

    public ViewpagerAdapter(Context context , FragmentManager fm) {
        super(fm);

        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
