package com.example.dao;

import com.example.pojo.Department;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    @Autowired
    private DepartmentDao departmentDao;
    //模拟数据
    private static Map<Integer, Employee> employees = null;
    static {
        employees = new HashMap<Integer,Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"AA","123456@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","545456@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","12jmk5@qq.com",0,new Department(101,"教学部")));
        employees.put(1004,new Employee(1004,"DD","jwh356@qq.com",1,new Department(101,"教学部")));
        employees.put(1005,new Employee(1005,"EE","1ywh56@qq.com",0,new Department(102,"市场部")));
        employees.put(1006,new Employee(1006,"FF","12sss6@qq.com",0,new Department(105,"后勤部")));
    }
    //增加一个员工
    //主键自增
    private static Integer initId = 1007;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    // 通过id查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //删除员工通过id
    public void delete(Integer id) {
        employees.remove(id);
    }


}
