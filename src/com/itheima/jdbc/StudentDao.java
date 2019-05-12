package com.itheima.jdbc;

import java.util.List;

public interface StudentDao {

    // 添加
    public int addStudent(Students student);
    // 更新
    public int updateStudent(Students student);
    // 删除
    public int deleteStudent(int id);



    // 通过id查询
    public Students findStudentById(int id);

    // 查询所有账户
    public List<Students> findAllStudent();
}
