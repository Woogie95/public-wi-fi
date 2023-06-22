<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1><%="위치 히스토리 목록"%>
</h1>

<div>
    <a href="home.jsp">홈</a> |
    <a href="history.jsp">위치 히스토리 목록</a> |
    <a href="load_wifi.jsp">Open API 와이파이 정보 가져오기</a> |
    <a href="favorites.jsp">즐겨 찾기 보기</a> |
    <a href="bookmark_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<div>
    <button id="btn-bookmark" type="button">북마크 그룹 이름 추가</button>
</div>
<table id="bookmark_group_tag">
    <thead>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>순서</th>
        <th>등록일자</th>
        <th>수정일자</th>
        <th>비고</th>
    </tr>

    <td>asdasd</td>
    <td>asdasd</td>
    <td>asdasd</td>
    <td>asdasd</td>
    <td>asdasd</td>
    </thead>
    <!-- 테이블 데이터를 동적으로 추가하는 로직을 구현할 수 있습니다 -->
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
