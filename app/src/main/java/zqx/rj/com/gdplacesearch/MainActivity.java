package zqx.rj.com.gdplacesearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.services.help.Tip;

/**
 * author：  HyZhan
 * created：2018/9/20 15:06
 * desc：    TODO
 */

public class MainActivity extends AppCompatActivity {

    private TextView mTvPlace;
    private static final int REQUEST_PLACE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBtnSearch = findViewById(R.id.btn_search);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputTipsActivity.class);
                startActivityForResult(intent, REQUEST_PLACE);
            }
        });

        mTvPlace = findViewById(R.id.tv_place);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PLACE) {
            if (resultCode == InputTipsActivity.RESULT_CODE_INPUTTIPS && data != null) {
                final Tip tip = data.getParcelableExtra("tip");
                if (tip.getName() != null) {
                    mTvPlace.setText("选择地点是：" + tip.getName());
                }
            }
        }
    }
}
