package top.lixb.base.module_main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

public class NewsFragment extends Fragment {
    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
