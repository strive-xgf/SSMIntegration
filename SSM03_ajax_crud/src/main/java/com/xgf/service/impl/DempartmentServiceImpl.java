package com.xgf.service.impl;


import com.xgf.bean.Department;
import com.xgf.dao.IDepartmentDao;
import com.xgf.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DempartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentDao dao;
    @Override
    public List<Department> findAllDepartments() {
        List<Department> list = dao.findAll();
        return list;
    }

    @Override
    public void saveDepartment(Department dept) {
        dao.save(dept);
    }

    @Override
    public void deleteDepartmentById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void updateDepartmentById(Department dept) {
        dao.update(dept);
    }

    @Override
    public Department findDepartmentById(int did) {
        return dao.findById(did);
    }
}
