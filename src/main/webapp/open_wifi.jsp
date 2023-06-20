<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.publicwifi.api.WebRequestUtil" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Open API 와이파이 정보 가져오기</title>
</head>
<body>
<h1>Open API 와이파이 정보 가져오기</h1>

<div>
    <a href="home.jsp">홈으로 가기</a>
</div>

<div>
    <%-- Open API로부터 데이터를 가져오고 처리하는 로직을 구현합니다 --%>
    <%
        String apiUrl = "http://openapi.seoul.go.kr:8088/6a7348784d63686f35345a7370506d/json/TbPublicWifiInfo/1/20";
        String responseData = "";
        try {
            responseData = WebRequestUtil.sendGetRequest(apiUrl);
            // responseData를 원하는 방식으로 처리
            // 데이터를 DB에 저장하고 "n개의 WIFI 정보를 정상적으로 저장하였습니다." 메시지를 표시할 수 있습니다.
        } catch (IOException e) {
            e.printStackTrace();
            // 에러 처리 로직을 추가할 수 있습니다.
        }
    %>

    <p><%= "n개의 WIFI 정보를 정상적으로 저장하였습니다." %>
    </p>
</div>

</body>
</html>
