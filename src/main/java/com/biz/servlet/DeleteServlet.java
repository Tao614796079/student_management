package com.biz.servlet;

import com.biz.service.StudentService;
import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除学生
 * Created by Administrator on 2017/4/18.
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StudentService studentService = new StudentService();
        String id = request.getParameter("id");
        studentService.deleteStudent(id);
        request.getRequestDispatcher("/studentlist?cur_page=1").forward(request, response);
    }
}
