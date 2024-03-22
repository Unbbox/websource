<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<h1>Todo List</h1>
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
    <c:forEach var="dto" items="${list}">
      <tr>
        <th scope="row">${dto.code}</th>
        <td><a href='<c:url value="read?no=${dto.no}"/>' class="text-decoration-none text-reset">${dto.title}</td>
        <td>${dto.createdAt}</td>
        <td>${dto.price}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="../include/footer.jsp" %>