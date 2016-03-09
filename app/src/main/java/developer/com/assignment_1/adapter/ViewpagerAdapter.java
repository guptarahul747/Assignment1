package developer.com.assignment_1.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import developer.com.assignment_1.ui.fragment.ViewPagerFragment;

/**
 * Created by Rahul on 8/3/16.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {

    private int PAGE_COUNT = 4;
    private Context context;

    public ViewpagerAdapter(Context context, FragmentManager fm) {

        super(fm);

        this.context = context;
    }

    @Override
    public Fragment getItem(final int position) {

        switch (position) {

            case 0:
                return ViewPagerFragment.newInstance(position + 1,
                        new ViewPagerFragment.OnViewPagerClickListner() {
                            @Override
                            public void onPageClicked(int pos) {

                               Toast.makeText(context, "Clicked  " + pos, Toast.LENGTH_SHORT).show();

                            }
                        });

            case 1:
                return ViewPagerFragment.newInstance(position + 1,
                        new ViewPagerFragment.OnViewPagerClickListner() {
                            @Override
                            public void onPageClicked(int pos) {

                                Toast.makeText(context, "Clicked  " + pos, Toast.LENGTH_SHORT).show();
                            }
                        });

            case 2:
                return ViewPagerFragment.newInstance(position + 1,
                        new ViewPagerFragment.OnViewPagerClickListner() {
                            @Override
                            public void onPageClicked(int pos) {

                                Toast.makeText(context, "Clicked  " + pos, Toast.LENGTH_SHORT).show();
                            }
                        });

            case 3:
                return ViewPagerFragment.newInstance(position + 1,
                        new ViewPagerFragment.OnViewPagerClickListner() {
                            @Override
                            public void onPageClicked(int pos) {

                                Toast.makeText(context, "Clicked  " + pos, Toast.LENGTH_SHORT).show();
                            }
                        });

        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


}
