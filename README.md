# flutter_walle

Get channel information (by meituan walle) from within the Flutter application.

# Usage

Example:

```dart
import 'package:flutter_walle/flutter_walle.dart';

String channel = 'Unknown';
try {
    channel = await FlutterWalle.channel;
} catch (e) {
    print(e.toString());
}
```
