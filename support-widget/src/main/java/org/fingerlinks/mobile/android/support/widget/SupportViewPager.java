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
package org.fingerlinks.mobile.android.support.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Raphael on 20/05/2015.
 */
public class SupportViewPager extends ViewPager {

    private boolean swipe = true;
    private SCROLL scroll = SCROLL.HORIZONTAL;

    public SupportViewPager(Context context) {
        super(context);
        init();
    }

    public SupportViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setSwipe(boolean swipe) {
        this.swipe = swipe;
    }

    public void setScroll(SCROLL scroll) {
        this.scroll = scroll;
    }

    private void init() {
        if (scroll == SCROLL.VERTICAL) {
            setPageTransformer(true, new VerticalPageTransformer());
            setOverScrollMode(OVER_SCROLL_NEVER);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (scroll == SCROLL.VERTICAL) {
            boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
            swapXY(ev);
            return swipe && intercepted;
        }
        return swipe && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (scroll == SCROLL.VERTICAL) {
            return swipe && super.onTouchEvent(swapXY(ev));
        }
        return swipe && super.onTouchEvent(ev);
    }

    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();
        float x = (ev.getY() / height) * width;
        float y = (ev.getX() / width) * height;
        ev.setLocation(x, y);
        return ev;
    }

    public enum SCROLL {
        HORIZONTAL, VERTICAL
    }

    private class VerticalPageTransformer implements PageTransformer {

        @Override
        public void transformPage(View page, float position) {
            if (position < -1) {
                page.setAlpha(0);
            } else if (position <= 1) {
                page.setAlpha(1);
                page.setTranslationX(page.getWidth() * -position);
                float y = position * page.getHeight();
                page.setTranslationY(y);
            } else {
                page.setAlpha(0);
            }
        }

    }

}