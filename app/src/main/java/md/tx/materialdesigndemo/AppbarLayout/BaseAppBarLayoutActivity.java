package md.tx.materialdesigndemo.AppbarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import md.tx.materialdesigndemo.R;

public class BaseAppBarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_app_bar_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnFlagScroll, R.id.btnFlagExitUntilCollapsed})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFlagScroll:
                startActivity(new Intent(this, AppBarScrollActivity.class));
                break;
            case R.id.btnFlagExitUntilCollapsed:

                break;
        }
    }
}
