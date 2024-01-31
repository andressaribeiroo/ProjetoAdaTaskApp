package ada.controller;

import ada.domain.StudyTask;
import ada.service.TaskService;
import ada.view.StudyView;

import java.util.List;

public class StudyController {
    private TaskService<StudyTask> taskService;
    private StudyView studyView;
    private boolean isRunning;

    public StudyController(TaskService<StudyTask> taskService, StudyView studyView) {
        this.taskService = taskService;
        this.studyView = studyView;
        this.isRunning = true;
    }

    public void run() {
        while (isRunning) {
            studyView.displayMenu();
            int option = studyView.getUserChoice();
            executeOption(option);
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case 1:
                StudyTask<String> task = studyView.createTask();
                taskService.addTask(task);
                studyView.displayMessage("Tarefa de estudo criada com sucesso.");
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
                studyView.displayMessage("Opção inválida. Por favor, tente novamente.");
                break;
        }
    }

    private void updateTask() {
        Long id = studyView.getTaskId();
        StudyTask<String> task = taskService.getTaskById(id);
        if (task != null) {
            studyView.editTask(task);
            taskService.updateTask(task);
            studyView.displayMessage("Tarefa de estudo atualizada com sucesso.");
        } else {
            studyView.displayMessage("Tarefa de estudo não encontrada.");
        }
    }

    private void deleteTask() {
        Long id = studyView.getTaskId();
        StudyTask<String> task = taskService.getTaskById(id);
        if (task != null) {
            taskService.removeTask(task);
            studyView.displayMessage("Tarefa de estudo excluída com sucesso.");
        } else {
            studyView.displayMessage("Tarefa de estudo não encontrada.");
        }
    }

    private void listTasks() {
        List<StudyTask> tasks = taskService.getAllTasks();
        studyView.displayTasks(tasks);
    }

    private void exitProgram() {
        studyView.displayMessage("Encerrando o programa.");
        System.exit(0);
    }
}
