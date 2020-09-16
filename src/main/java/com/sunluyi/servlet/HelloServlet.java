package com.sunluyi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet",urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");//返回String类型,.var生成快捷键
        String agestr = request.getParameter("age");
        int age = 0;
        try {
            age = Integer.parseInt(agestr);
        } catch (NumberFormatException e) {
            System.out.println("年龄转换格式错误");
        }
        System.out.println("haha hehe xixi ");
        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println("Helloworld"); //打印输出流
        PrintWriter out = response.getWriter();
        out.printf("hello %s 你的年龄是%d岁",name,age);
        //响应结束之后 不能在后面继续  sout
        out.append("<table border=1>" +
                "<tr><td>name</td><td>age</td></tr>" +
                "<tr><td>"+name+"</td><td>"+age+"</td>"+
                "</table> ");
    }
}
