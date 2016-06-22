<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Сайт комплекса гостиниц Байконура</title>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="resources/js/jquery-2.2.2.min.js"></script>
        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- css code for slider  -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="resources/js/bootstrap.min.js"></script>

        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB --> 

    </head>
    <body>

        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="index" class="navbar-brand">Главная</a>
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse" id="navbar-main">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Мы предлагаем<span class="caret"></span></a>
                                <ul class="dropdown-menu" aria-labelledby="themes">
                                    <li><a href="reservation">Бронирование номеров</a></li>
                                    <li><a href="denaid">Отмена бронирования</a></li>



                                </ul>
                            </li>
                        </ul>
                    </sec:authorize>  

                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="contact" >Контакты</a></li>

                        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_DIRECTOR','ROLE_ZAM')">
                            <li><a href="home" >Корпоративный сайт</a></li>
                            </sec:authorize>  
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
        <br>


        <div class="container" style="background-color:#ADD8E6; border-radius: 15px;" >
            <div class="text-center">
            <h3>Контакты</h3>
            <p><strong>ГНЦП им.М.В Хруничева</strong></p>
            <p><strong>Октябрьская 22</strong></p>
            <p><strong>телефон 8 (336) 4-55-63</strong></p>
            <p><strong>факс 8 (336) 4-55-63</strong></p>
            <p><strong>Комплекс Байконур</strong></p>
            </div>

        </div>

        <br>


    </body>
</html>