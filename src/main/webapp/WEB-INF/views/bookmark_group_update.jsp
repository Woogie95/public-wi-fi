<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title></head>
<body>

<h2>위치 히스토리 목록</h2>
<%@ include file="./category.jsp" %>

<form action="bookmark_update" method="post">
    <input type="hidden" name="bookmark_id" value="${BookmarkGroup.getId()}">

    <table>
        <tr>
            <th>북마크 이름</th>
            <td><input type="text" name="bmk_name" value="${BookmarkGroup.getBookmarkName}"/></td>
        </tr>
        <tr>
            <th>북마크 순서</th>
            <td><input type="text" name="bmk_sequence" value="${BookmarkGroup.getSequence()}" /></td>
        </tr>

    </table>
    <div class = "redirect">
        <a href="bookmark_group">돌아가기</a>&nbsp;|<input type="submit" value="수정하기" id="enroll_btn" />
    </div>
</form>
</body>
</html>
