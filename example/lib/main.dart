import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter_walle/flutter_walle.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _channel = 'Unknown';

  @override
  void initState() {
    super.initState();
    initChannelState();
  }

  Future<void> initChannelState() async {
    String channel;
    try {
      channel = await FlutterWalle.channel;
    } catch (e) {
      print(e.toString());
    }

    if (!mounted) return;

    setState(() {
      _channel = channel;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_channel\n'),
        ),
      ),
    );
  }
}
