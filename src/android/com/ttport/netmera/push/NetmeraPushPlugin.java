package com.ttport.netmera.push;
// The native Toast API
import android.util.Log;
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.netmera.Netmera;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import android.content.Context;

public class NetmeraPushPlugin extends CordovaPlugin {
    private Context getApplicationContext() {
        return this.cordova.getActivity().getApplicationContext();
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.e("init=>","Plugin inited");

        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Config>>() { }.getType();

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "netmera-config.json");
        List<Config> configs = gson.fromJson(jsonFileString, listUserType);

        Netmera.init(getApplicationContext(),configs.get(0).getSenderId(), configs.get(0).getSdkKey());
        Netmera.setBaseUrl(configs.get(0).getUrl());
        Netmera.logging(true);
    }

    public class PushMessaging extends FirebaseMessagingService {

        @Override
        public void onMessageReceived(RemoteMessage p0) {
            super.onMessageReceived(p0);

            Netmera.onNetmeraPushMessageReceived(p0);
        }


        @Override
        public void onNewToken(String token) {
            super.onNewToken(token);

            Netmera.onNetmeraNewToken(token);
        }
    }

    public static class Utils {

        public static String getJsonFromAssets(Context context, String fileName) {
            String jsonString;
            try {
                InputStream is = context.getAssets().open(fileName);

                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();

                jsonString = new String(buffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            return jsonString;
        }
    }

    public class Config {
        String senderId;
        String  url;
        String sdkKey;

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String name) {
            this.senderId = senderId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSdkKey() {
            return sdkKey;
        }

        public void setSdkKey(String sdkKey) {
            this.sdkKey = sdkKey;
        }


        @Override
        public String toString() {
            return "Config{" +
                    "senderid='" + senderId + '\'' +
                    ", url=" + url +
                    ", sdkKey=" + sdkKey +
                    '}';
        }
    }
}