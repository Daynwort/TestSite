package infrastructure;

public class TestServer {
    public String getUrl(){
        String env = ConfigurationManager.getInstance().getTestEnvironment();
        switch (env) {
            case "prod_env" : return  "https:\\prod.example.com.ua";

            case "qa_env" : return "http://rgtestsite.fast-page.org/wordpress/";

            case "some_env" : return "https:\\some.url";
            default:return "";
        }
    }
}
