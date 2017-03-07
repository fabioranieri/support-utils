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
package org.fingerlinks.mobile.android.support.base.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Raphael on 07/10/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private View toolbarShadow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        if (getToolbarId() != 0) {
            toolbar = (Toolbar) findViewById(getToolbarId());
            if (toolbar != null) {
                setSupportActionBar(toolbar);
            }
        }
        if (getToolbarShadowId() != 0) {
            toolbarShadow = findViewById(getToolbarShadowId());
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public View getToolbarShadow() {
        return toolbarShadow;
    }

    public void setIcon(int icon) {
        if (getSupportActionBar() != null) getSupportActionBar().setIcon(icon);
    }

    public void setIcon(Drawable icon) {
        if (getSupportActionBar() != null) getSupportActionBar().setIcon(icon);
    }

    public void setTitle(String title) {
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
    }

    public void setTitle(int title) {
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
    }

    public void removeTitle() {
        setTitle("");
    }

    public void setSubtitle(String subtitle) {
        if (getSupportActionBar() != null) getSupportActionBar().setSubtitle(subtitle);
    }

    public void setSubtitle(int subtitle) {
        if (getSupportActionBar() != null) getSupportActionBar().setSubtitle(subtitle);
    }

    public void setNavigationIcon(int icon) {
        if (toolbar != null) toolbar.setNavigationIcon(icon);
    }

    public void setNavigationIcon(Drawable icon) {
        if (toolbar != null) toolbar.setNavigationIcon(icon);
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (toolbar != null) toolbar.setNavigationOnClickListener(onClickListener);
    }

    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    public void setStatusBarColorRes(int color) {
        setStatusBarColor(ContextCompat.getColor(this, color));
    }

    public void setLightStatusBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public Activity getActivity() {
        return this;
    }

    @LayoutRes
    protected abstract int getLayoutResource();

    public int getToolbarId() {
        return 0;
    }

    public int getToolbarShadowId() {
        return 0;
    }

}
