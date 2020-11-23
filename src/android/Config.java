package com.netmera;

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