package yy.excelutil.common;

import java.util.ResourceBundle;

public class ResourceBundleUtil {
    private ResourceBundle resourceBundle;
    private static ResourceBundleUtil resourceBundleUtil;

    private ResourceBundleUtil() {
        resourceBundle = ResourceBundle.getBundle(Constants.CONFIG_PATH);
    }

    public static ResourceBundleUtil getInstance() {
        if (resourceBundleUtil == null) {
            resourceBundleUtil = new ResourceBundleUtil();
        }
        return resourceBundleUtil;
    }

    public String getStringUTF8(String key) throws Exception {
        String value = resourceBundle.getString(key);
        return value;// new String(value.getBytes(""),
                     // Constants.ENCODE_UTF8).toString();
    }

    public String getString(String key) throws Exception {
        String value = resourceBundle.getString(key);
        return value;
    }

}
