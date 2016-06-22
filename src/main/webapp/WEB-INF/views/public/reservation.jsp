<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
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
        <script src="resources/js/bootstrap.min.js"></script>
        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB --> 


        <!-- Angular JS -->
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular.min.js" ></script>
    </head>

    <body ng-app="myApp"  >
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

        <div class="container"  style="background-color:#ADD8E6; border-radius: 15px;">

            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10"  ng-controller="ControllerReserv as ctrl">       
                    <h4 class="text-center"><strong>Забронируйте себе номер прямо сейчас!</strong></h4>

                    <h4 class="text-center"><strong>Правила бронирования номеров отеля.</strong></h4>
                    <p class="text-center"><strong>Гостиничный комплекс предоставляет номера различной комфортабельности, от "эконом" типа до типа "люкс". </strong></p>
                    <p class="text-justify"><strong>В гостинице №7 имеется 80 однокомнатных номеров "эконом" типа размером от 12 до 15 м2, 30 номеров одноместные, 50 номеров двухместные. В гостиницах №9 и №311 по 60 номеров, из них 8 номеров типа "люкс" общей площадью 35 м2, номер люкс состоит из двух комнат: кухни и спальни; и 52 номера однокомнатные типа "стандарт" площадью от 20 до 25 м2. В гостинице "Фили" 48 однокомнатных номеров, 4 номера типа "люкс" площадью 30 м2, 44 номера типа "комфорт" площадью от 25 до 30 м2. В гостинице "Космос" 46 номеров типа "комфорт" площадью 25 м2. В гостинице "Комета" 32 номера типа "люкс" площадью 30 м2, в каждом номере две комнаты: спальня и гостиная. В гостинице "Полет" 36 номеров типа "стандарт". 
В каждом номере "эконом" типа есть холодильник, телевизор и шкаф, а число такой мебели как: односпальная кровать, тумбочка, письменный стол, стул, торшер меняется от числа проживающих в номере (одноместный или двухместный). Начиная с номеров типа "стандарт" в номере может проживать как один человек, так и семейная пара.  В номере стандартного типа имеется кровать, две прикроватные тумбочки, комод, на котором находится телевизор, шкаф, письменный стол со стулом, холодильник, кондиционер, обогреватель, телефон, DVD магнитофон, видеомагнитофон, ковровое покрытие. В номере типа "комфорт", помимо выше перечисленной мебели номера "стандарт", имеется кресло с журнальным столиком, обеденный стол с одним стулом (второй стул добавляется при проживании семейной пары), специальная тумбочка для телевизора, DVD магнитофона и видеомагнитофона. Номера типа "люкс" делятся на три вида: одна большая комната, представляющая из себя спальню с гостиной, две комнаты (спальня и гостиная) и две комнаты (спальня и кухня). Первые два вида номеров "люкс" содержат мебель  и оборудование лучшего качества. В номере "люкс" третьего вида, спальня оборудована как номер типа "стандарт", (но мебель и оборудование лучше).
                        </strong></p>
                    <div ng-controller="ControllerNomer as nomerctrl" >
                        <label >Тип номера</label> 
                        <div ng-controller="ControllerTN as depctrl">
                            <select  ng-change="nomerctrl.myFunc()" ng-model="nomerctrl.data.typenomerhotel"     name="select"  class="form-control ">
                                <option ng-repeat="dep in depctrl.units" value="{{dep.id}}">{{dep.type + ' ' + dep.mest}}</option>
                            </select>
                        </div>

                        <label >Гостиница</label> 
                        <div ng-controller="Controller as hctrl">
                            <select  ng-model="nomerctrl.data.idhotel"  class="form-control ">
                                <option ng-repeat="u in hctrl.units" value="{{u.id}}">{{u.name}}</option>
                            </select>
                        </div>


                        <div>
                        <label >Дата заезда</label>
                        <input type="date" name="dateIn"  ng-model="nomerctrl.data.dateb"  class="form-control"  >
                        <label >Дата выезда</label>
                        <input type="date" ng-model="nomerctrl.data.datee" class="form-control " name="dateOut"  >
                        <p></p>
                        <button ng-click="nomerctrl.fetchFreeU()" class="btn btn-primary">Проверить наличие свободных номеров</button>
                        </div>
                        
                        <br>
                        <br>
                        
                        <div style="display:{{nomerctrl.block}}">
                            <h4>Список доступных номеров</h4> 
                            <table class="table table-bordered">
                                <thead>
                                    <tr class="active">
                                        <th>Номер</th>
                                        <th>Гостиница</th>
                                        <th>Тип номера</th>
                                        <th width="20%"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="active" ng-repeat="e in nomerctrl.nomers">
                                        <td><span ng-bind="e.number"></span></td>
                                        <td><span ng-bind="e.idgostin.name"></span></td>
                                        <td><span ng-bind="e.typenomer.type +' '+ e.typenomer.mest"></span></td>
                                        <td>
                                            <button type="button"  ng-click="nomerctrl.route(e.id)" class="btn btn-success">Забронировать</button>  
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                
                   

                        <div style="display:{{nomerctrl.block1}}">
                            <h4>Внутрений вид номера</h4>
                            <div  class="fotorama" >
                                <img src="resources/images/0029.jpg">
                                <img src="resources/images/0016.jpg">
                                <img src="resources/images/0018.jpg">
                                <img src="resources/images/0019.jpg">
                            </div>
                            <h4><a name="1"></a>В номере присутвует:</h4>

                            <ul>
                                <li>Вечерняя уборка номера и подготовка постели ко сну </li>
                                <li>Круглосуточное обслуживание в номерах </li>
                                <li>Регулярно пополняемый персональный бар </li>
                                <li>Кофеварки Nespresso во всех номерах</li>
                                <li>Электрочайники Bork и чай Ronnefeldt во всех номерах</li>
                                <li>Проигрыватель CD/DVD </li>
                                <li>Сенсорные панели управления освещением, обслуживанием в номерах, часами и шторами. </li>
                                <li>Ванная комната, отделанная мрамором </li>
                                <li>Туалетные принадлежности Asprey</li>
                                <li>Зеркало для макияжа с подсветкой, фен и весы </li>
                                <li>Роскошные махровые халаты </li>
                                <li>Бесплатный высокоскоростной доступ в Интернет </li>
                                <li>Возможность подключения компьютера, факса, порт передачи данных </li>
                                <li>Многоканальные телефоны с голосовой почтой и беспроводные телефоны </li>
                                <li>Сейф в номере (в сейфе предусмотрена розетка для подключения ноутбука) </li>
                                <li>Утюг и гладильная доска</li>
                                <li>Бесплатная доставка утренних газет </li>
                                <li>Бесплатная чистка обуви вечером </li>
                                <li>Все номера и люксы отеля являются некурящими.</li>
                            </ul>

                        </div>

                        <div style="display:{{nomerctrl.block2}}">
                            <h4>Внутрений вид номера</h4>
                            <div  class="fotorama" >
                                <img src="resources/images/0020.jpg">
                                <img src="resources/images/0021.jpg">
                                <img src="resources/images/0028.jpg">
                                <img src="resources/images/0029.jpg">
                            </div>
                            <h4><a name="1"></a>В номере присутвует:</h4>

                            <ul>
                                <li>Вечерняя уборка номера и подготовка постели ко сну </li>
                                <li>Круглосуточное обслуживание в номерах </li>
                                <li>Регулярно пополняемый персональный бар </li>
                                <li>Кофеварки Nespresso во всех номерах</li>
                                <li>Электрочайники Bork и чай Ronnefeldt во всех номерах</li>
                                <li>Проигрыватель CD/DVD </li>
                                <li>Сенсорные панели управления освещением, обслуживанием в номерах, часами и шторами. </li>
                                <li>Ванная комната, отделанная мрамором </li>
                                <li>Туалетные принадлежности Asprey</li>
                                <li>Зеркало для макияжа с подсветкой, фен и весы </li>
                                <li>Роскошные махровые халаты </li>
                                <li>Бесплатный высокоскоростной доступ в Интернет </li>
                                <li>Возможность подключения компьютера, факса, порт передачи данных </li>
                                <li>Многоканальные телефоны с голосовой почтой и беспроводные телефоны </li>
                                <li>Сейф в номере (в сейфе предусмотрена розетка для подключения ноутбука) </li>
                                <li>Утюг и гладильная доска</li>

                            </ul>

                        </div>

                        <div style="display:{{nomerctrl.block3}}">
                            <h4>Внутрений вид номера</h4>
                            <div  class="fotorama" >
                                <img src="resources/images/0030.jpg">
                                <img src="resources/images/0031.jpg">
                                <img src="resources/images/0030.jpg">
                                <img src="resources/images/0026.jpg">
                            </div>
                            <h4><a name="1"></a>В номере присутвует:</h4>

                            <ul>
                                <li>Вечерняя уборка номера и подготовка постели ко сну </li>
                                <li>Круглосуточное обслуживание в номерах </li>
                                <li>Регулярно пополняемый персональный бар </li>
                                <li>Кофеварки Nespresso во всех номерах</li>
                                <li>Электрочайники Bork и чай Ronnefeldt во всех номерах</li>
                                <li>Проигрыватель CD/DVD </li>
                                <li>Сенсорные панели управления освещением, обслуживанием в номерах, часами и шторами. </li>
                                <li>Ванная комната, отделанная мрамором </li>
                                <li>Туалетные принадлежности Asprey</li>
                                <li>Зеркало для макияжа с подсветкой, фен и весы </li>
                                <li>Роскошные махровые халаты </li>
                                <li>Бесплатный высокоскоростной доступ в Интернет </li>
                                <li>Возможность подключения компьютера, факса, порт передачи данных </li>
                            </ul>
                        </div>


                        <div style="display:{{nomerctrl.block4}}">
                            <h4>Внутрений вид номера</h4>
                            <div  class="fotorama" >
                                <img src="resources/images/0032.jpg">
                                <img src="resources/images/0027.jpg">
                                <img src="resources/images/0020.jpg">
                              
                            </div>
                            <h4><a name="1"></a>В номере присутвует:</h4>

                            <ul>
                                <li>Вечерняя уборка номера и подготовка постели ко сну </li>
                                <li>Круглосуточное обслуживание в номерах </li>
                                <li>Регулярно пополняемый персональный бар </li>
                                <li>Кофеварки Nespresso во всех номерах</li>
                                <li>Электрочайники Bork и чай Ronnefeldt во всех номерах</li>
                                <li>Проигрыватель CD/DVD </li>
                                <li>Сенсорные панели управления освещением, обслуживанием в номерах, часами и шторами. </li>
                                <li>Ванная комната, отделанная мрамором </li>
                            </ul>
                        </div>





                    </div>


                </div>
            </div>


            <div class="col-md-1"></div>





        </div>
        <br>
        <!-- Низ страницы -->
        <div class="navbar navbar-default navbar-bottom">

        </div>
        <!-- Modules -->
         <script src="resources/js/helpfunction/FileSaver.js"></script>
        <script src="resources/js/app/hotels-app.js"></script>
        <!-- Service -->
        <script src="resources/js/service/reservation-service.js"></script>
        <script src="resources/js/service/typenom-service.js"></script>
        <script src="resources/js/service/nomer-service.js"></script>
        <script src="resources/js/service/hotels-service.js"></script>
        <!-- Controllers -->
        <script src="resources/js/controller/reservation-controller.js"></script>
        <script src="resources/js/controller/typenom-controller.js"></script>
        <script src="resources/js/controller/hotels-controller.js"></script> 
        <script src="resources/js/controller/nomer-controller.js"></script>
  <script src="resources/js/module/json-export-excel.js"></script> 

    </body>
</html>