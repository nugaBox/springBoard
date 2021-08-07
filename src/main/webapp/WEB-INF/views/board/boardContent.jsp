<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>board</title>
    <%@ include file="/WEB-INF/views/layout/header.jsp"%>

</head>
<body>
<article>
    <div class="container" role="main">
        <h2>board Content</h2>

        <div class="bg-white rounded shadow-sm">
            <div class="board_title"><c:out value="${boardContent.title}"/></div>
            <div class="board_info_box">
                <span class="board_author"><c:out value="${boardContent.reg_id}"/>,</span><span class="board_date"><c:out value="${boardContent.reg_dt}"/></span>
            </div>
            <div class="board_content">${boardContent.content}</div>
            <div class="board_tag">TAG : <c:out value="${boardContent.tag}"/></div>
        </div>

        <div style="margin-top : 20px">
            <button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
            <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
        </div>
    </div>

</article>
<script>
    //목록으로 이동 이벤트
    $(document).on('click', '#btnList', function(){
        location.href = "${pageContext.request.contextPath}/board/getBoardList";
    });

    //수정 버튼 클릭 이벤트
    $(document).on('click', '#btnUpdate', function(){
        var url = "${pageContext.request.contextPath}/board/editForm";
        url = url + "?bid="+${boardContent.bid};
        url = url + "&mode=edit";
        location.href = url;
    });

    //삭제 버튼 클릭 이벤트
    $(document).on('click', '#btnDelete', function(){
        var url = "${pageContext.request.contextPath}/board/deleteBoard";
        url = url + "?bid=" + ${boardContent.bid};
        location.href = url;
    });
</script>
</body>
</html>