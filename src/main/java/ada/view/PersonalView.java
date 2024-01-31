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
        System.out.printf("Escolha uma opção:%n" +
                "------------------------%n" +
                "1. Criar tarefa%n" +
                "2. Editar tarefa%n" +
                "3. Excluir tarefa%n" +
                "4. Listar tarefas%n" +
                "5. Voltar para o menu principal%n" +
                "6. Encerrar programa%n");
    }


    public int getUserChoice() {
        System.out.print("\nDigite o número da opção desejada:\n ");
        return scanner.nextInt();
    }

    public PersonalTask<String> createTask() {
        System.out.println("Criar Tarefa:");

        System.out.print("Título da tarefa: ");
        scanner.nextLine();
        String title = scanner.nextLine();

        System.out.print("Descrição da tarefa: ");
        String description = scanner.nextLine();

        System.out.print("Prazo final da tarefa: ");
        String deadline = scanner.nextLine();

        System.out.print("Tipo da tarefa: ");
        String type = scanner.nextLine();

        return new PersonalTask<>(title, description, deadline, type);
    }


    public void editTask(PersonalTask<String> task) {
        System.out.println("Editar Tarefa (ID: " + task.getId() + "):");
        System.out.println("Novo título da tarefa: ");
        scanner.nextLine();
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
