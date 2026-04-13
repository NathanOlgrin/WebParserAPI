package ru.olgrin.model.embeddings;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "huggingface")
public class HuggingFaceProperties {

    private String token;
    private Rosberta rosberta;

    public static class Rosberta {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Rosberta getRosberta() {
        return rosberta;
    }

    public void setRosberta(Rosberta rosberta) {
        this.rosberta = rosberta;
    }
}
