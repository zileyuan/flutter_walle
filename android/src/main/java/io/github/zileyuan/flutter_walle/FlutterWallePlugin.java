package io.github.zileyuan.flutter_walle;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import com.meituan.android.walle.WalleChannelReader;
import android.content.Context;
import android.text.TextUtils;

/** FlutterWallePlugin */
public class FlutterWallePlugin implements MethodCallHandler {

  private Context context;

  private FlutterWallePlugin(Context ctx) {
    context = ctx;
  }
  
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_walle");
    channel.setMethodCallHandler(new FlutterWallePlugin(registrar.context()));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getChannel")) {
      String channel = WalleChannelReader.getChannel(context);
      if (TextUtils.isEmpty(channel)) {
        channel = "NoChannel";
      }
      result.success(channel);
    } else {
      result.notImplemented();
    }
  }

  public static String getChannel(Context ctx) {
    String channel = WalleChannelReader.getChannel(ctx);
    if (channel == null || channel.length() == 0) {
        channel = "NoChannel";
    }
    return channel;
  }
}
