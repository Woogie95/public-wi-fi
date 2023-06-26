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
    <a href="bookmark_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<div id="input">
    <label for="latInput">LAT:</label>
    <input type="text" id="latInput" name="lat" value="0.0"/> ,

    <label for="lntInput">LNT:</label>
    <input type="text" id="lntInput" name="lnt" value="0.0"/>

    <button type="button">내 위치 가져오기</button>
    <button type="button">근처 WIFI 정보 보기</button>
</div>

<table id="wifi_tag">
    <thead>
    <tr>
        <th>거리(km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>

    <!-- 테이블 데이터를 동적으로 추가하는 로직을 구현할 수 있습니다 -->
</table>
</body>
<style>
    #input {
        margin-top: 10px;
    }

    #wifi_tag {
        margin-top: 10px;
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #wifi_tag td, #wifi_tag th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #wifi_tag tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #wifi_tag tr:hover {
        background-color: #ddd;
    }

    #wifi_tag th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
    }
</style>
</html>