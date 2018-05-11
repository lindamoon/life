package top.lixb.base.module_main.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.vondear.rxtools.RxLogTool;

import top.lixb.base.module_main.R;
import top.lixb.base.module_main.databinding.ActivityWebViewBinding;
import top.lixb.base.module_main.viewmodel.WebViewModel;
import top.lixb.libcommon.binding.AbsBindingActivity;
import top.lixb.libsrc.router.RouteTable;

@Route(path = RouteTable.mainWeb)
public class WebViewActivity extends AbsBindingActivity<ActivityWebViewBinding,WebViewModel> {

    @Autowired
    public String url;
    @Autowired
    public String title;
    private long mBackPressed;
    private double TIME_INTERVAL = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("url",mBinding.webBase.getUrl());
    }

    @Override
    public void onBackPressed() {
        if (mBinding.webBase.canGoBack()) {
            mBinding.webBase.goBack();
        } else {
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(getBaseContext(), "再次点击返回键退出", Toast.LENGTH_SHORT).show();
            }
            mBackPressed = System.currentTimeMillis();
        }
    }

    @Override
    protected void initBinding(final ActivityWebViewBinding binding) {
        binding.setWeb(mViewModel);
        Bundle extras = getIntent().getExtras();
        url = extras.getString("url");
        title = extras.getString("title");
        setTitle(title);

        RxLogTool.e("webView url=" + url + ",title=" + title);

        mToolbar.findViewById(R.id.common_base_iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.webBase.canGoBack()) {
                    mBinding.webBase.goBack();
                } else {
                    finish();
                }
            }
        });

        binding.pbWebBase.setMax(100);
        if (TextUtils.isEmpty(url)) {
            url = "http://www.baidu.com";
        }

        WebSettings webSettings = binding.webBase.getSettings();
        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//加载缓存否则网络
        }

        if (Build.VERSION.SDK_INT >= 19) {
            webSettings.setLoadsImagesAutomatically(true);//图片自动缩放 打开
        } else {
            webSettings.setLoadsImagesAutomatically(false);//图片自动缩放 关闭
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            binding.webBase.setLayerType(View.LAYER_TYPE_SOFTWARE, null);//软件解码
        }
        binding.webBase.setLayerType(View.LAYER_TYPE_HARDWARE, null);//硬件解码

//        webSettings.setAllowContentAccess(true);
//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setAppCacheEnabled(true);
   /*     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }*/


        // setMediaPlaybackRequiresUserGesture(boolean require) //是否需要用户手势来播放Media，默认true

        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
//        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setSupportZoom(true);// 设置可以支持缩放
        webSettings.setBuiltInZoomControls(true);// 设置出现缩放工具 是否使用WebView内置的缩放组件，由浮动在窗口上的缩放控制和手势缩放控制组成，默认false

        webSettings.setDisplayZoomControls(false);//隐藏缩放工具
        webSettings.setUseWideViewPort(true);// 扩大比例的缩放

        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//自适应屏幕
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setDatabaseEnabled(true);//
        webSettings.setSavePassword(true);//保存密码
        webSettings.setDomStorageEnabled(true);//是否开启本地DOM存储  鉴于它的安全特性（任何人都能读取到它，尽管有相应的限制，将敏感数据存储在这里依然不是明智之举），Android 默认是关闭该功能的。
        binding.webBase.setSaveEnabled(true);
        binding.webBase.setKeepScreenOn(true);


        // 设置setWebChromeClient对象
        binding.webBase.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                binding.pbWebBase.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });
        //设置此方法可在WebView中打开链接，反之用浏览器打开
        binding.webBase.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!binding.webBase.getSettings().getLoadsImagesAutomatically()) {
                    binding.webBase.getSettings().setLoadsImagesAutomatically(true);
                }
                binding.pbWebBase.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                binding.pbWebBase.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                    return false;
                }


                // Otherwise allow the OS to handle things like tel, mailto, etc.
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
        binding.webBase.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(paramAnonymousString1));
                startActivity(intent);
            }
        });

        binding.webBase.loadUrl(url);

    }

}
