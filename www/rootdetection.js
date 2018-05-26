var exec = require('cordova/exec');

exports.isDeviceRooted = function(success, error) {
    exec(success, error, "RD", "is_dr", ["test-keys","/sbin/su","/system/bin/su","/system/xbin/su","/data/local/xbin/su","/data/local/bin/su","/system/sd/xbin/su","/system/bin/failsafe/su","/data/local/su"]);
};
