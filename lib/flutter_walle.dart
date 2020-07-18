import 'dart:async';

import 'package:flutter/services.dart';

class FlutterWalle {
  /// Communication MethodChannel
  static const MethodChannel _channel = const MethodChannel('flutter_walle');

  /// Get a channel from current package
  static Future<String> get channel async {
    final String ch = await _channel.invokeMethod('getChannel');
    return ch;
  }
}
