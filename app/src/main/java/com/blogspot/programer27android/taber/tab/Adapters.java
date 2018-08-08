package com.blogspot.programer27android.taber.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.blogspot.programer27android.taber.R;
import com.blogspot.programer27android.taber.fragment.ChatFragmen;
import com.blogspot.programer27android.taber.fragment.ExploreFragmen;
import com.blogspot.programer27android.taber.fragment.FriendFragmen;
import com.blogspot.programer27android.taber.fragment.HomeFragment;

public class Adapters extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"A", "B", "C","D"};
    int[] icon = new int[]{R.drawable.ic_home, R.drawable.ic_chat, R.drawable.ic_contacts, R.drawable.ic_explore};
    private int heighticon;

    public Adapters(FragmentManager fm, Context c) {
        super(fm);
        double scale = c.getResources().getDisplayMetrics().density;
        heighticon = (int) (24 * scale + 0.5f);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fraq = null;
        if (position == 0) {
            fraq = new HomeFragment();
        } else if (position == 1) {
            fraq = new ChatFragmen();
        } else if (position == 2) {
            fraq = new FriendFragmen();
        } else if (position == 3) {
            fraq = new ExploreFragmen();
        }
        Bundle b = new Bundle();
        b.putInt("posisi", position);
        fraq.setArguments(b);
        return fraq;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position) {
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heighticon,heighticon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }
}