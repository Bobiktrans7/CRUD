package org.example.conroller;

import org.example.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test-batch-update")
public class BatchController {
    private final PersonDAO personDAO;
    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(){
        return "batch/index";
    }
    @GetMapping("/without")
    public String without(){
        personDAO.TestMultipleUpdate();
        return "redirect: people";
    }
    @GetMapping("/withoutBatch")
    public String withoutBatch(){
        personDAO.TestBatchUpdate();
        return "redirect: people";
    }
}
