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
<div class="card-panel">
    <div class="row">
        <t:message />
        <form class="col l6 s12 offset-l3" method="POST">
            <div class="row">
                <div class="input-field col s6">
                    <input name="username" id="username" type="text" class="validate" required="required" />
                    <label for="username">Username</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input name="email" id="email" type="email" class="validate" required="required" />
                    <label for="email">Email</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input name="password" id="password" type="password" class="validate" required="required" />
                    <label for="password">Password</label>
                </div>
            </div>

            <button class="btn waves-effect waves-light right grey" type="submit">Принять
            </button>
        </form>
    </div>
</div>
</body>
</html>
