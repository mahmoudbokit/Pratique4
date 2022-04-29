package ru.mirea.mahmoud.b.i.loadermanger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, View.OnClickListener {

    public final String TAG = this.getClass().getSimpleName();
    private int LoaderID = 1234;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button) findViewById(R.id.btnLoader);
        Bundle bundle = new Bundle();
        bundle.putString(MyLoader.ARG_WORD, "mirea");
        getSupportLoaderManager().initLoader(LoaderID, bundle, this);
        button.setOnClickListener(this);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle bundle) {
        if (id == LoaderID){
            Toast.makeText(this, "onCreateLoader "+ id, Toast.LENGTH_SHORT).show();
            return new MyLoader(this,bundle);
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        if (loader.getId() == LoaderID){
            Log.d(TAG, "onLoadFinished "+ s);
            Toast.makeText(this, "onLoadFinished: "+ s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnLoader:
                intent = new Intent("android.intent.action.MAIN");
                startActivity(intent);
                break;
        }

    }

    public void onClickService(View view) {
        startService(new Intent("android.intent.action.MyService")
                .putExtra("name", "value"));
    }
}