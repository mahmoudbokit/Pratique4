package ru.mirea.mahmoud.b.i.loadermanger;


import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MyLoader extends AsyncTaskLoader<String> {

    private String firstName;
    public static final String ARG_WORD = "word";
    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null){
            firstName = args.getString(ARG_WORD);
        }

    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        SystemClock.sleep(5000);
        return firstName;
    }
}
