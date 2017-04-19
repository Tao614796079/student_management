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
import java.util.List;

/**
 * 获取学生信息列表
 * Created by Administrator on 2017/4/18.
 */
@WebServlet("/studentlist")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String cur_page = request.getParameter("cur_page");
        StudentService studentService = new StudentService();
        int totalPage = studentService.getTotalPage();
        try {
            List<Student> studentList = studentService.getOnePage(Integer.parseInt(cur_page));
            request.setAttribute("studentList", studentList);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("cur_page", cur_page);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
