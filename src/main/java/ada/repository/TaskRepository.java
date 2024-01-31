package ada.repository;

import ada.domain.BaseTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository<T extends BaseTask> {
    private Map<Long, T> taskMap;
    private long nextId;

    public TaskRepository() {
        taskMap = new HashMap<>();
        nextId = 1;
    }

    public void add(T task) {
        task.setId(nextId++);
        taskMap.put(task.getId(), task);
    }

    public void remove(T task) {
        taskMap.remove(task.getId());
    }

    public void update(T task) {
        taskMap.put(task.getId(), task);
    }

    public List<T> findAll() {
        return new ArrayList<>(taskMap.values());
    }

    public T findById(Long id) {
        return taskMap.get(id);
    }
}
