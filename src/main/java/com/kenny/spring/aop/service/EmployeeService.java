package com.kenny.spring.aop.service;

import com.kenny.spring.aop.dao.EmployeeDao;

/**
 * 员工服务
 */
public class EmployeeService {
    private EmployeeDao employeeDao;
    public void entry(){
        System.out.println("execute employee entry logic");
        employeeDao.insert();
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
