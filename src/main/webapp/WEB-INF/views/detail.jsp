<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>와이파이 정보 구하기</h1>

<%@ include file="./category.jsp" %>

<form action="bookmark" method="post">
    <label>
        <select name="bookmark_select">
            <option value="bookmark_group_select">북마크 그룹 이름 선택</option>
            <c:forEach var="bookmarkGroupList" items="${bookmarkGroupList}">
                <option value="${bookmarkGroupList.getBookmarkName()}">${bookmarkGroupList.getBookmarkName()}</option>
            </c:forEach>
        </select>
    </label>
    <input type="hidden" name="mainNm" value="${wifiInfo.getMainNm()}">
    <input type="submit" value="즐겨찾기 추가하기"/>
</form>
<%
    String distance = request.getParameter("distance");
%>
<table>
    <tr>
        <th>거리(km)</th>
        <td><%=distance%>
        </td>
    </tr>
    <tr>
        <th>관리번호</th>
        <td>${wifiInfo.getMgrNo()}</td>
    </tr>
    <tr>
        <th>자치구</th>
        <td>${wifiInfo.getWrdofc()}</td>
    </tr>
    <tr>
        <th>와이파이명</th>
        <td>${wifiInfo.getMainNm()}</td>
    </tr>
    <tr>
        <th>도로명주소</th>
        <td>${wifiInfo.getAddress1()}</td>
    </tr>
    <tr>
        <th>상세주소</th>
        <td>${wifiInfo.getAddress2()}</td>
    </tr>
    <tr>
        <th>설치위치(층)</th>
        <td>${wifiInfo.getInstlFloor()}</td>
    </tr>
    <tr>
        <th>설치유형</th>
        <td>${wifiInfo.getInstlTy()}</td>
    </tr>
    <tr>
        <th>설치기관</th>
        <td>${wifiInfo.getInstlMby()}</td>
    </tr>
    <tr>
        <th>서비스구분</th>
        <td>${wifiInfo.getSvcse()}</td>
    </tr>
    <tr>
        <th>망종류</th>
        <td>${wifiInfo.getCmcwr()}</td>
    </tr>
    <tr>
        <th>설치년도</th>
        <td>${wifiInfo.getCnstcYear()}</td>
    </tr>
    <tr>
        <th>실내외구분</th>
        <td>${wifiInfo.getInoutDoor()}</td>
    </tr>
    <tr>
        <th>WIFI접속환경</th>
        <td>${wifiInfo.getRemars3()}</td>
    </tr>
    <tr>
        <th>X좌표</th>
        <td>${wifiInfo.getLat()}</td>
    </tr>
    <tr>
        <th>Y좌표</th>
        <td>${wifiInfo.getLnt()}</td>
    </tr>
    <tr>
        <th>작업일자</th>
        <td>${wifiInfo.getWorkDttm()}</td>
    </tr>
</table>

</body>
<style>

    th{
        background-color: #00ff00;
        color:black;
        width : 30%;
        font-size: 15px;
    }
    td{
        width: 70%;
        text-align:left;
        font-size: 15px;
    }
    tr:hover{
        background-color: lightblue;
        cursor : pointer;
    }

</style>
</html>
