<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<h3 class="border-bottom mb-3">도서추가</h3>
<form action='<c:url value="/create" />' method="post">
  <div class="mb-3">
    <label for="code" class="form-label">코드</label>
    <input type="text" class="form-control" id="code" value="" name="code">
  </div>
  <div class="mb-3">
    <label for="title" class="form-label">제목</label>
    <input type="text" class="form-control" id="title" name="title">
  </div>
  <div class="mb-3">
    <label for="writer" class="form-label">저자</label>
    <input type="text" class="form-control" id="writer" name="writer">
  </div>
  <div class="mb-3">
    <label for="price" class="form-label">가격</label>
    <input type="text" class="form-control" id="price" name="price">
  </div>
  <div class="mb-3">
    <label for="description" class="form-label">설명</label>
    <textarea class="form-control" id="description" rows="3" name="description"></textarea>
  </div>
  <div>
      <button type="submit" class="btn btn-success">추가</button>
      <a href='<c:url value="/list" />' class="btn btn-primary">목록</a>
  </div>
</form>
<%@ include file="/include/section.jsp" %>
<script src='<c:url value="/js/create.js" />'></script>
<%@ include file="/include/footer.jsp" %>