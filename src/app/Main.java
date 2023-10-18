package app;

import java.io.IOException;
import okhttp3.*;

import org.json.JSONException;

public class Main {

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&number=%s", System.getenv("API_KEY"), "lobster", "1"))
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }

}