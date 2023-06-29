<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--성준추가--%>


<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<div>
    <a href="/">홈</a> |
    <a href="history">위치 히스토리 목록</a> |
    <a href="load_wifi">Open API 와이파이 정보 가져오기</a> |
    <a href="bookmark">즐겨 찾기 보기</a> |
    <a href="bookmark_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<table id="history_tag">
    <thead>
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    </thead>
    <tbody>

    <!-- 저장한 위치 정보가 없을 때 -->
    <tr id="history_info_none">
        <td colspan="5" style="text-align: center">저장한 위치 정보가 없습니다.</td>
    </tr>
    <c:forEach var="history" items="${HistoryList}">
        <tr id="history_info">
            <td>${history.id}</td>
            <td>${history.lat}</td>
            <td>${history.lnt}</td>
            <td>${history.register_date}</td>
            <td>
                <form action="delete_history" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                    <input type="hidden" name="historyId" value="${history.id}">
                    <button type="submit">삭제</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>

<style>
    #history_tag {
        margin-top: 10px;
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #history_tag td, #history_tag th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #history_tag tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #history_tag tr:hover {
        background-color: #ddd;
    }

    #history_tag th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
    }
</style>
<script>
    // JavaScript로 테이블 표시 및 숨김 제어
    const historyInfoNone = document.getElementById("history_info_none");
    const historyInfo = document.getElementById("history_info");

    if (historyInfoNone) {
        // 저장한 위치 정보가 없는 경우
        document.getElementById("history_info").style.display = "none";
    } else {
        // 저장한 위치 정보가 있는 경우
        for (var i = 0; i < historyInfo.length; i++) {
            historyInfo[i].style.display = "1";
        }
    }
</script>

</html>


