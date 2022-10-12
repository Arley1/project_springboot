package dev.com.mapper;

import dev.com.pojo.Task;
import dev.com.pojo.entry.TaskEntry;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {
    public List<Task> queryAll();
    public void addTask(Task task);
    public List<TaskEntry> queryList();
}
