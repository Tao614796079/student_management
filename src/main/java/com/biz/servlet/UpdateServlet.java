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


/**
 * Created by Administrator on 2017/4/18.
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StudentService studentService = new StudentService();
        try {
            Student student = studentService.getById(request.getParameter("id"));
            request.setAttribute("student", student);
            request.getRequestDispatcher("updatestudent.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
