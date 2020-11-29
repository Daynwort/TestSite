package infrastructure.utils;



import java.util.HashMap;
import java.util.Map;

public class UrlBuilder {
    public String protocol = "";
    public String domain = "";
    public String port = "";
    public String path = "";
    public Map<String, String> params = new HashMap<>();

    public static class Builder {
        private UrlBuilder url;

        public Builder() {
            url = new UrlBuilder();
        }

        public Builder withProtocol(String protocol) {
            if (!protocol.endsWith("//")) {
                url.protocol = protocol + "//";
            } else {
                url.protocol = protocol;
            }
            return this;
        }

        public Builder withDomain(String domain) {
            if (!domain.endsWith(".")) {
                url.domain = url.domain + domain + ".";
            } else {
                url.domain = url.domain + domain;
            }
            return this;
        }

        public Builder withPort(String port) {
            url.port = ":" + port;
            return this;
        }

        public Builder withPath(String path) {
            if (!path.startsWith("/")) {
                url.path = url.path + "/" + path;
            } else {
                url.path = url.path + path;
            }
            return this;
        }

        public Builder withParams(String params) {
            url.params.put(params, "");
            return this;
        }

        public Builder withParams(String key, String value) {
            url.params.put(key, value);
            return this;
        }
        public Builder withParams(HashMap<String, String> map){
            url.params.putAll(map);
            return this;
        }

        public String convertMapToString(Map<String,String>map){
            StringBuilder result=new StringBuilder();
            for(Map.Entry<String,String> entry : map.entrySet()) {
                result.append(entry.getKey());
                if (!entry.getValue().equals("")){
                    result.append("=");
                    result.append(entry.getValue());
                }
                result.append("&");
            }return result.substring(0,result.toString().length()-1);
        }
        public String build () {
            url.domain = url.domain.endsWith(".") ? url.domain.substring(0, url.domain.length() - 1) : url.domain;
            return new StringBuilder()
                    .append(url.protocol)
                    .append(url.domain)
                    .append(url.port)
                    .append(url.path)
                    .append("?"+ convertMapToString(url.params)).toString();

        }
    }
}

