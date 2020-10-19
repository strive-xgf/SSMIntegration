package com.xgf.controller;


import com.xgf.bean.Department;
import com.xgf.bean.Msg;
import com.xgf.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//版本2 - 使用ajax来CRUD
//地址带UI的表示显示（打开）一个页面，不带UI的是查询返回json格式数据
/*
一般修改操作都有回显界面（增加、删除、更新），查询不需要回显页面，就是新出一个页面供你更改数据
    回显就是两个方法，先查询显示，再修改（两个sql）
*/
@Controller
@RequestMapping("/deptv2")
public class DepartmentController {
    //slf4j日志
    private static  final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

//1. 查询显示所有部门
    //跳转显示所有部门信息页面【UI只做页面跳转】
    @RequestMapping(path = "/deptListUI",method = RequestMethod.GET)
    public String deptListUI(Model model){
        return "list_depts";
    }

    //不带UI，查询返回json数据
    //@ResponseBody注解，调用jackson库，将方法返回值转换为json字符串
    @RequestMapping(path="/deptList",method = {RequestMethod.GET})
    @ResponseBody
    public Object deptList(){
        //查询所有部门方法，返回json数据格式
        List<Department> allDepartments = departmentService.findAllDepartments();
        log.info("deptList 查询所有部门  " + allDepartments);
        return Msg.init(200,"",allDepartments);//返回数据
    }


//2. 新增保存部门
    @RequestMapping(path ="/saveDept",method = {RequestMethod.POST})
    @ResponseBody
    public Object saveDept(Department dept){
        log.info("saveDept 保存信息： dept="+dept);
        try {
            departmentService.saveDepartment(dept);
            return  Msg.init(200,"添加成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Msg.init(-200,"添加失败",null);
    }


//3. 通过id删除部门功能 前台拼接删除a标签地址要携带id，发送给后台，根据id进行删除部门
    @RequestMapping(path = "/deleteDept",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteDept(Integer did){
        log.info("deleteDept 删除部门  did = "+did);
        try {
            //删除
            departmentService.deleteDepartmentById(did);
            //删除成功 返回200正确码
            return Msg.init(200,"删除did = "+did+"的部门成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.init(-200,"异常，删除失败",null);//出现异常
    }






//3. 通过id更新部门信息，需要先查询该id是否存在
    //通过id查询部门
    @RequestMapping(path = "/findDeptById", method = RequestMethod.GET)
    @ResponseBody
    public Object findDeptById(Integer did) {
        log.info("findDeptById 通过id查找部门 did=" + did);
        if (did != null) {
            //查询回显需要的数据，然后显示给更新页面赋值
            Department dept = departmentService.findDepartmentById(did);
            if (dept != null) {
                //将部门信息转成json返回页面，然后显示在更新回显页面上
                return Msg.init(200, null, dept);
            }
        }
        return Msg.init(-200, "没有查询到结果", null);
    }


    //进行更新操作
    @RequestMapping(path="/updateDept",method = RequestMethod.POST)
    @ResponseBody
    public Object updateDept(Department dept){
        //打印
        log.info("updateDept 更新信息： dept="+dept);
        try {
            departmentService.updateDepartmentById(dept);
            return Msg.init(200, "更新部门信息成功", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.init(-200, "异常，更新失败", null);

    }

}
