package com.alicja.demo.controller;


import com.alicja.demo.model.Task;
import com.alicja.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/zadanie")
    public String singleTaskDetails(@RequestParam Long id, Model model){
    Task task = taskRepository.findOne(id);
    model.addAttribute("task",task);
    return "task";
    }

    @GetMapping("/dodajZadanie")
    public String addTask(Model model){
        Task newTask = new Task();
        model.addAttribute("toBedzieNoweZadanie",newTask);
        return "addTask";
    }

    @PostMapping("/dodajNoweZadanie")
    public String addingNewTask(Task newTask){
        taskRepository.save(newTask);
        return "redirect:/";
    }
}
