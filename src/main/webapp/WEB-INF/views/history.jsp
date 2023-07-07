<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

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
    <c:if test="${empty history}">
        <tr id="history_info_none">
            <td colspan="5" style="text-align: center">저장한 위치 정보가 없습니다.</td>
        </tr>
    </c:if>
    <c:forEach var="history" items="${requestScope.history}">
        <tr id="history_info">
            <td>${history.id}</td>
            <td>${history.lat}</td>
            <td>${history.lnt}</td>
            <td>${history.registerDate}</td>

            <td style="text-align: center;">
                <button type="button" onclick="deleteHistory(${history.id})">삭제</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>


<script>
    const wifiInfoListNone = document.getElementById("wifiInfoList_none");
    const wifiInList = document.getElementById("wifiInfoList");

    // 수정된 부분: wifiInfoListNone 또는 wifiInList 가 null 인 경우에 대한 조건 추가
    if (wifiInfoListNone.length > 0) {
        // 저장한 위치 정보가 없는 경우
        wifiInList.style.display = "none";
    } else {
        // 저장한 위치 정보가 있는 경우
        wifiInList.style.display = "table-row";
    }

    function deleteHistory(historyId) {
        if (confirm('정말로 삭제하시겠습니까?')) {
            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/delete_history', true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    window.location.reload();
                }
            };
            xhr.send("historyId=" + encodeURIComponent(historyId));
        }
    }

    // home.jsp 로 lat, lnt 보내기
    function sendLocationToHome() {
        let lat = document.getElementById("latInput").value;
        let lnt = document.getElementById("lntInput").value;

        const xhr = new XMLHttpRequest();
        xhr.open("POST", "home.jsp", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send("lat=" + encodeURIComponent(lat) + "&lnt=" + encodeURIComponent(lnt));
    }
</script>

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

</html>


