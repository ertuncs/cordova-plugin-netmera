package com.netmera;

import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPreferences;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.app.Application;
import com.google.gson.reflect.TypeToken;
import com.netmera.cordova.android.plugin.Config;
import com.netmera.cordova.android.plugin.Utils;
import com.netmera.Netmera;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;


public class NGActivity extends Application {
    private CordovaPlugin cordova;

    @Override
    public void onCreate() {
        super.onCreate();
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Config>>() { }.getType();

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "netmera-config.json");
        List<Config> configs = gson.fromJson(jsonFileString, listUserType);

        Netmera.init(this,configs.get(0).getSenderId(), configs.get(0).getSdkKey());
        Netmera.setBaseUrl(configs.get(0).getUrl());
        Netmera.logging(true);

    }
}
