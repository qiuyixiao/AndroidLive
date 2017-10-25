package com.yuyoubang.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yuyoubang.R;

/**
 * Created by lenovo on 2017/10/24.
 */

public class UserFragment extends Fragment {
    @Nullable
    ListView listView;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fra_user, null);
        init();
        return v;
    }

    void init() {
        listView = (ListView) v.findViewById(R.id.listview);
        //要显示的数据
        String[] strs = {"基神", "B神", "翔神", "曹神", "J神"};
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_expandable_list_item_1, strs);
        listView.setAdapter(adapter);
    }

}
