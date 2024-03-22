<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.TodoDao" %>
<%@ page import="dto.TodoDto" %>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");
    // 제목 클릭 시 no 가져오기
    String no = request.getParameter("no");

    // DB작업
    TodoDao dao = new TodoDao();
    TodoDto todo = dao.getRow(no);

    // todo를 read.jsp에 보여주기
    request.setAttribute("todo", todo);

    // 화면이동(list)
    // sendRedirect, forward(request.set 사용시 무조건)
    pageContext.forward("modify.jsp");
%>