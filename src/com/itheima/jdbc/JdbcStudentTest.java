package com.itheima.jdbc;

import java.util.Scanner;

public class JdbcStudentTest {
   public static void main(String[] args){
       JdbcTemplateTest jdbc=new JdbcTemplateTest();

       System.out.println("------学生信息管理平台------");
       Scanner scan=new Scanner(System.in);
       while(true){
           System.out.println("请选择你的操作：(1:增  2:删  3:改  4:查  5:浏览)");
           int x=scan.nextInt();
           int a=0;
           switch(x){
               case 1:
                   jdbc.addStudent();
                   a++;
                   break;
               case 2:
                   jdbc.deleteStudent();
                   break;
               case 3:
                   jdbc.updateStudent();
                   break;
               case 4:
                   jdbc.findStudentById();
                   break;
               case 5:
                   jdbc.findAllStudent();
                   break;
               default:
                   System.out.println("输入有误，请重新输入。");
                   break;
           }

       }
   }
}
