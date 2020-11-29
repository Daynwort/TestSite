package infrastructure;

import infrastructure.wdm.BrowserType;
import infrastructure.wdm.RunOn;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance(){
        if (instance == null){
            instance = new ConfigurationManager();
        }
        return instance;
    }
    public static String getEnvironmentVariableOrDefault(String envVar, String defaultValue){
        String currentVarValue = System.getenv(envVar);
        return currentVarValue == null || currentVarValue.isEmpty() ?
                defaultValue : currentVarValue;
    }
    public BrowserType getTestBrowser(){
        return BrowserType.valueOf(getEnvironmentVariableOrDefault("browser","chrome").toUpperCase());
    }

    public String getTestEnvironment(){
        return getEnvironmentVariableOrDefault("testEnv", "qa_env");

    }
    public String getCurrentEnvironment(){
        return getEnvironmentVariableOrDefault("runEnv","local");
    }
    public RunOn getRunOn(){
        return RunOn.valueOf(getEnvironmentVariableOrDefault("runEnv","local").toUpperCase());
    }

    public String getRemoteHubUrl() {
        return  getEnvironmentVariableOrDefault("huburl","http://huburl.test.site");
    }

    public String getRemoteServerName() {
        return  getEnvironmentVariableOrDefault("server","192.168.1.1");
    }

    public String getUserName() {
        return  getEnvironmentVariableOrDefault("user","admin");
    }

    public String getUserPassword() {
        return  getEnvironmentVariableOrDefault("password","admin");
    }
}
