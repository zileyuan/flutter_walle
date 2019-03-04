import 'dart:async';

import 'package:flutter/services.dart';

class FlutterWalle {
  static const MethodChannel _channel =
      const MethodChannel('flutter_walle');

  static Future<String> get channel async {
    final String ch = await _channel.invokeMethod('getChannel');
    return ch;
  }
}
