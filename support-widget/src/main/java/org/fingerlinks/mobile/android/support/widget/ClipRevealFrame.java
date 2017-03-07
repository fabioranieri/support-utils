/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Ranieri Fabio - Fingerlinks
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
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * CircularReveal backport
 * https://gist.github.com/schwiz/e566f248723bb1754972
 */
public class ClipRevealFrame extends FrameLayout {

    boolean clipOutlines;
    float centerX;
    float centerY;
    float radius;
    private Path revealPath;

    public ClipRevealFrame(Context context) {
        super(context);
        init();
    }

    public ClipRevealFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipRevealFrame(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        revealPath = new Path();
        clipOutlines = false;
    }

    public void setClipOutLines(boolean shouldClip) {
        clipOutlines = shouldClip;
    }

    public void setClipCenter(final int x, final int y) {
        centerX = x;
        centerY = y;
    }

    public void setClipRadius(final float radius) {
        this.radius = radius;
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        if (!clipOutlines) {
            super.draw(canvas);
            return;
        }
        final int state = canvas.save();
        revealPath.reset();
        revealPath.addCircle(centerX, centerY, radius, Path.Direction.CW);
        canvas.clipPath(revealPath);
        super.draw(canvas);
        canvas.restoreToCount(state);
    }

}
