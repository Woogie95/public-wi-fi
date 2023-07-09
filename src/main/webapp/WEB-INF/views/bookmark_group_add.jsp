<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

<form action="bookmark_group_add" method="post">
    <table>
        <tr>
            <th>북마크 이름</th>
            <td>
                <label>
                    <input type="text" name="bookmark_name"/>
                </label>
            </td>
        </tr>
        <tr>
            <th>순서</th>
            <td>
                <label>
                    <input type="text" name="bookmark_sequence"/>
                </label>
            </td>
        </tr>

    </table>
    <input type="submit" value="등록하기" id="btn"/>
</form>
</body>
</html>
