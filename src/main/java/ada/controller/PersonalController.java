package ada.controller;

import ada.domain.PersonalTask;
import ada.service.TaskService;
import ada.view.PersonalView;

import java.util.List;

public class PersonalController {
    private TaskService<PersonalTask<String>> taskService;
    private PersonalView personalView;

    public PersonalController(TaskService<PersonalTask<String>> taskService, PersonalView personalView) {
        this.taskService = taskService;
        this.personalView = personalView;
    }

    public void run() {
        while (true) {
            personalView.displayMenu();
            int option = personalView.getUserChoice();
            executeOption(option);
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case 1:
                createTask();
                break;
            case 2:
                editTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                listTasks();
                break;
            case 5:
                return;
            case 6:
                personalView.displayMessage("Encerrando o programa!");
                System.exit(0);
            default:
                personalView.displayMessage("Opção inválida!");
        }
    }

    private void createTask() {
        PersonalTask task = personalView.createTask();
        taskService.addTask(task);
        personalView.displayMessage("Tarefa criada com sucesso!");
    }

    private void editTask() {
        Long id = personalView.getTaskId();
        PersonalTask task = taskService.getTaskById(id);

        if (task == null) {
            personalView.displayMessage("Tarefa não encontrada!");
        } else {
            personalView.editTask(task);
            taskService.updateTask(task);
            personalView.displayMessage("Tarefa editada com sucesso!");
        }
    }

    private void deleteTask() {
        Long id = personalView.getTaskId();
        PersonalTask task = taskService.getTaskById(id);

        if (task == null) {
            personalView.displayMessage("Tarefa não encontrada!");
        } else {
            taskService.removeTask(task);
            personalView.displayMessage("Tarefa excluída com sucesso!");
        }
    }

    private void listTasks() {
        List<PersonalTask<String>> tasks = taskService.getAllTasks();
        personalView.displayTasks(tasks);
    }
}
