package me.cosmicdev.aimoderator.model;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Model {
    public static int callModel(String text, double sensitivity) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();

            String json = "{\"text\":\"" + text + "\", \"sensitivity\":" + sensitivity + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://etuu.pythonanywhere.com/profanity"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response to get the 'is_profane' value
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getInt("is_profane");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
