package com.kevin.viewpagerdemo;

import android.content.Context;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/**
 * @author : 王康
 * @date : 2022/3/30
 * @desc :
 */
public class MainFragment extends Fragment {


    private FragmentActivity fragmentActivity;
    private View mView;


    public static MainFragment newInstance(int color, int index) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(FragmentKey.COLOR, color);
        bundle.putInt(FragmentKey.INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActivity = requireActivity();

    }

    public FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_main, container, false);
        }
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView appCompatTextView = mView.findViewById(R.id.fragment_bg);
        int mColor = getArguments() == null ? 0 : getArguments().getInt(FragmentKey.COLOR, 0);
        int mIndex = getArguments() == null ? 0 : getArguments().getInt(FragmentKey.INDEX, 0);
        appCompatTextView.setText(String.format("我的下标：%s", mIndex));
        switch (mColor) {
            case 1:
                appCompatTextView.setBackground(ContextCompat.getDrawable(getFragmentActivity(), R.color.purple_200));
                break;
            case 2:
                appCompatTextView.setBackground(ContextCompat.getDrawable(getFragmentActivity(), R.color.purple_500));
                break;
            case 3:
                appCompatTextView.setBackground(ContextCompat.getDrawable(getFragmentActivity(), R.color.purple_700));
                break;
            case 4:
                appCompatTextView.setBackground(ContextCompat.getDrawable(getFragmentActivity(), R.color.teal_200));
                break;
            case 5:
                appCompatTextView.setBackground(ContextCompat.getDrawable(getFragmentActivity(), R.color.teal_700));
                break;
            default:
                appCompatTextView.setBackground(ContextCompat.getDrawable(getFragmentActivity(), R.color.white));
                break;

        }

    }
}
