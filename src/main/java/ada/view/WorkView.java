package ada.view;

import ada.domain.WorkTask;

import java.util.List;
import java.util.Scanner;

public class WorkView {
    private Scanner scanner;

    public WorkView() {
        this.scanner = new Scanner(System.in);
    }

    public WorkTask<String> createTask() {
        System.out.println("Criar Tarefa de Trabalho:");
        System.out.println("Título da tarefa: ");
        String title = scanner.nextLine();

        System.out.println("Descrição da tarefa: ");
        String description = scanner.nextLine();

        System.out.print("Prazo final da tarefa: ");
        String deadline = scanner.nextLine();

        System.out.print("Tipo de tarefa: ");
        String taskType = scanner.nextLine();

        System.out.print("Membro da equipe responsável: ");
        String teamMember = scanner.nextLine();

        return new WorkTask<>(title, description, deadline, taskType, teamMember);
    }

    public void editTask(WorkTask<String> task) {
        System.out.println("Editar Tarefa de Trabalho (ID: " + task.getId() + "):");
        System.out.println("Novo título da tarefa: ");
        task.setTitle(scanner.nextLine());

        System.out.println("Nova descrição da tarefa: ");
        task.setDescription(scanner.nextLine());

        System.out.print("Nova data final da tarefa: ");
        task.setDeadline(scanner.nextLine());

        System.out.print("Novo tipo de tarefa: ");
        task.setTaskType(scanner.nextLine());

        System.out.print("Novo membro da equipe responsável: ");
        task.setTeamMember(scanner.nextLine());
    }

    public Long getTaskId() {
        System.out.print("Digite o ID da tarefa: ");
        return scanner.nextLong();
    }

    public void displayTasks(List<WorkTask> tasks) {
        System.out.println("Lista de Tarefas de Trabalho:");
        for (WorkTask<String> task : tasks) {
            System.out.println(task);
            System.out.println("_________________________");
        }
    }

    public void displayMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Criar tarefa de trabalho");
        System.out.println("2. Editar tarefa de trabalho");
        System.out.println("3. Excluir tarefa de trabalho");
        System.out.println("4. Listar tarefas de trabalho");
        System.out.println("5. Voltar para o menu principal");
        System.out.println("6. Encerrar programa");
    }

    public int getUserChoice() {
        System.out.print("Digite o número da opção desejada: ");
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
