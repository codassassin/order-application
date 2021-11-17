package com.example.codassassin.orderapplication.service;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkflowService {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    TaskService taskService;

    public void deployProcessDefinition() {
        Deployment deployment = repositoryService
                .createDeployment()
                .addClasspathResource("processes\\order_application_model.bpmn20.xml")
                .deploy();

        System.out.println("[+] Deployed ");
    }

    public List<String> getDeliveryOrders() {
        List<Task> tasks = taskService.createTaskQuery().taskDefinitionId("confirmOrderPickup").list();
        List<String> ids = new ArrayList<>();
        for (Task task : tasks) {
            ids.add(task.getId());
        }
        return ids;
    }


}


