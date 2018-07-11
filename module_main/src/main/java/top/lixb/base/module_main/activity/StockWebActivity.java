package top.lixb.base.module_main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;

import top.lixb.base.module_main.R;
import top.lixb.libcommon.base.BaseActivity;
import top.lixb.libsrc.router.RouteTable;

@Route(path = RouteTable.stockWeb)
public class StockWebActivity extends BaseActivity {

    public static final String URL = "http://119.23.226.159:10090/operatelog/list";
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_web);
        setNoTitle();
        mWebView = $(R.id.web);
        mWebView.loadUrl(URL);
    }
}
