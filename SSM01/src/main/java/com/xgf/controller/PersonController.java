package com.xgf.controller;

import com.xgf.bean.Person;
import com.xgf.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @RequestMapping(path="/list",method = RequestMethod.GET)
    public String list(Model model){
        //显示所有的person数据
        List<Person> personList = personService.findAll();
        System.out.println("list() personList= "+personList);
        //数据放在Model对象，由Model传给页面
        model.addAttribute("personList",personList);//参1 key  参2 value
        return "personList";//返回list页面

    }
}
