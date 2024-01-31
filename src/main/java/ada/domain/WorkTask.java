package ada.domain;

public class WorkTask<T> extends BaseTask<T> {
    private String taskType;
    private String teamMember;

    public WorkTask(String title, String description, String deadline, String taskType, String teamMember) {
        super(title, description, deadline);
        this.taskType = taskType;
        this.teamMember = teamMember;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    @Override
    public String toString() {
        return  "id: " + getId() +
                "\ntitulo: " + getTitle() +
                "\ndescrição: " + getDescription() +
                "\nPrazo da tarefa: " + getDeadline() +
                "\ntipo: " + taskType +
                "\nMembro responsavel: " + teamMember;
    }

}
