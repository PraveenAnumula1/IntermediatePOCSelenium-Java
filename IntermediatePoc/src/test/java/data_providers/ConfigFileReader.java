package data_providers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        try {
        	 FileInputStream input = new FileInputStream(System.getProperty("user.dir")+("/src/Configs/Configuration.properties"));
        	// ("/IntermediatePoc/src/Configs/Configuration.properties");
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find Configuration.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Configuration.properties file could not be loaded.");
        }
    }

    public String getReportConfigPath() {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath != null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
