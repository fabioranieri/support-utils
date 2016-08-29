package org.fingerlinks.mobile.android.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by raphaelbussa on 26/08/16.
 */
public class SupportScrollView extends ScrollView {

    private OnScrollChangedListener onScrollChangedListener;

    public SupportScrollView(Context context) {
        super(context);
    }

    public SupportScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SupportScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangedListener != null)
            onScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }

}
