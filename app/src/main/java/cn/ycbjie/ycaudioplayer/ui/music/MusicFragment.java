package cn.ycbjie.ycaudioplayer.ui.music;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.toast.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.ycbjie.ycaudioplayer.R;
import cn.ycbjie.ycaudioplayer.base.BaseFragment;
import cn.ycbjie.ycaudioplayer.base.BasePagerAdapter;
import cn.ycbjie.ycaudioplayer.ui.MainActivity;
import cn.ycbjie.ycaudioplayer.ui.cut.CutEditMusicFragment;
import cn.ycbjie.ycaudioplayer.ui.local.LocalMusicFragment;
import cn.ycbjie.ycaudioplayer.ui.onLine.OnLineMusicFragment;

/**
 * Created by yc on 2018/1/24.
 */

public class MusicFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.fl_music)
    FrameLayout flMusic;
    @Bind(R.id.vp_music)
    public ViewPager vpMusic;
    private MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_music;
    }

    @Override
    public void initView() {
        initViewPager();
        initFragment();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }



    private void initViewPager() {
        vpMusic.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    activity.flPlayBar.setVisibility(View.VISIBLE);
                    setPageSelected(true, false, false);
                } else if (position == 1) {
                    activity.flPlayBar.setVisibility(View.VISIBLE);
                    setPageSelected(false, true, false);
                } else {
                    activity.flPlayBar.setVisibility(View.GONE);
                    setPageSelected(false, false, true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setPageSelected(boolean local, boolean online, boolean cut) {
        activity.tvLocalMusic.setSelected(local);
        activity.tvOnlineMusic.setSelected(online);
        activity.tvCutMusic.setSelected(cut);
    }


    private void initFragment() {
        List<Fragment> fragments = new ArrayList<>();
        LocalMusicFragment mLocalMusicFragment = new LocalMusicFragment();
        OnLineMusicFragment onLineMusicFragment = new OnLineMusicFragment();
        CutEditMusicFragment cutEditMusicFragment = new CutEditMusicFragment();
        fragments.add(mLocalMusicFragment);
        fragments.add(onLineMusicFragment);
        fragments.add(cutEditMusicFragment);
        BasePagerAdapter adapter = new BasePagerAdapter(getChildFragmentManager(), fragments);
        vpMusic.setAdapter(adapter);
        activity.tvLocalMusic.setSelected(true);
    }


}
