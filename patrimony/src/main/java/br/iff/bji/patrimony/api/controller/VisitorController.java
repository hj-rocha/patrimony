package br.iff.bji.patrimony.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.iff.bji.patrimony.api.entity.Visitor;
import br.iff.bji.patrimony.api.service.VisitorService;

@RestController
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "infoV", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createvisitor", method = RequestMethod.POST)
    public String createVisitor(@RequestBody Visitor visitor){
        return visitorService.createVisitor(visitor);
    }

    @RequestMapping(value = "readvisitors", method = RequestMethod.GET)
    public List<Visitor> readVisitors(){
        return visitorService.readVisitors();
    }

    @RequestMapping(value = "updatevisitor", method = RequestMethod.PUT)
    public String updateVisitor(@RequestBody Visitor visitor){
        return visitorService.updateVisitor(visitor);
    }

    @RequestMapping(value = "deletevisitor", method = RequestMethod.DELETE)
    public String deleteVisitor(@RequestBody Visitor visitor){
        return visitorService.deleteVisitor(visitor);
    }
}
