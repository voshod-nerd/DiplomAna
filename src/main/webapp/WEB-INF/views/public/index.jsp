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
                    <a href="/vc" class="navbar-brand">Главная</a>
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


        <div class="container" style="background-color:#ADD8E6; border-radius: 15px;" >
            <br>
            <h3 class="text-center">Гостиничный комплекс ФГУП "ГКНПЦ имени М.В. Хруничева"</h3>

            <!-- Карусель -->
            <div class="row" >
                <div  class="fotorama" style="height:425px;">
                    <img src="resources/images/25.jpg">
                    <img src="resources/images/4.jpg">
                    <img src="resources/images/5.jpg">
                    <img src="resources/images/6.jpg">

                </div>
            </div>

          
            <br>
            <div class="row" >
                <div class="col-md-1"><p></p></div>
                <div class="col-md-10">
                    <h4 class="text-center"><strong>Добро пожаловать, на сайт гостиничного комплекса ФГУП "ГКНПЦ имени М.В. Хруничева"!</strong></h4>
                    <p class="text-justify"> 
На данном сайте вы, дорогие наши клиенты, можете забронировать номера, на любой вкус! На Ваш выбор предоставляются четыре типа номеров: эконом, стандарт, комфорт и люкс.
Гостиничный комплекс расположен на площадке 95, комплекса Байконур. Комплекс включает в себя семь гостиниц: №7, №9, №311, Фили, Комета, Космос и Полет.
Гостиницы: №7, №9 и №311 оборудованы таким образом, что проживающие сами могут приготовить себе еду (так как услуга питание не оказывается в данных гостиницах), помимо общих кухонь, имеются общие душевые комнаты и туалеты, данные комнаты имеются на каждом этаже. 
В каждой из гостиниц: Фили, Комета и Космос, расположен бар-ресторан, имеется хорошо оборудованный спортзал для поддержания себя в форме, сауна и бассейн для отдыха и TV-room (комната для просмотра фильмов и игры в видеоигры). 
В гостинице Полет, имеется ресторан, где Вы можете перекусить или купить прохладительные напитки.
</p>
                </div>
                <div class="col-md-1"></div>
            </div>


        </div>

        <br>

        <!-- Низ страницы -->
        <div class="navbar navbar-default navbar-bottom"></div>
    </body>
</html>