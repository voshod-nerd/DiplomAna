<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>

<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Оплата бронирования</title>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="resources/js/jquery-2.2.2.min.js"></script>
        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- css code for slider  -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="resources/js/bootstrap.min.js"></script>
        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB --> 


        <!-- Angular JS -->
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular.min.js" ></script>
</head>
<body>
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
    
    <div class="container" style="background-color:#ADD8E6; border-radius: 15px;" >
        <br> <br>
        <form  action="brona" method="post" >
            <br>
            <p class="text-center"><strong>Внимательно проверьте введенные даннные</strong></p>
         <div class="form-group">
        <label  >Организация бронирующая номер :  ${org}  </label>
        </div>
            
        <div class="form-group">
        <label  >Название гостицы :  ${hotel}  </label>
        </div>
        <div class="form-group">
        <label>Бронируемый номер: ${number} </label>
        </div>
        <div class="form-group">
        <label>Тип номера: ${typenomer} </label>
        </div>
        <div class="form-group">
        <label>Количество мест: ${mest}</label>
        </div>
        <div class="form-group">
        <label> Дата вьезда:</label>
        <fmt:formatDate value="${dateb}" pattern="yyyy-MM-dd" />
        </div>
        <div class="form-group">
        <label>Дата выезда:  </label>
         <fmt:formatDate value="${datee}" pattern="yyyy-MM-dd" />
        </div>
        <div class="form-group">
        <label>Cтоимось предоплаты: ${sumbron}</label>
        </div>
        
        <div style="display:none;"> 
          <input type="text"  path="idnomer" value="${idnomer}" name="idnomer" />
          <fmt:formatDate value="${dateb}"  type="date" var="dateString" pattern="yyyy-MM-dd" />
          <fmt:formatDate value="${datee}"  type="date" var="dateStringb" pattern="yyyy-MM-dd" />
          <input  path="dateb" type="date"  value="${dateString}" name="dateb" />
          <input  path="datee"  type="date" value="${dateStringb}" name="datee" />
          </div>
     
        <div class="form-group">
        <label>Введите ФИО клиента  </label>
        <input class="form-control " type="text" path="fio" placeholder="ФИО клиента" name="fio"  >
        </div>
        <div class="form-group">
        <label>Введите дату рождения клиента</label>
        <input class="form-control "  path="dr" type="date" name="dr"  >
        </div>
        <div class="form-group">
        <label>Введите ваш номер электронного кошелька</label>
         <input class="form-control"  name="electron" type="text" path="electron" placeholder="номер электронного кошелька">
        <br>
        <button   class="btn-primary " type="submit" >Поддвердите бронирование</button>
        </div>
        </form>    
    </div>

</body>
</html>