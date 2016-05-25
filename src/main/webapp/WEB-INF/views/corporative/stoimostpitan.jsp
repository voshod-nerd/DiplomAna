<%-- 
    Document   : sotrudnik
    Created on : 04.05.2016, 12:04:36
    Author     : Соколов
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
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



        <br>
        <br>

        <div> 
            <div class="generic-container" ng-controller="ControllerStoimPitan as ctrl">
                <div class="panel panel-default">
                    <div class="panel-heading"><span class="lead">Форма редактирования стомости питания</span></div>
                    <div class="formcontainer">
                        <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                            <input type="hidden"  ng-model="ctrl.unit.id" />
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Сумма</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.sum" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите сумму " 
                                               required ng-minlength="1"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 1</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            

                           

                          
                            


                            <div class="row">
                                <div class="form-group col-md-12" ng-controller="ControllerPitan as depctrl">
                                    <label class="col-md-2 control-lable" for="dolg">Вид питания</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.idpitanie" 
                                                id="dolg"
                                                name="dolg">
                                            <option ng-repeat="dep in depctrl.units" value="{{dep}}">{{dep.name}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>
                            
                            
                            <div class="row">
                                <div class="form-group col-md-12" ng-controller="ControllerTarif as tctrl">
                                    <label class="col-md-2 control-lable" for="dolg">Тариф</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.idtarif" 
                                                id="dolg"
                                                name="dolg">
                                            <option ng-repeat="dept in tctrl.units" value="{{dept}}">{{dept.name}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>


                            

                            <div class="row">
                                <div class="form-actions floatRight">
                                    <input type="submit"  
                                           value="{{!ctrl.unit.id ? 'Добавить' : 'Изменить'}}" 
                                           class="btn btn-primary btn-sm" 
                                           ng-disabled="myForm.$invalid">
                                    <button type="button" 
                                            ng-click="ctrl.reset()" 
                                            class="btn btn-warning btn-sm" 
                                            ng-disabled="myForm.$pristine">Сбросить</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">Стоимость видов питания в зависимости от тарифа</span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Сумма питания</th>
                                <th>Вид питания</th>
                                <th>Вид тарифа</th>
                                
                                
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="e in ctrl.units">
                                <td><span ng-bind="e.sum"></span></td>
                               
                                <td><span ng-bind="e.idpitanie.name"></span></td>
                                <td><span ng-bind="e.idtarif.name"></span></td>
                                <td>
                                    <button type="button" ng-click="ctrl.edit(e)" 
                                            class="btn btn-success custom-width"
                                            style=" width: 90px !important;">Изменить</button>  
                                    <button type="button" 
                                            ng-click="ctrl.deleteU(e)" 
                                            class="btn btn-danger custom-width"
                                            style=" width: 90px !important;">Удалить</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="resources/js/app/hotels-app.js"></script>
        <script src="resources/js/service/stoimpitan-service.js"></script>
        <script src="resources/js/controller/stoimpitan-controller.js"></script> 
        <script src="resources/js/service/pitan-service.js"></script>
        <script src="resources/js/controller/pitan-controller.js"></script> 
        <script src="resources/js/service/tarif-service.js"></script>
        <script src="resources/js/controller/tarif-controller.js"></script> 
    </body>
</html>
