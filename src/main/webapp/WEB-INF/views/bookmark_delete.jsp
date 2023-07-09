<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

<h4>북마크를 삭제하시겠습니까?</h4>
<form action="bookmark_delete" method="post" id="delete_form">
    <input type="hidden" name="bookmarkId" value="${bookmark.getId()}">
    <table>
        <tr>
            <th>북마크 이름</th>
            <td>
                ${bookmark.getBookmarkName()}
            </td>
        </tr>
        <tr>
            <th>와이파이명</th>
            <td>
                ${bookmark.getMainNm()}
            </td>
        </tr>
        <tr>
            <th>등록일자</th>
            <td>
                ${bookmark.getRegisterDate()}
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <a href="bookmark">돌아가기</a>&nbsp;|
                <input type="submit" value="삭제" onclick="showAlert()"/>
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function showAlert() {
        alert('북마크 그룹 정보를 삭제하였습니다.');
    }
</script>

<style>
    #delete_form {
        margin-top: 10px;
    }

    th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
        width: 300px;
    }

    td {
        padding-top: 12px;
        padding-bottom: 12px;
        width: 80%;
        text-align: left;
        font-size: 15px;
    }

    tr:hover {
        background-color: lightblue;
        cursor: pointer;
    }

    td, th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

</style>

</html>
