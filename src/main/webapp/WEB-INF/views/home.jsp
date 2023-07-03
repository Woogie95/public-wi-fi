<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>와이파이 정보 구하기</h1>

<div>
    <a href="">홈</a> |
    <a href="history">위치 히스토리 목록</a> |
    <a href="load_wifi">Open API 와이파이 정보 가져오기</a> |
    <a href="bookmark.jsp">즐겨 찾기 보기</a> |
    <a href="bookmark_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<form action="" method="post">
    <div id="input">
        <label for="latInput">LAT:</label>
        <input type="text" id="latInput" name="lat" value="${latitude != null ? latitude : '0.0'}"/> ,
        <label for="lntInput">LNT:</label>
        <input type="text" id="lntInput" name="lnt" value="${longitude != null ? longitude : '0.0'}"/>
        <button type="button" onclick="getLocationAndSend()">내 위치 가져오기</button>
        <button type="button" onclick="getNearestWifiInfoSend()">근처 WIFI 정보 보기</button>
    </div>
</form>
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

    <tbody>
    <c:choose>
    <c:when test="${not empty wifiInfoList}">
    <c:forEach var="wifiInfoList" items="${wifiInfoList}">
    <tr>
        <td>${ wifiInfoList.getX_SWIFI_DIST() }</td>
        <td>${ wifiInfoList.getX_SWIFI_MGR_NO()}</td>
        <td>${ wifiInfoList.getX_SWIFI_WRDOFC() }</td>
        <td>
            <a href="detail_page.do?X_SWIFI_MGR_NO=${wifiInfoList.getX_SWIFI_MGR_NO() }&X_SWIFI_DIST=${ wifiInfoList.getX_SWIFI_DIST() }">${ wifiInfoList.getX_SWIFI_MAIN_NM() }</a>
        </td> <!-- 와이파이명 -->
        <td>${ wifiInfoList.getX_SWIFI_ADRES1() }</td> <!-- 도로명주소 -->
        <td>${ wifiInfoList.getX_SWIFI_ADRES2() }</td> <!-- 상세주소 -->
        <td>${ wifiInfoList.getX_SWIFI_INSTL_FLOOR() }</td> <!-- 설치위치(층) -->
        <td>${ wifiInfoList.getX_SWIFI_INSTL_TY() }</td> <!-- 설치유형 -->
        <td>${ wifiInfoList.getX_SWIFI_INSTL_MBY() }</td> <!-- 설치기관 -->
        <td>${ wifiInfoList.getX_SWIFI_SVC_SE() }</td> <!-- 서비스구분 -->
        <td>${ wifiInfoList.getX_SWIFI_CMCWR() }</td> <!-- 망종류 -->
        <td>${ wifiInfoList.getX_SWIFI_CNSTC_YEAR() }</td> <!-- 설치년도 -->
        <td>${ wifiInfoList.getX_SWIFI_INOUT_DOOR() }</td> <!-- 실내외구분 -->
        <td>${ wifiInfoList.getX_SWIFI_REMARS3() }</td> <!-- WIF접속환경 -->
        <td>${ wifiInfoList.getLAT() }</td> <!-- X좌표 -->
        <td>${ wifiInfoList.getLNT() }</td> <!-- Y좌표 -->
        <td>${ wifiInfoList.getWORK_DTTM() }</td> <!-- 작업일자 -->
    </tr>
    <tr>
        </c:forEach>
        </c:when>
        <c:otherwise>
    <tr>
        <td colspan="17" style="text-align: center;">위치 정보를 입력한 후에 사용해주세요</td>
    </tr>
    </c:otherwise>
    </c:choose>
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
<script>
    function getLocationAndSend() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(sendLocationToHistory);
        } else {
            alert("위치 정보를 불러올 수 없습니다.");
        }
    }

    // 해당 LAT, LNT 가져와서 HistoryController 로 반환 해주는 기능
    function sendLocationToHistory(position) {
        const latitude = position.coords.latitude;
        const longitude = position.coords.longitude;

        const xhr = new XMLHttpRequest();
        xhr.open("POST", "history", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send("lat=" + latitude + "&lnt=" + longitude);
        document.getElementById('latInput').value = latitude;
        document.getElementById('lntInput').value = longitude;
        document.forms[0].submit();


        // JavaScript 로 정보 있을 때 없을 때 표시 및 숨김 제어
        const wifiListNone = document.getElementById("wifiList_none");
        const wifiInfo = document.getElementById("wifiInfo");

        if (wifiListNone && wifiListNone.length > 0) {
            // 저장한 위치 정보가 없는 경우
            wifiInfo.style.display = "none";
        } else {
            // 저장한 위치 정보가 있는 경우
            wifiInfo.style.display = "table-row";
        }
    }

    function getNearestWifiInfoSend() {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                const wifiInfoList = JSON.parse(xhr.responseText);

                // JavaScript 로 테이블에 WiFi 정보 추가하는 코드 작성
                const tbody = document.querySelector("#wifi_tag tbody");
                tbody.innerHTML = ""; // 기존 데이터 초기화

                for (let i = 0; i < wifiInfoList.length; i++) {
                    const wifi = wifiInfoList[i];
                    const tr = document.createElement("tr");

                    const distanceTd = document.createElement("td");
                    distanceTd.textContent = wifi.distance;
                    tr.appendChild(distanceTd);

                    // 나머지 필드도 동일하게 작성

                    tbody.appendChild(tr);
                }

                // JavaScript로 정보 있을 때 없을 때 표시 및 숨김 제어
                const wifiListNone = document.getElementById("wifiList_none");
                const wifiInfo = document.getElementById("wifiInfo");

                if (wifiInfoList.length === 0) {
                    // WiFi 정보가 없는 경우
                    wifiListNone.style.display = "table-row";
                    wifiInfo.style.display = "none";
                } else {
                    // WiFi 정보가 있는 경우
                    wifiListNone.style.display = "none";
                    wifiInfo.style.display = "table-row";
                }
            }
        };
        xhr.send();
    }

</script>
</html>