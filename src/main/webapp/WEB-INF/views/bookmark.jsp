<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

<div class="bookmark_tag">
    <table>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>와이파이명</th>
            <th>등록일자</th>
            <th>비고</th>
        </tr>
        <c:forEach var="bookmark" items="${bookmarkList}">
            <tr>
                <td>${bookmark.getId()}</td>
                <td>${bookmark.getBookmarkName()}</td>
                <td>${bookmark.getWifiName()}</td>
                <td>${bookmark.getRegisterDate()}</td>
                <td><a href="delete_bookmark?id=${bookmark.getId()}">삭제</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
