<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

<div>
    <button onclick="location.href='/bookmark_group_add.jsp'" id="btn-bookmark">북마크 그룹 이름 추가</button>
</div>
<table id="bookmark_group_tag">
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>순서</th>
        <th>등록일자</th>
        <th>수정일자</th>
        <th>비고</th>
    </tr>
    <!-- 저장한 위치 정보가 없을 때 -->
    <c:if test="${empty bookmarkGroups}">
        <tr>
            <td colspan="6" style="text-align: center">정보가 존재하지 않습니다.</td>
        </tr>
    </c:if>
    <c:forEach var="bookmarkGroup" items="${bookmarkGroups}">
        <tr>
            <td>${bookmarkGroup.getId()}</td>
            <td>${bookmarkGroup.getBookmarkName()}</td>
            <td>${bookmarkGroup.getSequence()}</td>
            <td>${bookmarkGroup.getRegisterDate()}</td>
            <td>${bookmarkGroup.getUpdateDate()}</td>
            <td style="text-align: center;">
                <button type="button"
                        onclick="location.href='bookmark_group_update?bookmarkGroupId=${bookmarkGroup.id}'">수정
                </button>
                <button type="button"
                        onclick="location.href='bookmark_group_delete?bookmarkGroupId=${bookmarkGroup.id}'">삭제
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

<style>
    #btn-bookmark {
        margin-top: 10px;
    }

    #bookmark_group_tag {
        margin-top: 10px;
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #bookmark_group_tag td, #bookmark_group_tag th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #bookmark_group_tag tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #bookmark_group_tag tr:hover {
        background-color: #ddd;
    }

    #bookmark_group_tag th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
    }
</style>
</html>
