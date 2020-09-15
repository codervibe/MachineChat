/*
 * Created by Administrator on 2020/7/21  0021
 * DateTime:2020/07/21 20:41
 * Description:
 * Others:
 */
$("#put").click(function () {
    let text = $("#send").val();
    alert("text"+text);
    let question = new Array();
    question.push({
        text:text,
    });
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/chat/answer",
        data: JSON.stringify(Login),
        contentType: "application/json;charset=utf-8",
        success:function (data) {
            // alert("数据回来了！");
            // alert("data"+data);
            $("#Info").append(data);

        }
    });
});