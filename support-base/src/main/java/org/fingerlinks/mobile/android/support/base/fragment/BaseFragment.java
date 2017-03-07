/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Raphaël Bussa - Fingerlinks
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.fingerlinks.mobile.android.support.base.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.fingerlinks.mobile.android.support.base.activity.BaseActivity;

/**
 * Created by Raphael on 07/10/2015.
 */
public abstract class BaseFragment extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResource(), container, false);
        return rootView;
    }

    public Toolbar getToolbar() {
        return ((BaseActivity) getActivity()).getToolbar();
    }

    public View getToolbarShadow() {
        return ((BaseActivity) getActivity()).getToolbarShadow();
    }

    public View getRootView() {
        return rootView;
    }

    public void setIcon(int icon) {
        ((BaseActivity) getActivity()).setIcon(icon);
    }

    public void setIcon(Drawable icon) {
        ((BaseActivity) getActivity()).setIcon(icon);
    }

    public void setTitle(int title) {
        ((BaseActivity) getActivity()).setTitle(title);
    }

    public void setTitle(String title) {
        ((BaseActivity) getActivity()).setTitle(title);
    }

    public void setSubtitle(int subtitle) {
        ((BaseActivity) getActivity()).setSubtitle(subtitle);
    }

    public void setSubtitle(String subtitle) {
        ((BaseActivity) getActivity()).setSubtitle(subtitle);
    }

    public void removeTitle() {
        ((BaseActivity) getActivity()).setTitle("");
    }

    public void setNavigationIcon(int icon) {
        ((BaseActivity) getActivity()).setNavigationIcon(icon);
    }

    public void setNavigationIcon(Drawable icon) {
        ((BaseActivity) getActivity()).setNavigationIcon(icon);
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ((BaseActivity) getActivity()).setNavigationOnClickListener(onClickListener);
    }

    public void setStatusBarColor(int color) {
        ((BaseActivity) getActivity()).setStatusBarColor(color);
    }

    public void setStatusBarColorRes(int color) {
        ((BaseActivity) getActivity()).setStatusBarColorRes(color);
    }

    @LayoutRes
    protected abstract int getLayoutResource();

    public boolean onSupportBackPressed(Bundle bundle) {
        return false;
    }

}
