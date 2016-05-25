<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Бронирование номеров</title>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="resources/js/jquery-2.2.2.min.js"></script>
        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- css code for slider  -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="resources/js/bootstrap.min.js" ></script>
        <!-- Fotorama -->
        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB --> 

        <!-- Angular JS -->
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular.min.js" ></script>
    </head>

    <body ng-app="myapp" ng-init="fetchDepartment()" >
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="../" class="navbar-brand">Главная</a>
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse" id="navbar-main">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Мы предлагаем<span class="caret"></span></a>
                            <ul class="dropdown-menu" aria-labelledby="themes">
                                <li><a href="reservation">Бронирование номеров</a></li>
                                <li class="divider"></li>
                                <li><a href="../cerulean/">Отмена брони</a></li>
                                <li class="divider"></li>
                                <li><a href="../cosmo/">Специальное предложение</a></li>  
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="regclient" target="_blank">Регистрация</a></li>
                        <li><a href="" target="_blank">Контакты</a></li>
                        <li><a href="" target="_blank">Об отелях</a></li>
                        <li><a href="home" target="_blank">Корпоративный сайт</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>

        <div class="container" style="background-color:#ADD8E6; border-radius: 15px;">

            <form>
                 <h3 class="text-center">Заполните регистрационные данные</h3>
                <label >Ваше ФИО</label>
                <input class="form-control" type="text" />
                <label >Дата рождения</label>
                <input class="form-control " text="date"  />
                <label>Ваш пол</label>
                <select class="form-control ">
                    <option value="M">Мужской</option>
                    <option value="Ж">Женский</option>
                </select>

                <label >Серия паспорта</label>
                <input class="form-control "type="text"/>
                <label >Номер паспорта</label>
                <input class="form-control "type="text"/>
                <label >Организация выдачи паспорта</label>
                <input class="form-control " type="text"/>
                <label >Дата выдачи</label>
                <input class="form-control " type="date"/>
                <label >Срок окончания</label>
                <input class="form-control" type="date"/>



                <label >Ваша летная программа</label>
                <select class="form-control " name="programma">
                    <c:forEach var="dept" items="${listProg}" varStatus="ls">
                        <option>${dept.name}</option>                           
                    </c:forEach>    
                </select>
                <label >Ваша организация</label>
                <select class="form-control " >
                    <c:forEach var="org" items="${listOrg}" varStatus="orgs">
                        <option>${org.name}</option>                           
                    </c:forEach>    
                </select>

                <br>
                <h4>Данные для входа</h4>
                <br>
                <label >Ваш логин</label>
                <input class="form-control " type="text"/>
                <label >Пароль</label>
                <input class="form-control " type="password"/>
                <label >Пароль повторно</label>
                <input class="form-control " type="password"/>
                <label >Электронная почта</label>
                 <input class="form-control " type="email"/>


                <button  class="form-control" type="submit">Регистрация</button>
                <form>

      
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
        </sec:authorize>
                    
                    </div>


                    </body>
                    </html>