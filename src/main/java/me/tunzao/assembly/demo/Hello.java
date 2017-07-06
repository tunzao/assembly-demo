package me.tunzao.assembly.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by likuan on 2017-07-06.
 *
 * @author likuan
 */
public class Hello {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

    private static final String CONF_FILE = "conf.properties";

    public static void main(String[] args) throws InterruptedException, IOException {
        loadResources();
        if (args.length == 0) {
            LOGGER.info("Hello guest");
        } else {
            LOGGER.info("hello {}", args[0]);
        }
        TimeUnit.SECONDS.sleep(10);
        LOGGER.info("Bye~");

    }

    private static Properties loadResources() throws IOException {
        Properties properties = new Properties();
        LOGGER.info("loading properties");
        properties.load(ClassLoader.getSystemResourceAsStream(CONF_FILE));
        Set<String> names = properties.stringPropertyNames();
        LOGGER.info("properties loaded:");
        for (String name : names) {
            LOGGER.info("{}={}", name, properties.getProperty(name));
        }
        return properties;
    }

}
