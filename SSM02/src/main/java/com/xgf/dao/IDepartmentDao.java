package com.xgf.dao;

import com.xgf.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentDao {
    //select * from department order by did asc;
    List<Department> findAll();

    //insert into department values(null,'UI');
    void save(Department dept);
    //delete from department where did = 5;
    void deleteById(int id);

    //update department set dname = ? where did = 1;
    void update(Department dept);

    //select * from department where did = 1;
    Department findById(int did);
}
