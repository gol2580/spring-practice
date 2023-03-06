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
        $("#btnSpecIn").click(function() {

            <%--!!예외처리 하자!!--%>

            <%--specIn.do로 이동 -> @RequestMapping("specInExec.do")를 매핑한 메소드 실행--%>
            <%--http://localhost:8080/charIn/charInExec.do?nickname=gol&selectServer=%EB%A3%A8%EB%82%98&level=1&status=1&force=1--%>
             document.specInForm.action= "${path}/specIn/specInExec.do";
             document.specInForm.submit();
         });
    });
</script

<body>
<div id="wrap">
    <a href="/home"><img id="homeicon" src="/images/homeIcon.png"/></a>



    <form name="specInForm" method="get" id="formDiv">
        <table class="formIn">
             <div class="formIn">보스 선택
                  <input name="bossName" type="radio" value="lucid"/>루시드
                  <input name="bossName" type="radio" value="demian"/>데미안
                  <input name="bossName" type="radio" value="djunkel"/>듄켈
                  <input name="bossName" type="radio" value="will"/>윌
                  <input name="bossName" type="radio" value="hilla"/>힐라
              </div>
              <div class="formIn">파티원 수
                  <input name="numOfChar" type="number" min="1" max="3"/>
              </div>
              <div class="formIn"> 서버 선택
                  <input name="sserver" type="radio" value="루나"/>루나
                  <input name="sserver" type="radio" value="스카니아"/>스카니아
                  <input name="sserver" type="radio" value="엘리시움"/>엘리시움
              </div>
              <div class="formIn"> 레벨 입력
                  <input name="minLevel" type="number" min="0" max="300"/>
              </div>
              <div class="formIn"> 주스텟 입력
                  <input name="minStatus" type="number" min="0" max="100000"/>
              </div>
              <div class="formIn"> 포스 입력
                   <input name="minForce" type="number" min="0" max="1320"/>
              </div>

            <button type="button" id="btnSpecIn">로그인</button>
        </table>
    </form>
</div>
</body>
</html>