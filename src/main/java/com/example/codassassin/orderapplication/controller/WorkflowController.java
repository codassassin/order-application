package com.example.codassassin.orderapplication.controller;


import com.example.codassassin.orderapplication.model.Order;
import com.example.codassassin.orderapplication.service.WorkflowService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/deploy")
    public void deploy() {
        System.out.println("Deploying ...");
        workflowService.deployProcessDefinition();
    }

    @PostMapping("/order")
    public void order(@RequestBody Order order) {
        System.out.println("Ordered ...");
        workflowService.startWorkflow();
    }

    @GetMapping("/getPickupTasks")
    public List<String> getPickupTasks() {
        return workflowService.getDeliveryOrders();
    }

    @GetMapping("/getPendingList")
    public List<String> getPending() {
        return workflowService.getDeliveryOrders();
    }

    @PostMapping("/confirm")
    public void confirm(@RequestParam String taskId) {
        taskService.complete(taskId);
        System.out.println("Order picked up");
    }

    @PostMapping("/confirm-delivery")
    public void confirmDelivery(@RequestParam String taskId) {
        taskService.complete(taskId);
        System.out.println("Delivered");
    }
}
