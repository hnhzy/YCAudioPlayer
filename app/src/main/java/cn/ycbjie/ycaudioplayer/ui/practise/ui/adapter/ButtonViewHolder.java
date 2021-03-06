package cn.ycbjie.ycaudioplayer.ui.practise.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.yc.cn.ycbannerlib.first.BannerView;
import com.yc.cn.ycbannerlib.first.util.SizeUtil;
import com.yc.cn.ycbaseadapterlib.BaseViewHolder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.ycbjie.ycaudioplayer.R;
import cn.ycbjie.ycaudioplayer.ui.study.ui.adapter.BannerPagerAdapter;

/**
 * Created by yc on 2018/3/20.
 */

public class ButtonViewHolder extends BaseViewHolder {


    private final TextView tv_home_first;
    private final TextView tv_home_second;
    private final TextView tv_home_third;
    private final TextView tv_home_four;
    private final TextView tv_home_five;

    public ButtonViewHolder(View itemView) {
        super(itemView);
        tv_home_first = getView(R.id.tv_home_first);
        tv_home_second = getView(R.id.tv_home_second);
        tv_home_third = getView(R.id.tv_home_third);
        tv_home_four = getView(R.id.tv_home_four);
        tv_home_five = getView(R.id.tv_home_five);
    }


    public void bindData(List<String> mButtonList, Context mContext) {
        if(mButtonList!=null && mButtonList.size()>0){
            tv_home_first.setText(mButtonList.get(0));
            tv_home_second.setText(mButtonList.get(1));
            tv_home_third.setText(mButtonList.get(2));
            tv_home_four.setText(mButtonList.get(3));
            tv_home_five.setText(mButtonList.get(4));
        }
    }
}
