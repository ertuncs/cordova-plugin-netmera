# cordova-plugin-netmera
Cordova Netmera Push Notification Plugin

**[ Android ]**

For Android setup, firstly on IONIC;
```
ionic cordova platform add android
```
command must be run, after the command is run, add the netmera-config.json file under the ``` /app/src/assets```
 folder

The netmera-config.json file should contain an array as follows
```

[{
    "senderId": "401233687615",
    "url": "https://netmeratest.turktelekom.com.tr",
    "sdkKey": "4zGewE8snDaP_mfW4tWH9AWDxwecqGnvK6s_aL2btU"
}]
```
**senderId** is FCMSenderID generated from FCM<br/>
**sdkKey** is Netmera SDK Key over netmera platform<br/>
**url** is the Netmera Panel Access address.

**[ IOS ]**

For IOS Setup, firstly on IONIC;
```
ionic cordova platform add ios
```
command must be run, after the command is run, it is in the ```config.xml``` folder under the root directory of the application.
```
<platform name = "ios">
```
under tag
```
<config-file target = "* - Info.plist" parent = "NetmeraSDKKey">
    <string> 4zGewE8snDaP_mfW4tWH9AWDxwecqGnvK6s_aL2btU </string>
</config-file>
<config-file target = "* - Info.plist" parent = "NetmeraApiUrl">
    <string> https://netmeratest.turktelekom.com.tr </string>
</config-file>
```
These tags should be added,
<br/>
**NetmeraSDKKey** is the SDK Key taken over the Netmera Platform.<br/>
**NetmeraApiUrl** is the netmera platform access address

After these arrangements are made
```
ionic cordova plugin add https://github.com/ertuncs/cordova-plugin-netmera.git
```
You can install the plugin in your project with the command.
