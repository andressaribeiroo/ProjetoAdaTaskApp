package ada.service;

import ada.domain.BaseTask;
import ada.repository.TaskRepository;

import java.util.List;

public class TaskService<T extends BaseTask> {
    private TaskRepository<T> taskRepository;

    public TaskService(TaskRepository<T> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(T task) {
        taskRepository.add(task);
    }

    public void removeTask(T task) {
        taskRepository.remove(task);
    }

    public void updateTask(T task) {
        taskRepository.update(task);
    }

    public List<T> getAllTasks() {
        return taskRepository.findAll();
    }

    public T getTaskById(Long id) {
        return taskRepository.findById(id);
    }
}
