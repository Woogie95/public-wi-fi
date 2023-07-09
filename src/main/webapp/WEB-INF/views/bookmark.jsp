<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

<table id="bookmark_tag">
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>와이파이명</th>
        <th>등록일자</th>
        <th>비고</th>
    </tr>
    <c:if test="${empty bookmark}">
        <tr>
            <td colspan="5" style="text-align: center">정보가 존재하지 않습니다.</td>
        </tr>
    </c:if>
    <c:forEach var="bookmark" items="${bookmark}">
        <tr>
            <td>${bookmark.getId()}</td>
            <td>${bookmark.getBookmarkName()}</td>
            <td>${bookmark.getMainNm()}</td>
            <td>${bookmark.getRegisterDate()}</td>
            <td style="text-align: center">
                <button type="submit" onclick="location.href='bookmark_delete?bookmarkId=${bookmark.id}'">삭제</button>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
<script>
    function showAlert() {
        alert('북마크 정보를 삭제하였습니다.');
    }
</script>
<style>
    #bookmark_tag {
        margin-top: 10px;
    }

    #bookmark_tag {
        margin-top: 10px;
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #bookmark_tag td, #bookmark_tag th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #bookmark_tag tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #bookmark_tag tr:hover {
        background-color: #ddd;
    }

    #bookmark_tag th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
    }
</style>
</html>
