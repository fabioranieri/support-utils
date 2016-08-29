package org.fingerlinks.mobile.android.support.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by raphaelbussa on 20/02/16.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int row;
    private int space;

    public SpacesItemDecoration(int row, int space) {
        this.space = space;
        this.row = row;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int current = parent.getChildAdapterPosition(view);
        if (current < row) {
            setSpace(outRect, space + space, space, space, space);
        } else {
            setSpace(outRect, 0, space, space, space);
        }
    }

    private void setSpace(Rect outRect, int top, int left, int right, int bottom) {
        outRect.top = top;
        outRect.left = left;
        outRect.right = right;
        outRect.bottom = bottom;
    }

}
