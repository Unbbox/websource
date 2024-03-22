<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="dto.TodoDto"%>
<%
  List<TodoDto> list = (List<TodoDto>) request.getAttribute("list");
%>
<h1 class="mt-5">Todo List</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">완료여부</th>
    </tr>
  </thead>
  <tbody>
    <%
    for(TodoDto dto:list){
    %>
    <tr>
        <th scope="row"><%=dto.getNo()%></th>
        <td><a href='<c:url value="/read.do?no=${dto.no}" />' class="text-decoration-none text-reset"><%=dto.getTitle()%></a></td>
        <td><%=dto.getCreatedAt()%></td>
        <td>
          <%-- <input type="checkbox" name="completed" id="completed" class="form-check-input" name="completed" value="true" value="<%=dto.getCompleted()%>" > --%>
          <input type="checkbox" name="completed" id="completed" class="form-check-input" name="completed" value="true" <c:out value="${dto.completed?'checked':''}" /> >
        </td>
      </tr>
    <%
      }
    %>

    <c:forEach var="dto" items="${list}">
      <tr>
        <th scope="row">${dto.code}</th>
        <td><a href='<c:url value="read.do?no=${dto.no}" />' class="text-decoration-none text-reset">${dto.title}</a></td>
        <td>${dto.createdAt}</td>
        <td>
          <input type="checkbox" name="completed" id="completed" class="form-check-input" name="completed" value="true" <c:out value="${dto.completed?'checked':''}"/> >
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="/include/footer.jsp" %>