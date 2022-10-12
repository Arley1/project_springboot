package dev.com;

import dev.com.controller.TaskController;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = AppMain.class)
public class Test {

    private MockMvc mvc;

    @Autowired
    TaskController taskController;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(taskController).build();
        System.out.println("初始化mock模块");
    }

    @org.junit.jupiter.api.Test
    public void queryResult() throws Exception {
        setUp();
        ResultActions res = mvc.perform(MockMvcRequestBuilders.get("/task/queryAll").accept(MediaType.APPLICATION_JSON));
        res.andReturn();
    }
}
