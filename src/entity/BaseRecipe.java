package entity;

import java.util.Collection;
public class BaseRecipe {
    private final int ID;
    private final String title;

    public BaseRecipe(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

}
