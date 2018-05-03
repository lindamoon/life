package top.lixb.libcommon.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import top.lixb.libcommon.R;

public class BaseRecyclerViewActivity extends BaseActivity {

    RecyclerView mRvRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler);
        mRvRoot = (RecyclerView) findViewById(R.id.rv_root);

    }
}
