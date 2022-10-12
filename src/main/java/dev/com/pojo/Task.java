package dev.com.pojo;


public class Task {


    private Integer id;
    private String taskId;
    private String taskName;

    public Task() {
    }

    public Task(Integer id, String taskId, String taskName) {
        this.id = id;
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
