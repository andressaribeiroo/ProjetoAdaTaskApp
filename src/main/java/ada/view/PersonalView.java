package ada.view;

import ada.domain.PersonalTask;

import java.util.List;
import java.util.Scanner;

public class PersonalView {
    private Scanner scanner;

    public PersonalView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Criar tarefa");
        System.out.println("2. Editar tarefa");
        System.out.println("3. Excluir tarefa");
        System.out.println("4. Listar tarefas");
        System.out.println("5. Voltar para o menu principal");
        System.out.println("6. Encerrar programa");
    }

    public int getUserChoice() {
        System.out.print("Digite o número da opção desejada: ");
        return scanner.nextInt();
    }

    public PersonalTask<String> createTask() {
        System.out.println("Criar Tarefa:");
        System.out.println("Título da tarefa: ");
        String title = scanner.nextLine();

        System.out.println("Descrição da tarefa: ");
        String description = scanner.nextLine();

        System.out.println("Prazo final da tarefa: ");
        String deadline = scanner.nextLine();

        System.out.println("Tipo da tarefa: ");
        String type = scanner.nextLine();

        return new PersonalTask<>(title, description, deadline, type);
    }

    public void editTask(PersonalTask<String> task) {
        System.out.println("Editar Tarefa (ID: " + task.getId() + "):");
        System.out.println("Novo título da tarefa: ");
        task.setTitle(scanner.nextLine());

        System.out.println("Nova descrição da tarefa: ");
        task.setDescription(scanner.nextLine());

        System.out.print("Nova data final da tarefa: ");
        task.setDeadline(scanner.nextLine());

        System.out.print("Novo tipo da tarefa: ");
        task.setType(scanner.nextLine());
    }

    public Long getTaskId() {
        System.out.print("Digite o ID da tarefa: ");
        return scanner.nextLong();
    }

    public void displayTasks(List<PersonalTask<String>> tasks) {
        System.out.println("Lista de Tarefas Pessoais:");
        for (PersonalTask<String> task : tasks) {
            System.out.println(task);
            System.out.println("_________________________");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
