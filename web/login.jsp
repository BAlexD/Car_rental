<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
    <div class="card-panel" >
        <div class="row">
            <form class="col l6 s12 offset-l3" method="POST"align="center">
                <div class="row" >
                    <div class="input-field col s12">
                        <input name="email" id="email" class="validate" required="required" />
                        <label for="email">юзернейм</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12" >
                        <input name="password" id="password" type="password" class="validate" required="required" />
                        <label for="password">пароль</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light right grey" type="submit" align="center">Войти
                </button>
                <a class="btn" href="/register">Зарегистрироваться</a>
            </form>
        </div>
    </div>

<table class="table">
    <h>Помощь входа</h>
    <p>В юзернейм вводить юзернейм, в пароль - пароль. почта немного не работает - ругается sql на неверный синтаксис</p>
    <tr>
        <th>user_id</th>
        <th>login</th>
        <th>username</th>
        <th>pass</th>
    </tr>
    <c:forEach items="${usersC.getAll()}" var="i">
        <tr>
            <td>${i.getID()}</td>
            <td>${i.getLogin()}</td>
            <td>${i.getUsername()}</td>
            <td>${i.getPassword()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>