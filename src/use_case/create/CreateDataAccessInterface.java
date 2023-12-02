package use_case.create;

import entity.Recipe;

import java.io.IOException;

public interface CreateDataAccessInterface {
    void save(Recipe recipe) throws IOException, ClassNotFoundException;    //TODO: update after exception in DAO has been handled
}