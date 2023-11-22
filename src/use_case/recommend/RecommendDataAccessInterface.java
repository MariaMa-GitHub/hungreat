package use_case.recommend;

import entity.Recipe;
import entity.RecommendFilter;

import java.util.ArrayList;

public interface RecommendDataAccessInterface {
    ArrayList<Recipe> recommend(RecommendFilter recommendFilter);
}
