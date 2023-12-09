package br.iff.bji.patrimony.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.iff.bji.patrimony.api.entity.TypeOfSimplePatrimony;
import br.iff.bji.patrimony.api.service.TypeOfSimplePatrimonyService;

@RestController
public class TypeOfSimplePatrimonyController {
    @Autowired
    private TypeOfSimplePatrimonyService typeOfSimplePatrimonyService;

    @RequestMapping(value = "createtypeOfSimplePatrimony", method = RequestMethod.POST)
    public String createTypeOfSimplePatrimony(@RequestBody TypeOfSimplePatrimony typeOfSimplePatrimony){
        return typeOfSimplePatrimonyService.createTypeOfSimplePatrimony(typeOfSimplePatrimony);
    }

    @RequestMapping(value = "readtypeOfSimplePatrimonys", method = RequestMethod.GET)
    public List<TypeOfSimplePatrimony> readTypeOfSimplePatrimonys(){
        return typeOfSimplePatrimonyService.readTypeOfSimplePatrimonys();
    }

    @RequestMapping(value = "updatetypeOfSimplePatrimony", method = RequestMethod.PUT)
    public String updateTypeOfSimplePatrimony(@RequestBody TypeOfSimplePatrimony typeOfSimplePatrimony){
        return typeOfSimplePatrimonyService.updateTypeOfSimplePatrimony(typeOfSimplePatrimony);
    }

    @RequestMapping(value = "deletetypeOfSimplePatrimony", method = RequestMethod.DELETE)
    public String deleteTypeOfSimplePatrimony(@RequestBody TypeOfSimplePatrimony typeOfSimplePatrimony){
        return typeOfSimplePatrimonyService.deleteTypeOfSimplePatrimony(typeOfSimplePatrimony);
    }
}
