<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

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

    <body ng-app="myapp"  >
     <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="/vc" class="navbar-brand">Главная</a>
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
                                 <li><a href="reservation">Отмена бронирования</a></li>
                                
                               
                                
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                       
                        <li><a href="contact" >Контакты</a></li>
                       
                        <li><a href="home" >Корпоративный сайт</a></li>
                        <li> 
                            <sec:authorize access="isAuthenticated()">
                                   <a href="logout">Выйти</a>
                            </sec:authorize>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>

        <div class="container" style="background-color:#ADD8E6; border-radius: 15px;">

            <form action="regsuc" method="post">
                 <h3 class="text-center">Заполните регистрационные данные представителя организации</h3>
                <label >Ваше ФИО</label>
                <input class="form-control" path="fio" name="fio" type="text" />

                <label >Ваша организация</label>
                <select class="form-control " name="org" >
                    <c:forEach var="org" items="${listOrg}"   varStatus="orgs">
                        <option>${org.name}</option>                           
                    </c:forEach>    
                </select>

                <br>
                <h4 class="text-center">Данные для входа</h4>
                <br>
                <label >Ваш логин</label>
                <input class="form-control " path="username" name="username" type="text"/>
                <label >Пароль</label>
                <input class="form-control " path="password" name="password" type="password"/>
                <label >Пароль повторно</label>
                <input class="form-control " type="password"/>
              
                  <p></p>

                <button  class="btn btn-primary btn-block" type="submit">Регистрация</button>
                <p></p>
                </form>

      
       
                    
                    </div>


                    </body>
                    </html>