import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_walle/flutter_walle.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_walle');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getChannel', () async {
    expect(await FlutterWalle.channel, 'NoChannel');
  });
}
