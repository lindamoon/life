package top.lixb.base.module_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.router.RouteTable;

@Route(path = RouteTable.mainHome)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
