import ada.controller.PersonalController;
import ada.controller.StudyController;
import ada.controller.WorkController;
import ada.domain.BaseTask;
import ada.domain.PersonalTask;
import ada.domain.StudyTask;
import ada.domain.WorkTask;
import ada.repository.TaskRepository;
import ada.service.TaskService;
import ada.view.PersonalView;
import ada.view.StudyView;
import ada.view.WorkView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Escolha o tipo de tarefa: " +
                    "%n1. Tarefas Pessoais; " +
                    "%n2. Tarefas de Estudo; " +
                    "%n3. Tarefas de Trabalho;" +
                    "%nInsira o número correspondente à opção escolhida:%n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runPersonalTasks();
                    break;
                case 2:
                    runStudyTasks();
                    break;
                case 3:
                    runWorkTasks();
                    break;
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }

    private static void runPersonalTasks() {
        PersonalView personalView = new PersonalView();
        TaskRepository<PersonalTask<String>> personalRepository = new TaskRepository<>();
        TaskService<PersonalTask<String>> personalService = new TaskService<>(personalRepository);
        PersonalController personalController = new PersonalController(personalService, personalView);
        personalController.run();
    }

    private static void runStudyTasks() {
        StudyView studyView = new StudyView();
        TaskRepository<StudyTask> studyRepository = new TaskRepository<>();
        TaskService<StudyTask> studyService = new TaskService<>(studyRepository);
        StudyController studyController = new StudyController(studyService, studyView);
        studyController.run();
    }

    private static void runWorkTasks() {
        WorkView workView = new WorkView();
        TaskRepository<WorkTask> workRepository = new TaskRepository<>();
        TaskService<WorkTask> workService = new TaskService<>(workRepository);
        WorkController workController = new WorkController(workService, workView);
        workController.run();
    }
}
