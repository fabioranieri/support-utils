package org.fingerlinks.mobile.android.support.realm;

import io.realm.RealmObject;

/**
 * Created by Raphael on 18/12/2015.
 */
public class RealmInt extends RealmObject {

    private int val;

    public RealmInt() {
    }

    public RealmInt(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
