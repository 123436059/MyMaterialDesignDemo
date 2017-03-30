package md.tx.materialdesigndemo.complexCoordinatorLayout.customBehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Taxi on 2017/3/30.
 */

public class DependBehavior extends CoordinatorLayout.Behavior<View> {

    private int initDisX = 0;

    public DependBehavior() {
    }

    public DependBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setInitDisX(int initDisX) {
        this.initDisX = initDisX;
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof ImageView;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int offsetX = dependency.getLeft() - child.getLeft() - initDisX;
        int offsetY = dependency.getTop() - child.getTop();

        child.offsetLeftAndRight(offsetX);
        child.offsetTopAndBottom(offsetY);
        return true;
    }
}
