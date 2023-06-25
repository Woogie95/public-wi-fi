<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1><%="와이파이 정보 구하기"%>
</h1>

<div>
    <a href="home.jsp">홈</a> |
    <a href="history.jsp">위치 히스토리 목록</a> |
    <a href="load_wifi.jsp">Open API 와이파이 정보 가져오기</a> |
    <a href="favorites.jsp">즐겨 찾기 보기</a> |
    <a href="favorites_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<div>
    <label for="mySelect"></label>
    <select id="mySelect">
        <option value="option1">옵션 1</option>
        <option value="option2">옵션 2</option>
        <option value="option3">옵션 3</option>
    </select>
    <button type="button">즐겨찾기 추가하기</button>
</div>
</body>
</html>
