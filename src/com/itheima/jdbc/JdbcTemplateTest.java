package com.itheima.jdbc;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import 
     org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
public class JdbcTemplateTest {
	/**
	 * 使用execute()方法建表
	 */
	@Test
	public void main() {
		System.out.println("------学生信息管理平台------");
		Scanner scan=new Scanner(System.in);
		while(true){
			System.out.println("请选择你的操作：(1:增  2:删  3:改  4:查  5:浏览)");
			int i=scan.nextInt();
			switch(i){
				case 1:
					addStudent();
					break;
				case 2:
					deleteStudent();
					break;
				case 3:
					updateStudent();
					break;
				case 4:
					findStudentById();
					break;
				case 5:
					findAllStudent();
					break;
				default:
					System.out.println("输入有误，请重新输入。");
					break;
			}

		}
	}

	public void addStudent(){
		Students students=new Students();
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入学生姓名:");
		students.setStudentname(scan.next());

		System.out.println("请输入学生年龄:");
		students.setAge(scan.nextInt());

		System.out.println("请输入学生成绩:");
		students.setScore(scan.next());

		int check=addStudentTest(students);

		if(check==1){
			System.out.println("插入学生信息成功！");
		}
		else{
			System.out.println("插入学生信息失败！");
		}
	}

	public void deleteStudent(){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入学生学号:");
		int i=(scan.nextInt());

		int check=deleteStudentTest(i);

		if(check==1){
			System.out.println("删除学生信息成功！");
		}
		else{
			System.out.println("删除学生信息失败！");
		}
	}

	public void updateStudent(){
		Students students=new Students();
		Scanner scan=new Scanner(System.in);

		System.out.println("请输入学生学号:");
		students.setId(scan.nextInt());

		System.out.println("请输入学生姓名:");
		students.setStudentname(scan.next());

		System.out.println("请输入学生年龄:");
		students.setAge(scan.nextInt());

		System.out.println("请输入学生成绩:");
		students.setScore(scan.next());

		int check=updateStudentTest(students);

		if(check==1){
			System.out.println("修改学生信息成功！");
		}
		else{
			System.out.println("修改学生信息失败！");
		}
	}

	public void findStudentById(){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入学生学号:");
		findStudentByIdTest(scan.nextInt());
	}

	public void findAllStudent(){
		findAllStudentTest();
	}

	@Test
	public void mainTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取JdbcTemplate实例
	    JdbcTemplate jdTemplate = 
	            (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
	    // 使用execute()方法执行SQL语句，创建用户账户管理表account
	    jdTemplate.execute("create table student(" +
	                           "id int primary key auto_increment," +
	                           "studentname varchar(50)," +
	                           "age int)");
	    System.out.println("账户表student创建成功！");
	}

	@Test
	public void addAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 创建Account对象，并向Account对象中添加数据
	    Account account = new Account();
	    account.setUsername("chenqihan");
	    account.setBalance(90000.00);
	    // 执行addAccount()方法，并获取返回结果
	    int num = accountDao.addAccount(account);
	    if (num > 0) {
	        System.out.println("成功插入了" + num + "条数据！");
	    } else {
	        System.out.println("插入操作执行失败！");
	    }
	}


	public int addStudentTest(Students students) {
		// 加载配置文件
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		StudentDao studentDao =
				(StudentDao) applicationContext.getBean("studentDao");
		// 创建Account对象，并向Account对象中添加数据

		// 执行addAccount()方法，并获取返回结果
		int num = studentDao.addStudent(students);

		return num;
	}
	
	@Test
	public void updateAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao =
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 创建Account对象，并向Account对象中添加数据
	    Account account = new Account();
	    account.setId(1);
	    account.setUsername("tom");
	    account.setBalance(2000.00);
	    // 执行updateAccount()方法，并获取返回结果
	    int num = accountDao.updateAccount(account);
	    if (num > 0) {
	        System.out.println("成功修改了" + num + "条数据！");
	    } else {
	        System.out.println("修改操作执行失败！");
	    }
	}


	public int updateStudentTest(Students students) {
		// 加载配置文件
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		StudentDao studentDao =
				(StudentDao) applicationContext.getBean("studentDao");
		// 创建Account对象，并向Account对象中添加数据

		// 执行updateAccount()方法，并获取返回结果
		int num = studentDao.updateStudent(students);

		return num;
	}
	
	@Test
	public void deleteAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 执行deleteAccount()方法，并获取返回结果
	    int num = accountDao.deleteAccount(1);
	    if (num > 0) {
	        System.out.println("成功删除了" + num + "条数据！");
	    } else {
	        System.out.println("删除操作执行失败！");
	    }
	}


	public int deleteStudentTest(int i) {
		// 加载配置文件
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		StudentDao studentDao =
				(StudentDao) applicationContext.getBean("studentDao");
		// 创建Account对象，并向Account对象中添加数据

		// 执行updateAccount()方法，并获取返回结果
		int num = studentDao.deleteStudent(i);

		return num;
	}

	@Test
	public void findAccountByIdTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 执行findAccountById()方法
	    Account account = accountDao.findAccountById(1);
	    System.out.println(account);
	}

	public void findStudentByIdTest(int i) {
		// 加载配置文件
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao =
				(StudentDao) applicationContext.getBean("studentDao");
		// 执行findAccountById()方法
		Students students = studentDao.findStudentById(i);
		System.out.println(students);
	}

	@Test
	public void findAllAccountTest() {
	    // 加载配置文件
	    ApplicationContext applicationContext = 
	            new ClassPathXmlApplicationContext("applicationContext.xml");
	    // 获取AccountDao实例
	    AccountDao accountDao = 
	            (AccountDao) applicationContext.getBean("accountDao");
	    // 执行findAllAccount()方法,获取Account对象的集合
	    List<Account> account = accountDao.findAllAccount();
	    // 循环输出集合中的对象
	    for (Account act : account) {
	        System.out.println(act);
	    }
	}

	public void findAllStudentTest() {
		// 加载配置文件
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao =
				(StudentDao) applicationContext.getBean("studentDao");
		// 执行findAllAccount()方法,获取Account对象的集合
		List<Students> studentsList = studentDao.findAllStudent();
		// 循环输出集合中的对象
		for (Students stu : studentsList) {
			System.out.println(stu);
		}
	}
}
