package com.xgf.service;

import com.xgf.bean.Department;

import java.util.List;

public interface IDepartmentService {
    //查询所有的部门数据 显示成列表
    List<Department> findAllDepartments();
    //添加一个新的部门
    void saveDepartment(Department dept);
    //删除指定id的部门数据
    void deleteDepartmentById(int did);
    //根据指定id修改部门名称
    void updateDepartmentById(Department dept);
    //查找指定id的部门数据
    Department findDepartmentById(int did);
}
