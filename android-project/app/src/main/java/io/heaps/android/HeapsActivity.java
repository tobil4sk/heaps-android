package io.heaps.android;

import org.libsdl.app.SDLActivity;
import android.content.Context;
import android.os.Bundle;

public class HeapsActivity extends SDLActivity {
    private static HeapsActivity instance;

    public static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle state) {
        instance = this;
        super.onCreate(state);
    }

    @Override
    protected String[] getLibraries() {
        return new String[]{
            "openal",
            "SDL2",
            "heapsapp"
        };
    }

    @Override
    protected String getMainFunction() {
        return "main";
    }
}
