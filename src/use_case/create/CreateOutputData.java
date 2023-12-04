package use_case.create;
public class CreateOutputData {

    private final Integer id;
    private final String title;

    public CreateOutputData(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}