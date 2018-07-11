package top.lixb.base.module_main.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.vondear.rxtools.RxLogTool;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        RxLogTool.e("BootReceiver--onReceive: "+intent.getAction());
    }
}
