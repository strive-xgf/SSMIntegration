package com.xgf.service;

import com.xgf.bean.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDepartmentService {
    private static final Logger l = LoggerFactory.getLogger(TestDepartmentService.class);
    @Autowired
    IDepartmentService service;

    @Test
    public void test01() {
        List<Department> list = service.findAllDepartments();
        l.info("获取部门列表： list=" + list);
    }

}


