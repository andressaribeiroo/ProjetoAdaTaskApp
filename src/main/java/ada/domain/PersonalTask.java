package ada.domain;

public class PersonalTask<T> extends BaseTask<T> {
    private String type;

    public PersonalTask(String title, String description, String deadline, String type) {
        super(title, description, deadline);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "id: " + getId() +
                "\ntitle: '" + getTitle() + '\'' +
                "\ndescription: " + getDescription() + '\'' +
                "\ndeadline: " + getDeadline() + '\'' +
                "\ntype: '" + type;
    }

}