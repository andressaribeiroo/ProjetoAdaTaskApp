package ada.controller;

import ada.domain.WorkTask;
import ada.service.TaskService;
import ada.view.WorkView;

import java.util.List;
import java.util.Scanner;

public class WorkController {
    private TaskService<WorkTask> taskService;
    private WorkView workView;
    private boolean isRunning;

    public WorkController(TaskService<WorkTask> taskService, WorkView workView) {
        this.taskService = taskService;
        this.workView = workView;
        this.isRunning = true;
    }

    public void run() {
        while (isRunning) {
            workView.displayMenu();
            int option = workView.getUserChoice();
            executeOption(option);
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case 1:
                WorkTask<String> task = workView.createTask();
                taskService.addTask(task);
                workView.displayMessage("Tarefa de trabalho criada com sucesso.");
                break;
            case 2:
                updateTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                listTasks();
                break;
            case 5:
                isRunning = false;
                break;
            case 6:
                exitProgram();
                break;
            default:
                workView.displayMessage("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

    private void updateTask() {
        Long id = workView.getTaskId();
        WorkTask<String> task = taskService.getTaskById(id);
        if (task != null) {
            workView.editTask(task);
            taskService.updateTask(task);
            workView.displayMessage("Tarefa de trabalho atualizada com sucesso.");
        } else {
            workView.displayMessage("Tarefa de trabalho não encontrada.");
        }
    }

    private void deleteTask() {
        Long id = workView.getTaskId();
        WorkTask<String> task = taskService.getTaskById(id);
        if (task != null) {
            taskService.removeTask(task);
            workView.displayMessage("Tarefa de trabalho excluída com sucesso.");
        } else {
            workView.displayMessage("Tarefa de trabalho não encontrada.");
        }
    }

    private void listTasks() {
        List<WorkTask> tasks = taskService.getAllTasks();
        workView.displayTasks(tasks);
    }

    private void exitProgram() {
        workView.displayMessage("Encerrando o programa.");
        System.exit(0);
    }
}
