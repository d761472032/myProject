$(document).ready(function () {
    $.ajax(
        {
            type:"GET",
            url:"http://localhost:8080/mySpringMVC/springmvc/checkKey.action?key=123",
            dataType:"json",
            async:false,
            success:function (data) {
                var d = eval(data);
                alert(a[0]);
            },
            error:function () {
                alert("error!");
            }
        }
    );
});