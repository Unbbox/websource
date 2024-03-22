<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="dao.TodoDao" %>
<%@ page import="dto.TodoDto" %>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");

    // 사용자가 입력한 todo 가져오기
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    // DB작업
    TodoDao dao = new TodoDao();

    TodoDto insertDto = new TodoDto();
    insertDto.setTitle(title);
    insertDto.setDescription(description);

    int result = dao.insert(insertDto);

    // 화면이동(list)
    // sendRedirect, forward
    response.sendRedirect("list.jsp");
%>