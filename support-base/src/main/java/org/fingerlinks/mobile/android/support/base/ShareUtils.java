package org.fingerlinks.mobile.android.support.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by raphaelbussa on 28/06/16.
 */
public class ShareUtils {

    public static void shareImage(Context context, ImageView imageView, String description, String share) {
        Uri img = Utils.getBitmapUri(context, imageView);
        if (img != null) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, description);
            intent.putExtra(Intent.EXTRA_STREAM, img);
            intent.setType("image/*");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            context.startActivity(Intent.createChooser(intent, share));
        }
    }

    public static void shareText(Context context, String description, String share) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, Utils.fromHtml(description));
        context.startActivity(Intent.createChooser(intent, share));
    }

}
