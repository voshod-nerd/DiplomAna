<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="row">
<div class="col-md-1"></div>
<div class="col-md-10">
<div ng-controller="reservationController">


<h4>Забронируйте себе номер прямо сейчас!</h4>

<h4>Правила бронирования номеров отеля.</h4>

</p>Цены на услуги отеля и спецпредложения являются публичной офертой. Оферта может быть предоставлена или отозвана в любое время без специального уведомления.
В связи с тем, что в отеле все номера имеют небольшие отличия в своей категории, выбрав номер и оформив заявку на бронирование в письменной форме, он-лайн или по телефону, клиенты соглашаются с указанными в заявке сроками заезда и категорией номера, условиями бронирования и не могут без согласия администрации отеля, просить об изменении выбранных условий временного проживания.</p>
<h4>Условия гарантированного бронирования</h4>
<p>Как правило, производится гарантированное бронирование. Для гарантии Вашей брони предусмотрены следующие варианты:
1. Оплата первых суток проживания. Вы можете оплатить стоимость одних или более суток проживания в офисе компании по адресу: Алматы, ул. Розыбакиева, 72а, салон 50.
2. Гарантийное письмо от компании. Для корпоративных клиентов гостиницы достаточно отправить в отель заявку на бронирование в виде гарантийного письма. Гарантийное письмо должно содержать информацию о категории номера, дате прибытия, дате убытия, фамилии и имени гостя (гостей), контактную информацию по бронированию, а также текст о гарантии брони, реквизиты компании, подписи руководителя предприятия и главного бухгалтера. Пример текста заявки на гарантированное бронирование номера в гостинице: В отдел бронирования гостиницы “Рейкьявик” || Просим забронировать номер категории «одноместный стандартный» для г-на Иванова И.И. Дата прибытия: (число) (месяц) (год), дата отъезда: (число) (месяц) (год). Способ оплаты: (наличные/безналичный расчет/кредитная карта). В случае несвоевременной аннуляции (позднее, чем 72 часа до указанной в заявке даты заезда, либо незаезда по данной брони) компания (организационная форма)(название компании) гарантирует оплату стоимости 1 суток проживания по указанной брони.</p>

<h4>Забронируйте прямо сейчас</h4>

<h4>Выбор вида бронирования</h4>
<select ng-change="SelectBron()"  class="form-control " name="selectVidBron"  ng-model="data.selectVidBron">
<option value="1">Одиночное бронирование</option>
<option value="2">Групповое бронирование</option>
</select>


<div style="display: {{brongroup}}" >
<p>*Групповое бронироваие допускается только для номеров стандарт</p>
 
<label >Введите количество номеров для бронирования</label>
<input type="text" class="form-control " ></input>
<button ng-click="fetchDepartment()"  class="btn btn-primary">Проверить наличие свободных номеров</button>
</div>



<div style="display: {{broned}}">
 <label >Тип номера</label> 
<select  ng-change="myFunc()"  class="form-control " name="singleSelect"  ng-model="data.singleSelect">
  <option value="1">Эконом: 1-местный</option>
  <option value="2">Эконом: 2-местный</option>
  <option value="3">Стандарт: 2-местный</option>
  <option value="4" >Люкс: 1-местный</option>
</select>


<label >Дата заезда</label>
<input type="date" name="dateIn"  ng-model="data.dateIn" class="form-control "  >
<label >Дата выезда</label>
<input type="date"  class="form-control " name="dateOut"  ng-model="data.dateOut">
<p></p>
<button ng-click="checkfreenomer()" class="btn btn-primary">Проверить наличие</button>

<br>
<div style="display:{{blockreser}}">
<label >Имя</label>
<input type="text"  class="form-control "  name="name">
<label >Фамилия</label>
<input type="text"  class="form-control "  name="surname">
</div>


<div style="display:{{block1}}">
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

<div style="display:{{block2}}">
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

<div style="display:{{block3}}">
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


<div style="display:{{block4}}">
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
</div>

<table class="table table-hover" >
                      <thead>
                          <tr>
                              <th>No</th>
                              <th>Dept No</th>
                              <th>Dept Name</th>
                              <th>Location</th>
                              
                          </tr>
                      </thead>
                      <tbody>
                        <tr ng-repeat="d in departments">
                              <td><span ng-bind="d.deptId"></span></td>
                              <td><span ng-bind="d.deptName"></span></td>
                              <td><span ng-bind="d.deptNo"></span></td>
                              <td><span ng-bind="d.location"></span></td>
                      
                      </tbody>
                      </table>
 {{message}}






<div class="col-md-1"></div>





</div>
<br>
<!-- Низ страницы -->
<div class="navbar navbar-default navbar-bottom"></div>

    <!-- Modules -->
    <script src="resources/js/app/reservation-app.js"></script>
       <!-- Service -->
     <script src="resources/js/service/reservation-service.js"></script>
    <!-- Controllers -->
    <script src="resources/js/controller/reservation-controller.js"></script>
    <!-- Directives -->
    <script src="resources/js/directive/reservation-directive.js"></script>
  
    
</body>
</html>