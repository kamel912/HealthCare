package com.teamvii.healthcare.data;

import android.content.Context;

/**
 * Created by ibrahim on 28/12/17.
 */

public class SetLang {
    String lang;
    Context context;

    public SetLang(Context context) {
        this.context = context;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
