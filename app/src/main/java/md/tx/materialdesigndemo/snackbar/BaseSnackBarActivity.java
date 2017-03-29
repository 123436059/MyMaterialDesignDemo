package md.tx.materialdesigndemo.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import md.tx.materialdesigndemo.R;

public class BaseSnackBarActivity extends AppCompatActivity {

    @BindView(R.id.activity_base_snack_bar)
    LinearLayout activityBaseSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_snack_bar);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btnSnackBar, R.id.btnSnackBar1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSnackBar:
                Snackbar.make(activityBaseSnackBar, "点击", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.btnSnackBar1:
                Snackbar.make(activityBaseSnackBar, "收到消息", Snackbar.LENGTH_INDEFINITE)
                        .setAction("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(BaseSnackBarActivity.this, "onclick", Toast.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(Color.RED).show();
                break;
        }

    }
}
