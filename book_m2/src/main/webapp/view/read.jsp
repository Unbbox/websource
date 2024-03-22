<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서상세보기</h3>
<div class="mb-3">
  <label for="code" class="form-label">코드</label>
  <input type="text" class="form-control" id="code" readonly value="${dto.code}" name="code">
</div>
<div class="mb-3">
  <label for="title" class="form-label">제목</label>
  <input type="text" class="form-control" id="title" readonly value="${dto.title}" name="title">
</div>
<div class="mb-3">
  <label for="writer" class="form-label">저자</label>
  <input type="text" class="form-control" id="writer" readonly value="${dto.writer}" name="writer">
</div>
<div class="mb-3">
  <label for="price" class="form-label">가격</label>
  <input type="text" class="form-control" id="price" readonly value="${dto.price}" name="price">
</div>
<div class="mb-3">
  <label for="description" class="form-label">설명</label>
  <textarea class="form-control" id="description" rows="3" name="description" readonly>${dto.description}</textarea>
</div>
<div>
    <a href='<c:url value="/list.do" />' class="btn btn-primary">목록</a>
</div>
<%@ include file="/include/section.jsp" %>
<%@ include file="/include/footer.jsp" %>