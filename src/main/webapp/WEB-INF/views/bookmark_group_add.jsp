<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1><%="위치 히스토리 목록"%>
</h1>

<div id="category">
    <a href="home.jsp">홈</a> |
    <a href="history.jsp">위치 히스토리 목록</a> |
    <a href="load_wifi.jsp">Open API 와이파이 정보 가져오기</a> |
    <a href="favorites.jsp">즐겨 찾기 보기</a> |
    <a href="bookmark_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<table id="name_table1">
    <thead>
    <tr>
        <th>북마크 이름</th>
        <label for="bookmark_name"></label>
        <input type="text" id="bookmark_name"/>
    </tr>
    </thead>
</table>

<table id="name_table2">
    <thead>
    <tr>
        <th>순서</th>
        <label for="sequence"></label>
        <input type="text" id="sequence"/>
    </tr>
    </thead>
</table>
<button type="button">추가</button>
</body>
<style>
    #category {
        margin-top: 10px;
    }

    #category {
        margin-top: 10px;
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #name_table1 th, #name_table2 th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #name_table1 tr:nth-child(even), #name_table2 tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    #name_table1 tr:hover, #name_table2 tr:hover {
        background-color: #ddd;
    }

    #name_table1 th, #name_table2 th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
    }
</style>

</html>
