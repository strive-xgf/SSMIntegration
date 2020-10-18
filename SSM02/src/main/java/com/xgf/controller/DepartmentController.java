package com.xgf.controller;


import com.xgf.bean.Department;
import com.xgf.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
    //slf4j
    private static  final Logger l = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private IDepartmentService iDepartmentService;

    //查询所有部门并跳转页面显示
    @RequestMapping(path = "/deptlist",method = RequestMethod.GET)
    public String list(Model model){
        List<Department> depts = iDepartmentService.findAllDepartments();
        l.info("部门deptlist列表:   depts="+depts);
        //数据添加到页面
        model.addAttribute("depts",depts);
        return "list_depts";
    }

//一般修改都有回显界面（增加、删除、更新），查询不需要回显页面，就是新出一个页面供你更改数据
    //回显就是两个方法，先查询显示，再修改（两个sql）

    //跳转新增保存部门的回显页面
    @RequestMapping(path="/saveDeptUI",method = RequestMethod.GET)
    public String saveDeptUI(){
        l.info("跳转saveDeptUI回显页面，进行数据修改 ");
        return "saveDeptUI";
    }
    //新增保存部门
    @RequestMapping(path ="/saveDept",method = {RequestMethod.POST})
    public String save(Department dept,Model model){
        if (dept.getDname() != null && !"".equals(dept.getDname())) {
            iDepartmentService.saveDepartment(dept);
            l.info("saveDept 保存信息： dept="+dept);
            return "redirect:/dept/deptlist";
        }else{
            model.addAttribute("error_msg","部门名称不能为空");
            return "forward:/error_saveDept.jsp";    //错误，部门为空不能增加跳转错误界面
        }
    }

    //删除部门
    @RequestMapping(path = "/deleteDept",method = RequestMethod.GET)
    public String delete(Integer did){
        l.info("deleteDept 删除部门  did = "+did);
        iDepartmentService.deleteDepartmentById(did);
        return "redirect:/dept/deptlist";   //删除之后再查询所有显示
    }

    //更新
    // 跳转更新回显页面 updateUI?did=23
    @RequestMapping(path = "/updateDeptUI",method = RequestMethod.GET)
    public String updateUI(Integer did,Model model){
        l.info("updateDeptUI 更新部门的 did = "+did);
        Department department = iDepartmentService.findDepartmentById(did);
        model.addAttribute("dept",department);
        return "update_deptUI";
    }

    //进行更新操作
    @RequestMapping(path="/updateDept",method = RequestMethod.POST)
    public String update(Department dept){
        //打印
        l.info("updateDept 更新信息： dept="+dept);
        //调用service
        iDepartmentService.updateDepartmentById(dept);
        //跳到查询页面
        return "redirect:/dept/deptlist";
    }

}
