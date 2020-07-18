package io.github.zileyuan.flutter_walle;

import androidx.annotation.NonNull;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import com.meituan.android.walle.WalleChannelReader;
import android.content.Context;
import android.text.TextUtils;

/** FlutterWallePlugin */
public class FlutterWallePlugin implements FlutterPlugin, MethodCallHandler {

  private static Context context;
  public static MethodChannel methodChannel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    context = flutterPluginBinding.getApplicationContext();
    methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutter_walle");
    methodChannel.setMethodCallHandler(this);
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    methodChannel.setMethodCallHandler(null);
  }

  public static void registerWith(Registrar registrar) {
    context = registrar.context();
    methodChannel = new MethodChannel(registrar.messenger(), "flutter_walle");
    methodChannel.setMethodCallHandler(new FlutterWallePlugin());
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
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
}
