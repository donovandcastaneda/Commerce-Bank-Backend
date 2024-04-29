package net.commercebank.cb;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JunitTests {

    @Test
    public void testPostRequest() throws IOException {
        // OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // JSON payload
        String jsonPayload = "{\"first_name\":\"Iftekhar\",\"last_name\":\"Hossain\",\"username\":\"helloiftekhar\",\"password\":\"12340\",\"role\":\"USER\"}";

        // Request
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(jsonPayload, mediaType);

        // Header and others
        Request request = new Request.Builder()
                .url("http://localhost:8080/register")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic cm9vdDpaSXNIV3BmWnFVaXdseFpEbFd1dU1MeGJ6YmZXTGZ2bQ==")
                .build();

        // Execute
        try (Response response = client.newCall(request).execute()) {
            assertEquals(401, response.code(), "Expected status code 200");

            // Response
            String responseBody = response.body().string();
            System.out.println("Response body: " + responseBody);
        }
    }
}