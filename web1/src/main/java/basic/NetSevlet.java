package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/net")
public class NetSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // HttpServletRequest 객체로 알 수 있는 정보
        // 1. 사용자 입력 가져오기
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("Request Scheme : " + req.getScheme() + "<br>");
        out.println("Server Name : " + req.getServerName() + "<br>");
        out.println("Server Address : " + req.getLocalAddr() + "<br>");
        out.println("Server Port : " + req.getServerPort() + "<br>");
        out.println("Client Address : " + req.getRemoteAddr() + "<br>");
        out.println("Client Host : " + req.getRemoteHost() + "<br>");
        out.println("Client Port : " + req.getRemotePort() + "<br>");
        out.println("RequestURI : " + req.getRequestURI() + "<br>");
        out.println("RequestURL : " + req.getRequestURL() + "<br>");
        out.println("ContextPath : " + req.getContextPath() + "<br>"); // project 명
        out.println("ServletPath : " + req.getServletPath() + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
