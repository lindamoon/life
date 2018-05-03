package top.lixb.base.module_update;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.router.RouteTable;

@Route(path = RouteTable.updateIndex)
public class UpdateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
