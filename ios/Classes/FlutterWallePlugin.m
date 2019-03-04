#import "FlutterWallePlugin.h"

@implementation FlutterWallePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"flutter_walle"
            binaryMessenger:[registrar messenger]];
  FlutterWallePlugin* instance = [[FlutterWallePlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"getChannel" isEqualToString:call.method]) {
    result(@"IOS");
  } else {
    result(FlutterMethodNotImplemented);
  }
}

@end
