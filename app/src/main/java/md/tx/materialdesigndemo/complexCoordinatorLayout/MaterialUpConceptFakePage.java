package md.tx.materialdesigndemo.complexCoordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import md.tx.materialdesigndemo.R;

/**
 * Created by Taxi on 2017/3/30.
 */

public class MaterialUpConceptFakePage extends Fragment {

    private RecyclerView mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (RecyclerView) inflater.inflate(R.layout.fragment_page, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRootView.setAdapter(new FakePageAdapter(20));
    }

    public static Fragment newInstance() {
        return new MaterialUpConceptFakePage();
    }
}
