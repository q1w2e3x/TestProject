<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        .error {color:red}
    </style>
</head>
<body>
    <h1>Введите необходимые данные</h1>
    <form:form method="POST"
               action="/registration/processForm" modelAttribute="userCandidate">

                Логин: <form:input path="login"/>
                <form:errors path="login" cssClass="error" />
                <br/><br/>
                Пароль: <form:password path="password"/>
                <form:errors path="password" cssClass="error" />
                <br/><br/>
                Почта: <form:input path="email"/>
                <form:errors path="email" cssClass="error" />
                <br/><br/>
                Телефон <form:input path="phone"/>
                <form:errors path="phone" cssClass="error" />
                <br/><br/>
                <input type="submit" value="Подтвердить"/>
    </form:form>
</body>
</html>