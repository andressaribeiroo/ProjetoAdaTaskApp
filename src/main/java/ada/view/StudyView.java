package ada.view;

import ada.domain.StudyTask;

import java.util.List;
import java.util.Scanner;

public class StudyView {
    private Scanner scanner;

    public StudyView() {
        this.scanner = new Scanner(System.in);
    }

    public StudyTask<String> createTask() {
        System.out.println("Criar Tarefa de Estudo:");

        System.out.print("Título da tarefa: ");
        scanner.nextLine();
        String title = scanner.nextLine();

        System.out.print("Descrição da tarefa: ");
        String description = scanner.nextLine();

        System.out.print("Prazo final da tarefa: ");
        String deadline = scanner.nextLine();

        System.out.print("Curso relacionado à tarefa: ");
        String course = scanner.nextLine();

        return new StudyTask<>(title, description, deadline, course);
    }

    public void editTask(StudyTask<String> task) {
        System.out.println("Editar Tarefa de Estudo (ID: " + task.getId() + "):");
        System.out.print("Novo título da tarefa: ");
        scanner.nextLine();
        task.setTitle(scanner.nextLine());

        System.out.print("Nova descrição da tarefa: ");
        task.setDescription(scanner.nextLine());

        System.out.print("Nova data final da tarefa: ");
        task.setDeadline(scanner.nextLine());

        System.out.print("Novo curso relacionado à tarefa: ");
        task.setCourse(scanner.nextLine());
    }

    public Long getTaskId() {
        System.out.print("Digite o ID da tarefa: ");
        return scanner.nextLong();
    }

    public void displayTasks(List<StudyTask> tasks) {
        System.out.println("Lista de Tarefas de Estudo:");
        for (StudyTask<String> task : tasks) {
            System.out.println(task);
            System.out.println("_________________________");
        }
    }

    public void displayMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Criar tarefa de estudo");
        System.out.println("2. Editar tarefa de estudo");
        System.out.println("3. Excluir tarefa de estudo");
        System.out.println("4. Listar tarefas de estudo");
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
