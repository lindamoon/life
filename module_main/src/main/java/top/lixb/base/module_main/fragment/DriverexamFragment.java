package top.lixb.base.module_main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

public class DriverexamFragment extends Fragment {
    public static DriverexamFragment newInstance() {
        Bundle args = new Bundle();
        DriverexamFragment fragment = new DriverexamFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
