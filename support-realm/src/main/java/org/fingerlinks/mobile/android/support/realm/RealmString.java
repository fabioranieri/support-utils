package org.fingerlinks.mobile.android.support.realm;

import io.realm.RealmObject;

/**
 * Created by Raphael on 18/12/2015.
 */
public class RealmString extends RealmObject {

    private String val;

    public RealmString() {
    }

    public RealmString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
