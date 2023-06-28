<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
    <c:choose>
        <c:when test="${empty HistoryList}">
            <tr>
                <td colspan="5">저장한 위치 정보가 없습니다.</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="history" items="${HistoryList}">
                <tr>
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
        </c:otherwise>
    </c:choose>
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

</script>

</html>


