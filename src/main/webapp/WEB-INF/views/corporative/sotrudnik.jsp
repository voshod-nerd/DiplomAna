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



        <br>
        <br>

        <div> 
            <div class="generic-container" ng-controller="ControllerS as ctrl">
                <div class="panel panel-default">
                    <div class="panel-heading"><span class="lead">Форма редактирования личных карточек сотрудников</span></div>
                    <div class="formcontainer">
                        <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                            <input type="hidden"  ng-model="ctrl.unit.id" />
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">ФИО</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.fio" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите местоположение" 
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
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">День рождения</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.dr" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Гражданство</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.grag" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Номер удостоверения личности</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.num" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Серия документа уд.личности</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.ser" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Документ удостоверяющий личность</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.doclich" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Кем выдан</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.kemvidan" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Серия документа уд.личности</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.ser" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Дата выдачи</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.kogdavidan" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Телефон</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.phone" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Образование</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.education" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                             <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="firstname">Количество детей</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.koldet" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите наименование" 
                                               required ng-minlength="2"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 2</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            


                            <div class="row">
                                <div class="form-group col-md-12" ng-controller="ControllerD as depctrl">
                                    <label class="col-md-2 control-lable" for="dolg">Должность</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.iddolgnost" 
                                                id="dolg"
                                                name="dolg">
                                            <option ng-repeat="dep in depctrl.units" value="{{dep}}">{{dep.dolgnost}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>


                            <input type="hidden"  ng-model="ctrl.unit.iduser" />

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
                <div class="panel-heading"><span class="lead">Список отелей</span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ФИО</th>
                                <th>Дата рождения</th>
                                <th>Гражданство</th>
                                <th>Серия номера документа уд.личности</th>
                                <th>Номер документа</th>
                                <th>Документ уд.лич</th>
                                <th>Кем выдан</th>
                                <th>Дата выдачи</th>
                                <th>Должность</th>
                                <th>Адрес</th>
                                <th>Телефон</th>
                                <th>Образование</th>
                                <th>Колич. детей</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="e in ctrl.units">
                                <td><span ng-bind="e.fio"></span></td>
                                <td><span ng-bind="e.dr"></span></td>
                                <td><span ng-bind="e.grag"></span></td>
                                <td><span ng-bind="e.ser"></span></td>
                                <td><span ng-bind="e.num"></span></td>
                                <td><span ng-bind="e.docklich"></span></td>
                                 <td><span ng-bind="e.kemvidan"></span></td>
                                 <td><span ng-bind="e.kogdavidan"></span></td>
                                <td><span ng-bind="e.iddolgnost.dolgnost"></span></td>
                                
                                  <td><span ng-bind="e.adres"></span></td>
                                   <td><span ng-bind="e.phone"></span></td>
                                    <td><span ng-bind="e.education"></span></td>
                                     <td><span ng-bind="e.koldet"></span></td>
                                      

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
        <script src="resources/js/service/sotr-service.js"></script>
        <script src="resources/js/controller/sotr-controller.js"></script> 
        <script src="resources/js/service/dolgnost-service.js"></script>
        <script src="resources/js/controller/dolgnost-controller.js"></script> 
    </body>
</html>
