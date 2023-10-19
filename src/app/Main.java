package app;

import view.HomeView;

import java.awt.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        JPanel views = new JPanel(layout);
        application.add(views);

        HomeView homeView = new HomeView();
        views.add(homeView);


        application.pack();

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);




//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&number=%s", System.getenv("API_KEY"), "lobster", "1"))
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
//        }
//        catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }

    }

}