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
        $("#btnCharIn").click(function() {
            <%--id가 ID인 input의 값--%>
             var nickname=$("input#nickname").val();
             var server=$("input#selectServer").val();

             if(nickname == ""){
                  alert("아이디를 입력하세요");
                  $("input#nickname").focus(); //입력포커스 이동
                  return;  }

            if(server==""){
                 alert("비밀번호를 입력하세요");
                 $("input#selectServer").focus();
                  return;  }


            <%--charIn.do로 이동 -> @RequestMapping("charExec.do")를 매핑한 메소드 실행--%>
            <%--http://localhost:8080/charIn/charInExec.do?nickname=gol&selectServer=%EB%A3%A8%EB%82%98&level=1&status=1&force=1--%>
             document.charInForm.action= "${path}/charIn/charInExec.do";
             document.charInForm.submit();
         });
    });
</script>

<body>
<%--<c:if test="${nickname == 'error'}">
         <div style="color:red;"> 로그아웃 되었습니다.</div>
</c:if>--%>
<div id="wrap">
    <a href="/home"><img id="homeicon" src="/images/homeIcon.png"/></a>



    <form name="charInForm" method="get" id="formDiv">
        <table class="formIn">
            <div class="formIn">닉네임 입력
                <input name="nickname" id="nickname" type="text"/>
            </div>
            <div class="formIn"> 서버 선택
                <input id="server" name="server" type="radio" value="루나"/>루나
                <input id="server" name="server" type="radio" value="스카니아"/>스카니아
                <input id="server" name="server" type="radio" value="엘리시움"/>엘리시움
            </div>
            <div class="formIn"> 레벨 입력
                <input id="level" name="level" type="number" min="0" max="300"/>
            </div>
            <div class="formIn"> 주스텟 입력
                <input id="status "name="status" type="number" min="0" max="100000"/>
            </div>
            <div class="formIn"> 포스 입력
                <input id="force" name="force" type="number" min="0" max="1320"/>
            </div>
            <button type="button" id="btnCharIn">등록</button>
        </table>
    </form>
</div>
</body>
</html>
