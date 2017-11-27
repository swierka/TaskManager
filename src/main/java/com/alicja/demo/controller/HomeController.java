package com.alicja.demo.controller;

import com.alicja.demo.db.TaskService;
import com.alicja.demo.db.TaskServiceImp;
import com.alicja.demo.model.Task;
import com.alicja.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskServiceImp taskServiceImp;

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String taskDetails(Model model){
        List<Task> tasks = taskServiceImp.getAll();
        model.addAttribute("lista",tasks);
        return "index";
    }


}

