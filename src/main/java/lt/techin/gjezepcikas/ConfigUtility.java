package lt.techin.gjezepcikas;

import java.io.*;
import java.util.Properties;

public class ConfigUtility {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
