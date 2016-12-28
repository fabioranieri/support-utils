package org.fingerlinks.mobile.android.support.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by raphaelbussa on 01/09/16.
 */
public class SnackBarCustom {

    public static final int LENGTH_INDEFINITE = Snackbar.LENGTH_INDEFINITE;
    public static final int LENGTH_SHORT = Snackbar.LENGTH_SHORT;
    public static final int LENGTH_LONG = Snackbar.LENGTH_LONG;

    private Snackbar snackbar;
    private Context context;

    private Snackbar.Callback callback;
    private Snackbar.SnackbarLayout snackbarView;
    private View.OnClickListener listener;
    private CharSequence text;

    private TextView snackbarText;
    private TextView snackbarAction;

    private boolean dismissable = true;
    private boolean asToast = false;

    public static SnackBarCustom make(@NonNull View view, @NonNull CharSequence text, int duration) {
        SnackBarCustom snackBarCustom = new SnackBarCustom();
        snackBarCustom.init(view, text, duration);
        return snackBarCustom;
    }

    public static SnackBarCustom make(@NonNull View view, @StringRes int resId, int duration) {
        return make(view, view.getResources().getText(resId), duration);
    }

    private void init(@NonNull View view, @NonNull CharSequence text, @Snackbar.Duration int duration) {
        context = view.getContext();
        snackbar = Snackbar.make(view, text, duration);
        snackbarView = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarText = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        snackbarAction = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_action);
        snackbarText.setMaxLines(100);
    }

    public SnackBarCustom setCallback(Snackbar.Callback callback) {
        this.callback = callback;
        return this;
    }

    public SnackBarCustom dismissable(boolean dismissable) {
        this.dismissable = dismissable;
        return this;
    }

    public SnackBarCustom setAction(@StringRes int resId, final View.OnClickListener listener) {
        return setAction(context.getText(resId), listener);
    }

    public SnackBarCustom asToast() {
        this.asToast = true;
        return this;
    }

    public SnackBarCustom setAction(CharSequence text, final View.OnClickListener listener) {
        this.text = text;
        this.listener = listener;
        return this;
    }

    public void dismiss() {
        snackbar.dismiss();
    }

    public void show() {
        if (callback != null) snackbar.setCallback(callback);
        if (text != null && listener != null) snackbar.setAction(text, listener);
        if (!dismissable) {
            snackbarView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    snackbarView.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (snackbarView.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
                        ((CoordinatorLayout.LayoutParams) snackbarView.getLayoutParams()).setBehavior(null);
                    }
                    return true;
                }
            });
        }
        if (asToast) {
            Toast toast = new Toast(snackbar.getView().getContext());
            toast.setView(snackbar.getView());
            int duration = Toast.LENGTH_LONG;
            switch (snackbar.getDuration()) {
                case Snackbar.LENGTH_INDEFINITE:
                case Snackbar.LENGTH_LONG:
                    duration = Toast.LENGTH_LONG;
                    break;
                case Snackbar.LENGTH_SHORT:
                    duration = Toast.LENGTH_SHORT;
                    break;
            }
            toast.setDuration(duration);
            toast.setMargin(0, 0);
            toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.BOTTOM, 0, 0);
            toast.show();
        } else {
            snackbar.show();
        }
    }

    public TextView getSnackbarText() {
        return snackbarText;
    }

    public TextView getSnackbarAction() {
        return snackbarAction;
    }
}
