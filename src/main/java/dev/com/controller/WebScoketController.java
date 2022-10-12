package dev.com.controller;

import dev.com.pojo.WebSocketServer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@Controller
//@RequestMapping("/web")
public class WebScoketController
{
    @Autowired
    private WebSocketServer webSocketServer;

    @ResponseBody
    @RequestMapping("/sendMessage")
    public String batchMessage(String uid,String message)
    {
        Map<String, String> map =new HashMap<String, String>();
        try
        {
            map.put("code", "200");
            webSocketServer.batchSendMesasge(uid,message);
        }
        catch (Exception e)
        {
            map.put("code", "-1");
            map.put("message", e.getMessage());
        }
//        return JSON.toJSONString(map);
//        return JSONObject.valueToString(map);
        return null;
    }

    @GetMapping("/enter")
    public ModelAndView enter()
    {
//        return "webscoketTest.html";
//        return "index";
        ModelAndView modelAndView =new ModelAndView("index");
//        modelAndView.setViewName("index");
//        modelAndView.setView("index");
        return modelAndView;
    }
    @RequestMapping("/index")
    public String getIndex(){
        return "webscoketTest";
    }
}

