<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by Administrator on 2020/11/17by IntelliJ IDEA.
  User: Administrator Date: 2020/11/17 Time: 12:51
  DateTime:2020/11/17 12:51
  Description:
  Others:
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.3.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <%--    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
</head>
<body>
<input type="text" id="send">
<input type="button" id="put" value="发送">
<div id="Info"></div>
</body>
<script>

    $("#put").click(function () {
        let text = $("#send").val();
        let answer = "";
        //alert("text" + text);
        let question = [];
        question.push({
            question: text,
            answer: answer
        });
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/chat/answer",
            data: JSON.stringify(question),
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                //alert("数据回来了！");
                //alert("data" + data);
                $("#Info").val("");
                $("#Info").append(data);

            }
        });
    });
</script>
</html>
