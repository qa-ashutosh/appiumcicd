package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps() throws IOException {
        InputStream inputStream = null;
        String propFileName = "config.properties";

        if(props.isEmpty()){
            try {
                utils.log().info("Loading config properties");
                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
                props.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties. ABORT!!!" + e);
                throw e;
            }
            finally {
                if (inputStream != null) inputStream.close();
            }
        }
        return props;
    }
}
