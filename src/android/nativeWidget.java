package cordova.plugin.native.widget;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class nativeWidget extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("toast")) {
            String message = args.getString(0);
            this.toast(message, callbackContext);
            return true;
        }
        return false;
    }

    private void toast(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            Toast.makeText(cordova.getContext(), message, Toast.LENGTH_SHORT).show();
            callbackContext.success(message);
        } else {
            callbackContext.error("unexpected error");
        }
    }
}
