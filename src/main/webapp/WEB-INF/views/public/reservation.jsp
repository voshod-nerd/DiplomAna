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
        <br>
        <br>

        <div class="container"  style="background-color:#ADD8E6; border-radius: 15px;">

            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10"  ng-controller="ControllerReserv as ctrl">



                    <h4 class="text-center">Забронируйте себе номер прямо сейчас!</h4>

                    <h4>Правила бронирования номеров отеля.</h4>

                    </p>Цены на услуги отеля и спецпредложения являются публичной офертой. Оферта может быть предоставлена или отозвана в любое время без специального уведомления.
                    В связи с тем, что в отеле все номера имеют небольшие отличия в своей категории, выбрав номер и оформив заявку на бронирование в письменной форме, он-лайн или по телефону, клиенты соглашаются с указанными в заявке сроками заезда и категорией номера, условиями бронирования и не могут без согласия администрации отеля, просить об изменении выбранных условий временного проживания.</p>
                    <h4>Условия гарантированного бронирования</h4>
                    <p>Как правило, производится гарантированное бронирование. Для гарантии Вашей брони предусмотрены следующие варианты:
                        1. Оплата первых суток проживания. Вы можете оплатить стоимость одних или более суток проживания в офисе компании по адресу: Алматы, ул. Розыбакиева, 72а, салон 50.
                        2. Гарантийное письмо от компании. Для корпоративных клиентов гостиницы достаточно отправить в отель заявку на бронирование в виде гарантийного письма. Гарантийное письмо должно содержать информацию о категории номера, дате прибытия, дате убытия, фамилии и имени гостя (гостей), контактную информацию по бронированию, а также текст о гарантии брони, реквизиты компании, подписи руководителя предприятия и главного бухгалтера. Пример текста заявки на гарантированное бронирование номера в гостинице: В отдел бронирования гостиницы “Рейкьявик” || Просим забронировать номер категории «одноместный стандартный» для г-на Иванова И.И. Дата прибытия: (число) (месяц) (год), дата отъезда: (число) (месяц) (год). Способ оплаты: (наличные/безналичный расчет/кредитная карта). В случае несвоевременной аннуляции (позднее, чем 72 часа до указанной в заявке даты заезда, либо незаезда по данной брони) компания (организационная форма)(название компании) гарантирует оплату стоимости 1 суток проживания по указанной брони.</p>


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



                        <label >Дата заезда</label>
                        <input type="date" name="dateIn"  ng-model="nomerctrl.data.dateb"  class="form-control"  >
                        <label >Дата выезда</label>
                        <input type="date" ng-model="nomerctrl.data.datee" class="form-control " name="dateOut"  >
                        <p></p>
                        <button ng-click="nomerctrl.fetchFreeU(nomerctrl.data)" class="btn btn-primary">Проверить наличие свободных номеров</button>

                        <div style="display:{{nomerctrl.block}}">
                            <p>Список свободных номеров</p>

                            <br>
                            <br>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Номер</th>
                                        <th>Гостиница</th>
                                        <th>Тип номера</th>
                                        <th width="20%"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="e in nomerctrl.units">
                                        <td><span ng-bind="e.number"></span></td>
                                        <td><span ng-bind="e.idgostin.name"></span></td>
                                        <td><span ng-bind="e.typenomerhotel.type + e.typenomerhotel.mest"></span></td>


                                        <td>
                                            <button type="button" ng-click="" 
                                                    class="btn btn-success custom-width"
                                                    style=" width: 90px !important;">Забронировать</button>  

                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>


                        <div style="display:{{nomerctrl.block1}}">
                            <h4>Внутрений вид номера</h4>
                            <div  class="fotorama" >
                                <img src="resources/images/10.jpg">
                                <img src="resources/images/11.jpg">
                                <img src="resources/images/12.jpg">
                                <img src="resources/images/13.jpg">
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
                                <img src="resources/images/10.jpg">
                                <img src="resources/images/11.jpg">
                                <img src="resources/images/12.jpg">
                                <img src="resources/images/13.jpg">
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
                                <img src="resources/images/10.jpg">
                                <img src="resources/images/11.jpg">
                                <img src="resources/images/12.jpg">
                                <img src="resources/images/13.jpg">
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
                                <img src="resources/images/10.jpg">
                                <img src="resources/images/11.jpg">
                                <img src="resources/images/12.jpg">
                                <img src="resources/images/13.jpg">
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


    </body>
</html>