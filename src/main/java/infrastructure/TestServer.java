package infrastructure;

public class TestServer {
    public String getUrl(){
        String env = ConfigurationManager.getInstance().getTestEnvironment();
        switch (env) {
            case "prod_env" : return  "https:\\prod.example.com.ua";

            case "qa_env" : return "https:\\qa.example.com.ua";

            case "some_env" : return "https:\\some.url";
            default:return "";
        }
    }
}
