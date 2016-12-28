package org.fingerlinks.mobile.android.support.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by raphaelbussa on 06/10/16.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL = LinearLayout.HORIZONTAL;
    public static final int VERTICAL = LinearLayout.VERTICAL;

    private int row;
    private int space;
    private int orientation;

    public SpacesItemDecoration(int row, int space, int orientation) {
        this.row = row;
        this.space = space;
        this.orientation = orientation;
    }

    public SpacesItemDecoration(int row, int space) {
        this.space = space;
        this.row = row;
        this.orientation = LinearLayout.VERTICAL;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int current = parent.getChildAdapterPosition(view);
        if (orientation == LinearLayout.VERTICAL) {
            if (current < row) {
                setSpace(outRect, space + space, space, space, space);
            } else {
                setSpace(outRect, 0, space, space, space);
            }
        } else {
            if (current < row) {
                setSpace(outRect, space, space + space, space, space);
            } else if (current == parent.getAdapter().getItemCount() - 1) {
                setSpace(outRect, space, 0, space + space, space);
            } else {
                setSpace(outRect, space, 0, space, space);
            }
        }
    }

    private void setSpace(Rect outRect, int top, int left, int right, int bottom) {
        outRect.top = top;
        outRect.left = left;
        outRect.right = right;
        outRect.bottom = bottom;
    }

}

