import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class Main {

    public final static String URL_NASA =
            "https://api.nasa.gov/planetary/apod?api_key=N1ZfbOFcknazAS6goOSg1JmZt9nUVd8SOpYoBMEz";

    public static void get(CloseableHttpClient httpClient) {
        try {
            HttpGet request = new HttpGet(URL_NASA);
            CloseableHttpResponse response = httpClient.execute(request);
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(response.getEntity().getContent(), new TypeReference<User>() {
            });
            HttpGet requestData = new HttpGet(user.getUrl());
            CloseableHttpResponse responseData = httpClient.execute(requestData);
            FileOutputStream out = new FileOutputStream("GenesisImpact_nasa_960.jpg");
            BufferedInputStream in = new BufferedInputStream(responseData.getEntity().getContent());
            byte[] bytes = in.readAllBytes();
            out.write(bytes);
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        get(httpClient);
    }
}
