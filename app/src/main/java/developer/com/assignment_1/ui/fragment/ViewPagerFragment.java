package developer.com.assignment_1.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import developer.com.assignment_1.R;

/**
 * Created by Rahul on 8/3/16.
 */
public class ViewPagerFragment extends Fragment {

    private TextView txtFragment;
    private static OnViewPagerClickListner pagerClickListner;
    private int position;
    public interface OnViewPagerClickListner {

        void onPageClicked(int pos);
    }



    public static Fragment newInstance(int position, OnViewPagerClickListner listner) {

        pagerClickListner = listner;
        Fragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        initViews(view);

        return view;
    }

    private void initViews(View view) {

        position = getArguments().getInt("pos");
        txtFragment = (TextView) view.findViewById(R.id.txtFragment);
        txtFragment.setText("Fragment "+position);

        txtFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pagerClickListner != null) {

                    pagerClickListner.onPageClicked(position);
                }
            }
        });
    }
}
