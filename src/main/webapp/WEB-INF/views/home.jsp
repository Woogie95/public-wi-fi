<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>와이파이 정보 구하기</h1>

<%@ include file="./category.jsp" %>

<form id="location-form" action="home" method="post">
    <div id="input">
        <label for="lat">LAT:</label>
        <input type="text" id="lat" name="lat" value="${latitude != null ? latitude : '0.0'}"/> ,
        <label for="lnt">LNT:</label>
        <input type="text" id="lnt" name="lnt" value="${longitude != null ? longitude : '0.0'}"/>
        <input type="button" value="내 위치 가져오기" id="myLocation"/>
        <input type="submit" value="근처 WIFI 정보 보기" id="nearWifiInfo"/>
    </div>
</form>
<div id="wifiInfoTable">
    <table id="wifi_tag">
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
        <c:choose>
            <c:when test="${not empty wifiInfoList}">
                <c:forEach var="wifiInfo" items="${wifiInfoList}">
                    <tr>
                        <td>${wifiInfo.getDistance()}</td>
                        <td>${wifiInfo.getMgrNo()}</td>
                        <td>${wifiInfo.getWrdofc()}</td>
                        <td>
                            <a href="detail_page.do?X_SWIFI_MGR_NO=${wifiDetail.getX_SWIFI_MGR_NO() }&X_SWIFI_DIST=${ wifiDetail.getX_SWIFI_DIST() }">${ wifiDetail.getX_SWIFI_MAIN_NM() }</a>
                        </td>
                        <td>${wifiInfo.getAddress1()}</td>
                        <td>${wifiInfo.getAddress2()}</td>
                        <td>${wifiInfo.getInstlFloor()}</td>
                        <td>${wifiInfo.getInstlTy()}</td>
                        <td>${wifiInfo.getInstlMby()}</td>
                        <td>${wifiInfo.getSvcSe()}</td>
                        <td>${wifiInfo.getCmcwr()}</td>
                        <td>${wifiInfo.getCnstcYear()}</td>
                        <td>${wifiInfo.getInoutDoor()}</td>
                        <td>${wifiInfo.getRemars3()}</td>
                        <td>${wifiInfo.getLat()}</td>
                        <td>${wifiInfo.getLnt()}</td>
                        <td>${wifiInfo.getWorkDttm()}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="17" style="text-align: center;">위치 정보를 입력한 후에 사용해주세요</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>
</body>

<script>
    $(document).ready(function () {

        $("#myLocation").click(function () {
            if (navigator.permissions) {
                navigator.permissions.query({name: 'geolocation'}).then(function (result) {
                    if (result.state === 'granted') {
                        navigator.geolocation.getCurrentPosition(function (position) {
                            getLocation(position);
                        });
                    } else if (result.state === 'prompt') {
                        navigator.geolocation.getCurrentPosition(function (position) {
                            getLocation(position);
                        });
                    } else {
                        showErrorMessage("위치 정보가 없습니다.");
                    }
                });
            } else if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (position) {
                    getLocation(position);
                });
            } else {
                showErrorMessage("위치 정보가 없습니다.");
            }
        });

        function getLocation(position) {
            const latitude = position.coords.latitude;
            const longitude = position.coords.longitude;

            $("#lat").val(latitude);
            $("#lnt").val(longitude);

        }

        function showErrorMessage(message) {
            $("#error-message").text(message);
            $("#error-container").show();
        }
    });
</script>

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