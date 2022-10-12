package dev.com.service;


import dev.com.mapper.TaskMapper;
import dev.com.pojo.Task;
import dev.com.pojo.entry.TaskEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskMapper taskMapper;

    public  List<Task> queryTasks(){
        return taskMapper.queryAll();
    }

    @Transactional
    public void addTask(Task task){

        taskMapper.addTask(task);
        System.out.println(1/0);
    }

    public List<TaskEntry> queryList(){
        return taskMapper.queryList();
    }
}
