<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="WEB-INF/views/category.jsp" %>

<form action="bookmark_group_add" method="post">
    <table>
        <tr>
            <th>북마크 이름</th>
            <td>
                <label>
                    <input type="text" name="bookmarkGroupName"/>
                </label>
            </td>
        </tr>
        <tr>
            <th>순서</th>
            <td>
                <label>
                    <input type="text" name="bookmarkGroupSequence"/>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <input type="submit" value="추가" onclick="showAlert()"/>
            </td>
        </tr>
    </table>
</form>
</body>

<script>
    function showAlert() {
        alert('북마크 그룹 정보를 추가하였습니다.');
    }
</script>

<style>

    th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #04AA6D;
        color: white;
        width: 300px;
    }

    td {
        padding-top: 12px;
        padding-bottom: 12px;
        width: 80%;
        text-align: left;
        font-size: 20px;
    }

    tr:hover {
        background-color: lightblue;
        cursor: pointer;
    }

    td, th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

</style>
</html>
