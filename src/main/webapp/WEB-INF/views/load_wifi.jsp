<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<div id="content">
    <%
        long totalWifiCount = (long) request.getAttribute("totalWifiCount");
    %>
    <h1><%= totalWifiCount %> 개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
</div>
<a id="link" href="/">홈으로 가기</a>
</body>

<style>
    #content {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    #link {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
</html>
