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
                        <li><a href="about" >Об нас</a></li>
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


        <div class="container" style="background-color:#ADD8E6; border-radius: 15px;" >
            <br>
            <h3 class="text-center">Добро пожаловать на сайт комплекса гостниниц города Байконур</h3>

            <!-- Карусель -->
            <div class="row" >
                <div  class="fotorama" style="height:425px;">
                    <img src="resources/images/4.jpg">
                    <img src="resources/images/5.jpg">
                    <img src="resources/images/6.jpg">

                </div>
            </div>

            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username" /></p>
              
                
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')" >
                <a href="logout">Выйти</a>
            </sec:authorize>
            <br>
            <div class="row" >
                <div class="col-md-1"><p></p></div>
                <div class="col-md-10">
                    <p><strong>У нас есть ряд отличительных особенностей — от повышенного уровня обслуживания и удобств на клубном уровне до уникальных возможностей познавать мир по-настоящему. Специальные предложения составлены с учетом наших особенностей, чтобы побудить гостей вернуться и привлечь тех, кто у нас еще не бывал.
                        </strong>
                    </p>
                    <p><strong>Гостиница 5 звезд в самом центре Москвы
                            «Арарат Парк Хаятт Москва» - ультрасовременная гостиница в Москве международного уровня, специально созданная для взыскательных путешественников, которые ценят эксклюзивность, персонализированный сервис и превосходное качество. Расположена гостиница рядом с Красной</strong> </p>

                    <h4 class="text-center" >ПОБАЛУЙТЕ СЕБЯ</h4>
                    <p class=".text-justify "><strong>
                            На клубном уровне в гостиницах Ritz-Carlton вам будут предложены все услуги и удобства, к которым вы у нас привыкли, но с более персонализированным подходом. Закуски и напитки подаются в течение дня, а личный коньсерж поможет во всем — от заказа столиков в самых популярных ресторанах до смены авиабилетов. При использовании пакета «Побалуйте себя» пребывание на клубном уровне продлевается на одну ночь бесплатно. В пакет «Побалуйте себя» входит:
                            проживание на уровне клуба Ritz-Carlton
                            парковка автомобиля с доставкой или трансфер из аэропорта и обратно (по выбору гостиницы)
                            ежедневный доступ в Интернет в номере
                            одна ночь бесплатно при минимальном сроке проживания (устанавливается в гостинице) 
                            Для просмотра цен и подробностей выберите включенную в программу гостиницу.</strong>
                    </p>

                    <h4 class="text-center .text-danger" >ВОССОЕДИНИТЕСЬ (С КОМФОРТОМ)</h4>
                    <p class=".text-justify "><strong>
                            Вырвитесь из рутины в гостиницу The Ritz-Carlton и воспользуйтесь пакетом, в котором совершенство дополняется роскошным номером, ценным кредитом и бесплатным питанием. В пакет «Воссоединитесь» входит:
                            проживание
                            гостиничный (курортный) кредит*
                            на курортах ежедневно подается американский завтрак
                            на двоих в отдельных ресторанах гостиницы*
                            Выбрать гостиницу
                            Завтрак подается ежедневно в отдельных ресторанах гостиницы, недействителен в городских гостиницах и при обслуживании в номерах. Кредит зависит от гостиницы, применяется за ночь проживания, не имеет денежной стоимости и не засчитывается при оплате за проживание, спиртные напитки и посторонние услуги.

                            Необходим минимальный срок проживания. Кредит зависит от гостиницы, применяется за ночь проживания, не имеет денежной стоимости и не засчитывается при оплате за проживание, спиртные напитки и посторонние услуги. Проживанием считаются следующие подряд ночи, проведенные в одной и той же гостинице, вне зависимости от мероприятий по выезду (заезду).</strong></p>

                </div>
                <div class="col-md-1"></div>
            </div>


        </div>

        <br>

        <!-- Низ страницы -->
        <div class="navbar navbar-default navbar-bottom"></div>
    </body>
</html>