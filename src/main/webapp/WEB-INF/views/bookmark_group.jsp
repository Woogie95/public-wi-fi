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
    <a href="bookmark_group_add.jsp"><input id="btn-bookmark" type="button" value="북마크 그룹 이름 추가"/></a>
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
    <c:if test="${empty bookmarkGroupList}">
        <tr>
            <td colspan="6" style="text-align: center">정보가 존재하지 않습니다.</td>
        </tr>
    </c:if>
    <c:forEach var="bookmarkGroup" items="${bookmarkGroupList}">
            <td>${bookmarkGroup.id}</td>
            <td>${bookmarkGroup.bookmarkName}</td>
            <td>${bookmarkGroup.sequence}</td>
            <td>${bookmarkGroup.registerDate}</td>
            <td>${bookmarkGroup.updateDate}</td>
            <td style="text-align: center;">
                <button type="button" onclick="updateBookmark(${bookmarkGroup.id})">수정</button>
                <button type="button" onclick="deleteHistory(${bookmarkGroup.id})">삭제</button>
            </td>
    </c:forEach>
</table>
</body>
<script>
    function updateBookmark(bookmarkGroupId, newTitle) {
        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/update_bookmark', true);
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                if (response.success) {
                    alert('북마크가 업데이트되었습니다.');
                    window.location.reload();
                } else {
                    alert('업데이트에 실패했습니다.');
                }
            }
        };
        xhr.send("bookmarkGroupId=" + encodeURIComponent(bookmarkGroupId) + "&newTitle=" + encodeURIComponent(newTitle));
    }
    function deleteBookmark(bookmarkGroupId) {
        if (confirm('정말로 삭제하시겠습니까?')) {
            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/delete_bookmark', true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    window.location.reload();
                }
            };
            xhr.send("bookmarkGroupId=" + encodeURIComponent(bookmarkGroupId));
        }
    }
</script>
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
