package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

@WebServlet("/read")
public class TodoReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 한글처리
        req.setCharacterEncoding("utf-8");
        // 제목 클릭 시 no 가져오기
        String no = req.getParameter("no");

        // DB 작업
        TodoDao dao = new TodoDao();
        TodoDto todo = dao.getRow(no);

        // todo를 read.jsp에 보여주기
        req.setAttribute("todo", todo);

        RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
