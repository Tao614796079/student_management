package com.biz.servlet;

import com.biz.vo.Student;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/4/18.
 */
public class ServletUtils {
    public static void setStudent(HttpServletRequest request, Student student) {
        try {
            student.setId(request.getParameter("id"));
            student.setName(request.getParameter("name"));
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
            student.setDescription(request.getParameter("description"));
            student.setAvgscore(Integer.parseInt(request.getParameter("avgscore").trim()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
