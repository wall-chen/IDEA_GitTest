package com.itheima.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    // 声明JdbcTemplate属性及其setter方法
    private JdbcTemplate jdbcTemplate;

    public StudentDaoImpl() {
        super();
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 添加学生
    @Override
    public int addStudent(Students student) {
        // 定义SQL
        String sql = "insert into student(studentname,age,score) value(?,?,?)";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {
                student.getStudentname(),
                student.getAge(),
                student.getScore(),
        };
        // 执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;
    }

    @Override
    public int updateStudent(Students student) {
        // 定义SQL
        String sql = "update student set studentname=?,age=?,score=? where id = ?";
        // 定义数组来存放SQL语句中的参数
        Object[] params = new Object[] {
                student.getStudentname(),
                student.getAge(),
                student.getScore(),
                student.getId(),
        };
        // 执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, params);
        return num;
    }

    @Override
    public int deleteStudent(int id) {
        // 定义SQL
        String sql = "delete  from student where id = ? ";
        // 执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }

    @Override
    public Students findStudentById(int id) {
        //定义SQL语句
        String sql = "select * from student where id = ?";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Students> rowMapper =
                new BeanPropertyRowMapper<Students>(Students.class);
        // 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Students> findAllStudent() {
        // 定义SQL语句
        String sql = "select * from student";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Students> rowMapper =
                new BeanPropertyRowMapper<Students>(Students.class);
        // 执行静态的SQL查询，并通过RowMapper返回结果
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
