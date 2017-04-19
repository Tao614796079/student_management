package com.biz.test;

import com.biz.service.StudentService;
import com.biz.vo.Student;


import java.text.ParseException;
import java.util.Date;


/**
 * Created by Administrator on 2017/4/18.
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        StudentService service = new StudentService();
        //存100个学生数据
        for (int i = 1; i <= 100; i++) {
            Student student = new Student(Integer.toString(i), "测试数据" + i, new Date(), "测试数据" + i, (int) (Math.random() * 100));
            service.addStudent(student);
        }
    }
}
