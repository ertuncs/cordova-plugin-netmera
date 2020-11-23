#import "NetmeraPlugin.h"
#import <Cordova/CDVPlugin.h>
#import <Netmera/Netmera.h>

@implementation NetmeraPlugin
- (void)pluginInitialize
{
    NSString *netmeraApiUrl = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"NetmeraApiUrl"];
    NSString *netmeraSdkKey = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"NetmeraSDKKey"];

  [Netmera start];
  [Netmera setBaseURL:netmeraApiUrl];
  [Netmera setAPIKey:netmeraSdkKey];
  [Netmera setLogLevel:(NetmeraLogLevelDebug)];

}
@end

