package mx.uv.fiee.paradigmas.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpHelper {

    public static HttpResponse<String> request (String url, String body)
    {
        try (var httpClient = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build()
            )
        {
            var request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .uri(URI.create(url))
                    .setHeader("User-Agent", "Java 21 HttpClient Bot")
                    .build();

            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .join();

        }
    }

}
