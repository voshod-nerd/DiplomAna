<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
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
<body  ng-app="myApp">
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
    
    <div ng-controller="ControllerBron as ctrl" class="container" style="background-color:#ADD8E6; border-radius: 15px;" >
        <br>
        <br>
        <br>
        <h4><strong>Список забронированных номеров организации: ${org}</strong></h4>
        <input type="hidden" ng-init="ctrl.idorg=${idorg}"   />
        <button class="btn-success" ng-click="ctrl.getWithParam()">Проверить</button>
        <br>
        <div style="display: {{ctrl.block1}}" >
            <br>
            <div class="text-danger"><strong>Ваша оргранизация пока ничего не забронировала!</strong></div>
            
            
        </div>
        <div style="display: {{ctrl.block2}}">
           <div class="panel-heading"><span class="lead">Список бронированных номеров</span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Дата вьезда</th>
                                <th>Дата выезда</th>
                                <th>ФИО клиента (проживаюшего)</th>
                                <th>Забронированный номер</th>
                                

                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="e in ctrl.units| filter:ctrl.searchFish">
                                <td><span ng-bind="e.dateb"></span></td>
                                <td><span ng-bind="e.datee"></span></td>
                                <td><span ng-bind="e.idclient.fio"></span></td>
                                <td><span ng-bind="e.idnomer.number"></span></td>
                               

                                <td>
                                    <button type="button" 
                                            ng-click="ctrl.denU(e)" 
                                            class="btn-success"
                                            style=" width: 90px !important;">Отменить бронь</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div> 
            
        </div>
    </div>
        
        
        
    </div>

    <script src="resources/js/helpfunction/FileSaver.js"></script>
        <script src="resources/js/app/hotels-app.js"></script>
        <script src="resources/js/service/bron-service.js"></script>
        <script src="resources/js/controller/bron-controller.js"></script>  
        <script src="resources/js/module/json-export-excel.js"></script> 
    
    
</body>
</html>