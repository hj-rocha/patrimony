package br.iff.bji.patrimony.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.iff.bji.patrimony.api.entity.Patrimony;
import br.iff.bji.patrimony.api.service.PatrimonyService;

@RestController
public class PatrimonyController {
    @Autowired
    private PatrimonyService patrimonyService;

    @RequestMapping(value = "createpatrimony", method = RequestMethod.POST)
    public String createPatrimony(@RequestBody Patrimony patrimony){
        return patrimonyService.createPatrimony(patrimony);
    }

    @RequestMapping(value = "readpatrimonys", method = RequestMethod.GET)
    public List<Patrimony> readPatrimonys(){
        return patrimonyService.readPatrimonys();
    }

    @RequestMapping(value = "updatepatrimony", method = RequestMethod.PUT)
    public String updatePatrimony(@RequestBody Patrimony patrimony){
        return patrimonyService.updatePatrimony(patrimony);
    }

    @RequestMapping(value = "deletepatrimony", method = RequestMethod.DELETE)
    public String deletePatrimony(@RequestBody Patrimony patrimony){
        return patrimonyService.deletePatrimony(patrimony);
    }
}
