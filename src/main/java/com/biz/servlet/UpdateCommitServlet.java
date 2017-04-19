package com.biz.servlet;

import com.biz.service.StudentService;
import com.biz.vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/4/18.
 */
@WebServlet("/updatecommit")
public class UpdateCommitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StudentService studentService = new StudentService();
        Student student = new Student();
        ServletUtils.setStudent(request, student);
        System.out.println(student);
        studentService.updateStudent(student);
        response.sendRedirect("/studentlist");
    }
}
