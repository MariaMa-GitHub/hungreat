package use_case.delete;

import entity.Recipe;

import java.io.IOException;
import java.util.ArrayList;

public interface DeleteDataAccessInterface {

    void delete(Recipe recipe) throws IOException, ClassNotFoundException;

    void read();
}
