<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Служебный сайт комплекса гостиниц</title>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="resources/js/jquery-1.12.3.min.js"></script>
        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- css code for slider  -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="resources/js/bootstrap.min.js"></script>

        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB --> 
        <!-- Angular JS -->
        <script src="resources/js/angular.min.js" ></script>

        <script   src="https://code.jquery.com/ui/1.12.0-rc.2/jquery-ui.js"   integrity="sha256-6HSLgn6Ao3PKc5ci8rwZfb//5QUu3ge2/Sw9KfLuvr8="   crossorigin="anonymous"></script>

    </head>
    <body ng-app="myApp">
       <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="/vc/home" class="navbar-brand">Админка (Главная)</a>
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse" id="navbar-main">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Cписок дейсвий<span class="caret"></span></a>
                            <ul class="dropdown-menu" aria-labelledby="themes">
                        <li> <a href="orders" >Подача и редактирование списка заявок</a></li>
                        <li><a href="hotels" >Редактирование списка отелей</a></li>
                        <li><a href="sotrudnik" >Редактирование личных карточек сотрудников</a></li>
                        <li><a href="organiz" >Редактирование списка организаций</a></li>
                        <li><a href="hotel" >Редактирование списка типов заявок</a></li>
                        <li><a href="hotel" >Редактирование списка типов питания</a></li>
                        <li><a href="hotel" >Редактирование списка должностей</a></li>
                        <li><a href="hotel" >Редактирование списка работ</a></li>
                        <li><a href="hotel" >Редактирование списка организаций</a></li>
                        <li><a href="hotel" >Редактирование списка программ</a></li>
                        <li><a href="hotel" >Реестр ремонтныъ работ</a></li>
                        <li><a href="hotel" >Редактирование стоимости услуг</a></li>
                        <li><a href="hotel" >Реестр стоимость номеров</a></li>
                                <li class="divider"></li>
                            </ul>
                        </li>

                        <li>

                        </li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="/vc" target="_blank">Главная (общедоступная)</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row" ng-controller="OrderController as ctrl">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <br>
                <br>
                <br>
                <p>Подача заявок</p>

                <form>


                    <label >Выберете отель</label>
                    <select class="form-control " name="hotel">
                        <c:forEach var="hotel" items="${listHotel}" varStatus="ls">
                            <option>${hotel.name}</option>                           
                        </c:forEach>    
                    </select>

                    <label>Номер отеля</label> 
                    <input class="form-control " type="text" name="nomer" ></input>



                    <label >Тип заявки</label>
                    <select class="form-control " name="typez">
                        <c:forEach var="zav" items="${istTypeZ}" varStatus="ls1">
                            <option>${zav.name}</option>                           
                        </c:forEach>    
                    </select>

                    <label >Сотрудник подавший заявку</label>
                    <select class="form-control " name="sotrudnik">
                        <c:forEach var="sotr" items="${listSotr}" varStatus="ls2">
                            <option>${sotr.fio}</option>                           
                        </c:forEach>    
                    </select> 
                    <br>
                    <button class="btn btn-primary" type="submit" >Внести заявку по данному номеру</button>  

                </form>          
                <br>
                <button class="btn btn-primary" ng-click="ctrl.showBlock()" >Просмотр списка заявок</button>
                <br>
                <!-- Скрытое таблицы пока не нажата кнопка просмотр список заявок !-->
                <div style="display: {{ctrl.vis}}" >

                    <h4>Таблица заявок</h4>
                    <div class="tablecontainer">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Тип заявки</th>
                                    <th>Гостиничный номер</th>
                                    <th>Дата начала</th>
                                    <th>Дата закрытия</th>
                                    <th>Статус</th>
                                    <th>Сотрудник</th>
                                    <th width="20%"></th>
                                    
                                     <th width="20%"></th>
                                </tr>
                            </thead>
                            <tbody>

                                <tr ng-repeat="e in ctrl.zayvs">
                                    <td><span ng-bind="e.id"></span></td>
                                    <td><span ng-bind="e.typez.name"></span></td>
                                    <td><span ng-bind="e.idnomer.name"></span></td>
                                    <td><span ng-bind="e.datez"></span></td>
                                    <td><span ng-bind="e.datezav"></span></td>
                                    <td><span ng-bind="e.status"></span></td>
                                    <td><span ng-bind="e.idsotr.name"></span></td>
                                    <td>
                                        <button type="button" ng-click="ctrl.edit(e)" 
                                                class="btn btn-success custom-width"
                                                style=" width: 90px !important;">Изменить</button>  
                                        <button type="button" 
                                                ng-click="ctrl.deleteEmployee(e)" 
                                                class="btn btn-danger custom-width"
                                                style=" width: 90px !important;">Удалить</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>

        <script src="resources/js/app/orders-app.js"></script>
        <script src="resources/js/service/orders-service.js"></script>
        <script src="resources/js/controller/orders-controller.js"></script> 

    </body>
</html>