package uk.co.whiteoctober.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
public class AppVersion extends CordovaPlugin {
	@Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		PackageManager packageManager = this.cordova.getActivity().getPackageManager();
		 ApplicationInfo ai;
	     CharSequence al;
		try {	
			if (action.equals("getVersionNumber")) {
				ai = packageManager.getApplicationInfo(this.cordova.getActivity().getPackageName(), 0);
            	al = packageManager.getApplicationLabel(ai);
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (String) al));
			return true;
			}
			return false;
		} catch (NameNotFoundException e) {
			callbackContext.success("N/A");
			return true;
		}
	}

}
