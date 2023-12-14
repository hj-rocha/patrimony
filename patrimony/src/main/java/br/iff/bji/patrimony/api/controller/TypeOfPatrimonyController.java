package br.iff.bji.patrimony.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.iff.bji.patrimony.api.entity.TypeOfPatrimony;
import br.iff.bji.patrimony.api.service.TypeOfPatrimonyService;

@RestController
public class TypeOfPatrimonyController {
    @Autowired
    private TypeOfPatrimonyService typeOfPatrimonyService;

    @RequestMapping(value = "createtypeOfPatrimony", method = RequestMethod.POST)
    public String createTypeOfPatrimony(@RequestBody TypeOfPatrimony typeOfPatrimony){
        return typeOfPatrimonyService.createTypeOfPatrimony(typeOfPatrimony);
    }

    @RequestMapping(value = "readtypeOfPatrimonys", method = RequestMethod.GET)
    public List<TypeOfPatrimony> readTypeOfPatrimonys(){
        return typeOfPatrimonyService.readTypeOfPatrimonys();
    }

    @RequestMapping(value = "updatetypeOfPatrimony", method = RequestMethod.PUT)
    public String updateTypeOfPatrimony(@RequestBody TypeOfPatrimony typeOfPatrimony){
        return typeOfPatrimonyService.updateTypeOfPatrimony(typeOfPatrimony);
    }

    @RequestMapping(value = "deletetypeOfPatrimony", method = RequestMethod.DELETE)
    public String deleteTypeOfPatrimony(@RequestBody TypeOfPatrimony typeOfPatrimony){
        return typeOfPatrimonyService.deleteTypeOfPatrimony(typeOfPatrimony);
    }
}
