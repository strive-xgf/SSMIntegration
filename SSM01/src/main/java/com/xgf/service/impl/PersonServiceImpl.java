package com.xgf.service.impl;

import com.xgf.bean.Person;
import com.xgf.dao.IPersonDao;
import com.xgf.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public List<Person> findAll() {
        List<Person> allPersonList = personDao.findAll();
        return allPersonList;
    }

    @Override
    public int savePerson(Person person) {
        int code = personDao.savePerson(person);
        return code;
    }
}
