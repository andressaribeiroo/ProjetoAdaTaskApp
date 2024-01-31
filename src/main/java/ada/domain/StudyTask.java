package ada.domain;

public class StudyTask<T> extends BaseTask<T> {
    private String course;

    public StudyTask(String title, String description, String deadline, String course) {
        super(title, description, deadline);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return  "id: " + getId() +
                "\ntitulo: " + getTitle() +
                "\ndescrição: " + getDescription() +
                "\nPrazo da tarefa: " + getDeadline() +
                "\ncourse: " + getCourse();

    }

}
