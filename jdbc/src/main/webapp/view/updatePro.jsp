<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.TodoDao" %>
<%@ page import="dto.TodoDto" %>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");

    // 제목 클릭 시 completed, description 가져오기
    // value가 없는 경우 checkbox, radio의 경우에는 on값을 가지고 오게 됨
    String completed = request.getParameter("completed");
    String description = request.getParameter("description");
    String no = request.getParameter("no");

    // DB작업
    TodoDao dao = new TodoDao();

    TodoDto dto = new TodoDto();
    dto.setCompleted(Boolean.parseBoolean(completed));
    dto.setDescription(description);
    dto.setNo(Integer.parseInt(no));

    int result = dao.update(dto);

    // 화면이동(list)
    // sendRedirect(아무것도 안담았을 때 사용), forward(request.set 사용시 무조건)
    response.sendRedirect("list.jsp");
%>