package md.tx.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import md.tx.materialdesigndemo.complexCoordinatorLayout.BaseCoordinatorLayoutActivity;
import md.tx.materialdesigndemo.complexCoordinatorLayout.ScrollingActivity;
import md.tx.materialdesigndemo.floatActionButton.BaseFloatActionButton;
import md.tx.materialdesigndemo.snackbar.BaseSnackBarActivity;
import md.tx.materialdesigndemo.textInputLayout.BaseTextInputlayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSnackBar, R.id.btnTextInputLayout, R.id.btnFloatActionButton, R.id.btnCoordinator, R.id.btnOfficialCoordinator})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSnackBar:
                startActivity(new Intent(this, BaseSnackBarActivity.class));
                break;

            case R.id.btnTextInputLayout:
                startActivity(new Intent(this, BaseTextInputlayoutActivity.class));
                break;

            case R.id.btnFloatActionButton:
                startActivity(new Intent(this, BaseFloatActionButton.class));
                break;

            case R.id.btnCoordinator:
                startActivity(new Intent(this, BaseCoordinatorLayoutActivity.class));
                break;

            case R.id.btnOfficialCoordinator:
                startActivity(new Intent(this, ScrollingActivity.class));
                break;
        }
    }
}
