# Meal Planner Project

## Problem Domain
Our team is focusing on the culinary domain. We will use an API that deals with recipes and meal planning in order to create a program that allow people to manage their diet.

## Application Description
Our project involves developing a desktop application for meal planning. We aim to create a Meal Planner application allows users to create, retrieve, and save recipes. The application will provide features such as recipe recommendations, recipe filtering, recipe analysis, and recipe sharing.

The app will include the following functionalities:

1. Recipe
    1. Create own recipe
    2. Search existing recipe
    3. Save recipe
    3. Customize saved recipe
    4. Analyse the nutrition obtained
2. Community
    1. Allowing recipe sharing
3. Meal Planner
    1. Suggest recipe based on:
        1. Calories
        2. Proteins
        3. Vegetarian
        4. Allergies
        5. Ingredients
        6. Etc.

## API Documentation
We plan to make use of the Spoonacular API to implement our app's main features. It provides access to a large database of recipes, nutritional information, and ingredient data.

**Spoonacular API Documentation:** [Link to Spoonacular API Docs](https://spoonacular.com/food-api/docs)


## API Usage Screenshot
Below is a screenshot of using the Spoonacular API with Hoppscotch:

![Waiting for the picture](./pic/Week3.jpg)

## Java Code Example
```
import java.io.IOException;
import okhttp3.*;

import org.json.JSONException;

public class Main {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&number=%s", API_TOKEN, "lobster", "1"))
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

```

