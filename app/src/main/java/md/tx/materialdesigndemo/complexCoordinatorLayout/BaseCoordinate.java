package md.tx.materialdesigndemo.complexCoordinatorLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import md.tx.materialdesigndemo.R;

public class BaseCoordinate extends AppCompatActivity {

    private static final String JIANSHU_URL = "http://www.jianshu.com/p/e5312fd916dd";
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_coordinate);
        ButterKnife.bind(this);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(JIANSHU_URL));
                startActivity(browserIntent);
                return true;
            }
        });

    }

    @OnClick({R.id.tvSimpleExample, R.id.tvGoogleIoDetailExample, R.id.tvFlexibleSpaceExample, R.id.tvSwipeBehaviorExample})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSimpleExample:
                SimpleCoordinatorLayoutActivity.start(this);
                break;
            case R.id.tvGoogleIoDetailExample:
                IOExampleActivity.start(this);
                break;
            case R.id.tvFlexibleSpaceExample:
                break;
            case R.id.tvSwipeBehaviorExample:
                break;
        }
    }
}
