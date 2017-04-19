package com.biz.servlet;

import com.biz.service.StudentService;
import com.biz.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 添加学生
 * Created by Administrator on 2017/4/18.
 */
@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Student student = new Student();
        StudentService studentService = new StudentService();

        ServletUtils.setStudent(request, student);
        studentService.addStudent(student);
        response.sendRedirect("/studentlist?cur_page=1");
    }

}
