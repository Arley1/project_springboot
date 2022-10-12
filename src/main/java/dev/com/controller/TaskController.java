package dev.com.controller;

import dev.com.pojo.Task;
import dev.com.pojo.entry.TaskEntry;
import dev.com.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/task")
@Api(value = "Task Interface",tags = "Task Interface")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation("getTaskId")
    @ApiImplicitParam(name = "id",required = true)
    public String getTaskId(@PathVariable String id){
        return id;
    }

    @RequestMapping(value = "/taskList/{id}/list")
    @ResponseBody
    public List getTaskList(@PathVariable String id){
       List list  = new ArrayList();
       list.add(id);
       list.add("xxx1");
       return list;
    }

    @RequestMapping(value ="/addTask")
    @ResponseBody
    public Task addTask(Task task){
        return  task;
    }

    @ResponseBody
    @RequestMapping(value ="queryAll")
    public List<Task> queryAll(){
        return taskService.queryTasks();
    }

    @ResponseBody
    @RequestMapping(value ="addTasks")
    public String addTasks(Task task){
        taskService.addTask(task);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/queryList")
    public List<TaskEntry> queryList(){
        return taskService.queryList();
    }
}
