<%--
  Created by IntelliJ IDEA.
  User: MASTER
  Date: 2022-05-16
  Time: 오후 6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    <!--
    #wrap{
        background-color: #FCEEDC;
        width:100%;
        height:100%;
        position:relative;
    }
    #homeicon{
        width: 83px;
        height: 77px;
        position: absolute;
        left: 1%;
        top: 1%;
    }
    #formDiv{
        position: absolute;
        left: 45%;
        top:42%;
        width:420px;
        height:300px;
        margin-left:-210px;
        margin-top:-150px;
    }
    .formIn{
        padding: 15px;
        background-color: #FCEEDC;
        color: black;
        font-weight: bold;
        text-align: center;
    }
    #subBtn{
        position: relative;
    }
    -->
</style>

<html>
<head>
    <title>Title</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        $("#btnLogin").click(function() {
             var userId=$("#userID").val();
             var userPW=$("#userPW").val();

             if(userID == ""){
                  alert("아이디를 입력하세요");
                  $("#userID").focus(); //입력포커스 이동
                  return;  }

            if(userPW==""){
                 alert("비밀번호를 입력하세요");
                 $("#userPW").focus();
                  return;  }


            <%--login_check.do로 이동 -> @RequestMapping("login_check.do")메소드 실행--%>
             document.loginForm.action= "${path}/member/login_check.do";
             document.loginForm.submit();
         });
    });
</script
<body>
<div id="wrap">
    <a href="index.jsp"><img id="homeIcon" src="classpath:/images/homeIcon.png"/></a>m>

    <form name="loginForm" method="port" id="formDiv">
        <table class="formIn">
            <tr>
                <td>ID</td>
                <td><input type="userId" name="userId">
            </tr>
            <tr>
                <td>PW</td>
                <td><input type="password" name="userPW" id="userPW"></td>
            </tr>
            <tr>
                <td align="center">
                <button type="button" id="btnLogin">로그인</button>
                <c:if test="${msg == 'error'}">
                    <div style="color:red;">아이디와 비밀번호가 일치하지 않습니다.</div>
                <c:if test="${msg == 'logout'}">
                    <div style="color:red;"> 로그아웃 되었습니다.</div>
            </tr>
        </table>
    </form>
</div>
</body>
</html>