package mx.uv.fiee.paradigmas.httpclient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class EntryPoint {
    private static final String Base_Url = "https://da8d8d77ac364e0c954afc662509c9dd.api.mockbin.io/";

    static void main() {
        var window = new Window();

        window.onClick (data -> {
            System.out.println("Datos enviados: " + data);

            try {
                var encoded = encodeValue(data);
                var response = HttpHelper.request(Base_Url, encoded);
                return Optional.of(response);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                return Optional.empty();
            }
        });

    }

    private static String encodeValue(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

}
