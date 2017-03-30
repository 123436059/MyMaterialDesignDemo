package md.tx.materialdesigndemo.complexCoordinatorLayout;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import md.tx.materialdesigndemo.R;
import md.tx.materialdesigndemo.complexCoordinatorLayout.customBehavior.DependBehavior;

public class CustomBehaviorImgActivity extends AppCompatActivity {

    @BindView(R.id.ivDependency)
    ImageView ivDependency;
    @BindView(R.id.ivChild)
    ImageView ivChild;

    private int mLastX;
    private int mLastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior_img);
        ButterKnife.bind(this);

        ivDependency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mLastX = x;
                        mLastY = y;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        int offsetX = x-mLastX;
                        int offsetY = y - mLastY;
                        ivDependency.offsetLeftAndRight(offsetX);
                        ivDependency.offsetTopAndBottom(offsetY);
                        break;

                    default:
                        break;

                }
                return true;
            }
        });

        ivChild.postDelayed(new Runnable() {
            @Override
            public void run() {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) ivChild.getLayoutParams();
                DependBehavior dependBehavior = (DependBehavior) layoutParams.getBehavior();
                dependBehavior.setInitDisX(ivDependency.getLeft() - ivChild.getLeft());
            }
        }, 1000);

//        ivChild1.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) ivChild1.getLayoutParams();
//                DependBehavior dependBehavior = (DependBehavior) layoutParams.getBehavior();
//                dependBehavior.setInitDisX(ivDependency.getLeft() - ivChild1.getLeft());
//            }
//        }, 1000);
    }
}
