package top.lixb.libcommon.net;

import com.vondear.rxtools.RxLogTool;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public abstract class CommonCallback implements Observer {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }

    private String responseStr;
    @Override
    public void onNext(Object o) {
        if (o instanceof ResponseBody) {
            try {
                responseStr = ((ResponseBody) o).string();
                onResponse(responseStr);
                RxLogTool.e(responseStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void onResponse(String response);
}
