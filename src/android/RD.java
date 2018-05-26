package cl.kunder.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.lang.Exception;
import java.io.File;

public class RD extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("is_dr")) {
            try {
                String[] fps = new String[args.length() - 1];
                for(int i = 0; i < args.length() - 1; i++) {
                    fps[i] = args.getString(i);
                }
                callbackContext.success(is_dr(fps, args.getString(0)) ? 1 : 0);
                return true;
            }
            catch(Exception e) {
                callbackContext.error("N/A");
                return false;
            }
        }
        return false;
    }

    private boolean is_dr(String[] fps, String bt) {
        return ch_fps(fps) || ch_bts(bt);
    }

    private boolean ch_bts(String bt) {
        String bts = android.os.Build.TAGS;
        return bts != null && bts.contains(bt);
    }

    private boolean ch_fps(String[] fps) {
        for (int i = 0; i < fps.length; i++) {
            if (ex_fp(fps[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean ex_fp(String fp) {
        return new File(fp).exists();
    }
}