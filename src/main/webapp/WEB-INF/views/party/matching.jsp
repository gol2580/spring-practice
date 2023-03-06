<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.net.URLEncoder"%>
<% request.setCharacterEncoding("utf-8"); %>

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

        #table{
            position: absolute;
            left: 10%;
            top:6%;
            width:80%;
        }
        th{
            border-bottom: 1px solid #ccc;
            padding: 5px;
            background-color: #F58207;
            color: #FCEEDC;
            font-weight: bold;
            text-align: center;
        }
        td{
            text-align: center;
            border-bottom: 1px solid #ccc;
            padding: 3px;
            font-weight: bold;
        }

    -->
</style>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        $("#btnMatching").click(function() {
            var url='${path}/matching/matchingExec.do';
            var var1 =$("#btnMatching").val();
            var var2 =$("#bossName").val();
            let param = {'leaderName':var1, 'bossName':var2};

            alert(JSON.stringify(param));

            $.ajax({
                url: url,
                method: "POST",
                data: JSON.stringify(param),
                dataType: 'json',
                processData: false,
                contentType:'application/json; charset:UTF-8',
                async:false,
                success: function () {
                    console.log("completed!");
                },
                error: function (request,error) {
                    alert("error")
                }
            });



         });
    });
</script>

<body>
    <c:choose>
        <c:when test="${success=='success'}">
            alert("매칭에 성공했습니다! ${userArray} \n ${server}서버 \n ${bossName}" )
        </c:when>
        <c:when test="${error=='error'}">
            alert("매칭에 실패했습니다. 조건에 해당하는 파티원이 존재하지 않습니다.")
        </c:when>
    </c:choose>
    <div id="wrap">
        <a href="/home"><img id="homeicon" src="/images/homeIcon.png"/></a>
        <table id="table">
            <thead>
                <tr>
                    <th>보스</th>
                    <th>파티원 수</th>
                    <th>서버</th>
                    <th>레벨</th>
                    <th>스텟</th>
                    <th>포스</th>
                    <th>버튼</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${fn:length(specList) !=0 }">
                        <c:forEach var="item" items="${specList}" varStatus="status">
                                <tr>
                                    <td><input type="hidden" id="bossName" value="${item.bossName}"/><c:out value="${item.bossName}" /></td>
                                    <td><c:out value="${item.numOfChar}" /></td>
                                    <td><c:out value="${item.sserver}" /></td>
                                    <td><c:out value="${item.minLevel}" /></td>
                                    <td><c:out value="${item.minStatus}" /></td>
                                    <td><c:out value="${item.minForce}" /></td>
                                    <td>
                                        <button value="${item.leaderName}" id="btnMatching">GO</button>
                                    </td>
                                </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                         <tr>
                            <td colspan="4" >조회된 정보가 없습니다.</td>
                         </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>

        </table>
    </div>
</body>
</html>
