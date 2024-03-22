<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서목록</h3>
<table class="table table-bordered">
  <thead>
    <tr class="table-success">
      <th scope="col" class="text-center">코드</th>
      <th scope="col" class="text-center">제목</th>
      <th scope="col" class="text-center">저자</th>
      <th scope="col" class="text-center">가격</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="dto" items="${list}">
        <tr>
        <th scope="row" class="text-center">${dto.code}</th>
        <td><a href='<c:url value="/read?code=${dto.code}" />' class="text-decoration-none text-reset">${dto.title}</td>
        <td class="text-center">${dto.writer}</td>
        <td class="text-end">
            <fmt:formatNumber type="number" maxFractionDigits="3" value="${dto.price}" />원
        </td>
        </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>