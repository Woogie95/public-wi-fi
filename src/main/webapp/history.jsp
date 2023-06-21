<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String dbUrl = "jdbc:mysql://localhost:3306/project";
    String query = "SELECT * FROM HISTORY";

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(dbUrl, "root", "tjddnr12");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
%>
<!DOCTYPE html>
<html>
<head>
    <title>"와이파이 정보 구하기"</title>
</head>
<body>
<h1><%= "위치 히스토리 목록" %>
</h1>

<div>
    <a href="home.jsp">홈</a> |
    <a href="history.jsp">위치 히스토리 목록</a> |
    <a href="open_api_wifi.jsp">Open API 와이파이 정보 가져오기</a> |
    <a href="bookmark.jsp.jsp">즐겨 찾기 보기</a> |
    <a href="bookmark_group.jsp">즐겨 찾기 그룹 관리</a>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
    </thead>

    <%-- 여기서 반복하는 자바코드 --%>
    <%
        while (rs.next()) {

    %>
    <tr>
        <td><%= rs.getLong("id")%>
        </td>
        <td><%= rs.getString("lat")%>
        </td>
        <td><%= rs.getString("lnt")%>
        </td>
        <td><%= rs.getDate("registerDate")%>></td>
        <td>
            <form action="deleteServlet" method="post">
                <input type="hidden" name="id" value="<%= rs.getLong("id") %>">
                <button type="submit" onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>


</table>


</body>
</html>

<%
    rs.close();
    st.close();
    conn.close();
%>
