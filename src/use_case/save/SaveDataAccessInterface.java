package use_case.save;

import entity.Recipe;

import java.io.IOException;
import java.util.ArrayList;

public interface SaveDataAccessInterface {
    void save(Recipe recipe) throws IOException, ClassNotFoundException;

    void read();
}
