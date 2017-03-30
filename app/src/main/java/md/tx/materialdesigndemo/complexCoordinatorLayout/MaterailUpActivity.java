package md.tx.materialdesigndemo.complexCoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import md.tx.materialdesigndemo.R;

public class MaterailUpActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private ImageView cIVHead;
    private int mMaxScrollSize;

    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materail_up);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.material_tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        cIVHead = (ImageView) findViewById(R.id.cIvHead);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        appBarLayout.addOnOffsetChangedListener(this);
        mMaxScrollSize = appBarLayout.getTotalScrollRange();

        viewPager.setAdapter(new TabsApdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }


    public static void start(Context context) {
        context.startActivity(new Intent(context, MaterailUpActivity.class));
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mMaxScrollSize == 0) {
            mMaxScrollSize = appBarLayout.getTotalScrollRange();
        }

        int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

        Log.d("taxi", "移动的比例=" + percentage + "%");
        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;
            cIVHead.animate().scaleX(0).scaleY(0).setDuration(200).start();
        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;
            cIVHead.animate().scaleX(1).scaleY(1).start();
        }
    }


    class TabsApdapter extends FragmentPagerAdapter {
        public TabsApdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return MaterialUpConceptFakePage.newInstance();

                case 1:
                    return ListViewFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Tab 1";
                case 1:
                    return "Tab 2";
            }
            return "";
        }
    }
}

