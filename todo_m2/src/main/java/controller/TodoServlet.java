package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.TodoCreateAction;
import action.TodoDeleteAction;
import action.TodoListAction;
import action.TodoModifyAction;
import action.TodoReadAction;
import action.TodoUpdateAction;
import dao.TodoDao;
import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpli;

@WebServlet("*.do")
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 경로에서 요청 찾기
        // requestUri : localhost:8080 이후의 값 => /todo_m2/list.do
        String requestUri = req.getRequestURI();
        // contextPath : /todo_m2
        String contextPath = req.getContextPath(); // 프로젝트 명
        // substring으로 /todo_m2 길이만큼 떼어내기 => /list.do만 남음
        String cmd = requestUri.substring(contextPath.length());

        // System.out.println("requestUri : " + requestUri);
        // System.out.println("contextPath : " + contextPath);
        System.out.println("cmd : " + cmd);

        Action action = null;

        if (cmd.equals("/list.do")) {
            action = new TodoListAction("/view/list.jsp");
        } else if (cmd.equals("/read.do")) {
            // RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
            // rd.forward(req, res);
            action = new TodoReadAction("/view/read.jsp");
        } else if (cmd.equals("/modify.do")) {
            // RequestDispatcher rd = req.getRequestDispatcher("/view/modify.jsp");
            // rd.forward(req, res);
            action = new TodoModifyAction("/view/modify.jsp");
        } else if (cmd.equals("/update.do")) {
            action = new TodoUpdateAction("/list.do");
        } else if (cmd.equals("/delete.do")) {
            action = new TodoDeleteAction("/list.do");
        } else if (cmd.equals("/create.do")) {
            action = new TodoCreateAction("/list.do");
        }

        ActionForward af = null;

        try {
            af = action.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (af.isRedirect()) {
            res.sendRedirect(af.getPath());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
            rd.forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
