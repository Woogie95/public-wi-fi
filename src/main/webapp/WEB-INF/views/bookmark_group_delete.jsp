<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>위치 히스토리 목록</h1>

<%@ include file="./category.jsp" %>

<h4>북마크 그룹이름을 삭제하시겠습니까?</h4>
<form action="delete_bookmark" method="post">
    <input type="hidden" name="bookmark_id" value="${bookmarkGroup.getId()}">

    <table>
        <tr>
            <th>북마크 이름</th>
            <td>
                <label>
                    <input type="text" name="bookmark_name" value="${bookmarkGroup.getBookmarkName()}"/>
                </label>
            </td>
        </tr>
        <tr>
            <th>순서</th>
            <td>
                <label>
                    <input type="text" name="bookmark_sequence" value="${bookmarkGroup.getSequence()}"/>
                </label>
            </td>
        </tr>

    </table>
    <div class="redirect">
        <a href="bookmark_list.do">돌아가기</a>&nbsp;|<input type="submit" value="삭제하기" id="enroll_btn"/>
    </div>
</form>
</body>
</html>