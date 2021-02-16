package setup;

import java.io.IOException;
import java.util.Properties;

public class GetProperties {

    public static Properties getProperties(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }

    public static Properties getTestProperties() throws IOException {
        String testProperties = "testValues.properties";
        return getProperties(testProperties);
    }
}
