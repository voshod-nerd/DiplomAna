<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
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
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
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
                        <sec:authorize access="hasRole('ROLE_DIRECTOR')">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Справочники<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">                        
                                    <li><a href="hotels" >Гостиницы</a></li>
                                    <li><a href="typenomerhot" >Типы номеров</a></li>
                                    <li><a href="uslug" >Дополнительные услуги</a></li>
                                    <li><a href="typezav" >Типы заявок</a></li>
                                    <li><a href="organiz" >Организации</a></li>
                                    <li><a href="programs" >Пусковые программы</a></li>
                                    <li><a href="pitan" >Виды питания</a></li>
                                    <li><a href="dolgnost" >Должностя</a></li>
                                    <li class="divider"></li>

                                </ul>

                            </li>

                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Номера<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">

                                    <li><a href="nomer" >Номера</a></li>
                                    <li> <a href="orders" >План текущих ремонтых работ</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>


                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Сотрудники<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">


                                    <li><a href="sotrudnik" >Сотрудники</a></li>
                                    <li><a href="otpusk" >Отпуска</a></li>
                                    <li><a href="grafik" >График дежурств</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>


                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Клиенты<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">



                                    <li><a href="client" >Клиенты</a></li>
                                    <li><a href="bronz" >Бронирование</a></li>
                                    <li><a href="reestuslug" >Дополнительные услуги</a></li> 
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Тарифы<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">



                                    <li><a href="tarif" >Типы тарифов</a></li>
                                    <li><a href="stoimostpitan" >Стоимость питания</a></li>
                                    <li><a href="stoimostnomer" >Стоимость типов номеров</a></li>
                                    <li><a href="stoimostuslug" >Стоимость дополнительных услуг</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>



                        </sec:authorize>  


                        <sec:authorize access="hasRole('ROLE_ZAM')">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Справочники<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">                        
                                    <li><a href="hotels" >Гостиницы</a></li>
                                    <li><a href="typenomerhot" >Типы номеров</a></li>
                                    <li><a href="uslug" >Дополнительные услуги</a></li>
                                    <li><a href="typezav" >Типы заявок</a></li>
                                    <li><a href="organiz" >Организации</a></li>
                                    <li><a href="programs" >Пусковые программы</a></li>
                                    <li><a href="pitan" >Виды питания</a></li>
                                    <li><a href="dolgnost" >Должностя</a></li>
                                    <li class="divider"></li>

                                </ul>

                            </li>

                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Номера<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">

                                    <li><a href="nomer" >Номера</a></li>
                                    <li> <a href="orders" >План текущих ремонтых работ</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>


                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Сотрудники<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">


                                    <li><a href="sotrudnik" >Сотрудники</a></li>
                                    <li><a href="otpusk" >Отпуска</a></li>
                                    <li><a href="grafik" >График дежурств</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>


                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Клиенты<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">



                                    <li><a href="client" >Клиенты</a></li>
                                    <li><a href="bronz" >Бронирование</a></li>
                                    <li><a href="reestuslug" >Дополнительные услуги</a></li> 
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Тарифы<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">



                                    <li><a href="tarif" >Типы тарифов</a></li>
                                    <li><a href="stoimostpitan" >Стоимость питания</a></li>
                                    <li><a href="stoimostnomer" >Стоимость типов номеров</a></li>
                                    <li><a href="stoimostuslug" >Стоимость дополнительных услуг</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>



                        </sec:authorize>  
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Справочники<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">                        
                                    <li><a href="hotels" >Гостиницы</a></li>
                                    <li><a href="typenomerhot" >Типы номеров</a></li>
                                    <li><a href="uslug" >Дополнительные услуги</a></li>
                                    <li><a href="typezav" >Типы заявок</a></li>
                                    <li><a href="organiz" >Организации</a></li>
                                    <li><a href="programs" >Пусковые программы</a></li>
                                    <li><a href="pitan" >Виды питания</a></li>
                                    <li><a href="dolgnost" >Должностя</a></li>
                                    <li class="divider"></li>

                                </ul>

                            </li>

                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Номера<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">

                                    <li><a href="nomer" >Номера</a></li>
                                    <li> <a href="orders" >План текущих ремонтых работ</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>


                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Сотрудники<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">


                                    <li><a href="sotrudnik" >Сотрудники</a></li>
                                    <li><a href="otpusk" >Отпуска</a></li>
                                    <li><a href="grafik" >График дежурств</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>


                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Клиенты<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">



                                    <li><a href="client" >Клиенты</a></li>
                                    <li><a href="bronz" >Бронирование</a></li>
                                    <li><a href="reestuslug" >Дополнительные услуги</a></li> 
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="" id="themes">Тарифы<span class="caret"></span></a>

                                <ul class="dropdown-menu" aria-labelledby="themes">



                                    <li><a href="tarif" >Типы тарифов</a></li>
                                    <li><a href="stoimostpitan" >Стоимость питания</a></li>
                                    <li><a href="stoimostnomer" >Стоимость типов номеров</a></li>
                                    <li><a href="stoimostuslug" >Стоимость дополнительных услуг</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </li>



                        </sec:authorize>  



                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="index" target="_blank">Главная (общедоступная)</a></li>
                    </ul>
                </div>
            </div>
        </div>



        <br>
        <br>

        <div> 
            <div class="generic-container" ng-controller="ControllerClient as ctrl">
                <br>
                <button class="btn-primary" ng-click="ctrl.show()" >Добавить клиента</button>
                <br>
                <div ng-show="ctrl.vis" class="panel panel-default">
                    <div class="panel-heading"><span class="lead">Список клиентов</span></div>
                    <div class="formcontainer">
                        <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                            <input type="hidden"  ng-model="ctrl.unit.id" />
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">ФИО клиента</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.fio" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите ФИО клиента" 
                                              />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">ФИО клиента (English)</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.fioeng" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите ФИО на английском " 
                                               />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                        
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Дата рождения</label>
                                    <div class="col-md-7">
                                        <input type="date" ng-model="ctrl.unit.dr" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               
                                              />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Вид документа</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.viddock" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                              
                                               />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                       
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Cерия паспорта или уд.личности</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.serdoc" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               
                                              />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>



                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Номер паспорта</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.numberdoc" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               
                                               />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                    
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Кем выдан</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.kemvidan" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                              
                                               />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                        
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Дата выдачи</label>
                                    <div class="col-md-7">
                                        <input type="date" ng-model="ctrl.unit.datavid" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите данные " 
                                             />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                           
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Дата окончания</label>
                                    <div class="col-md-7">
                                        <input type="date" ng-model="ctrl.unit.dataokon" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите данные " 
                                              />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                          
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Гражданство</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.strana" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите данные " 
                                             />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                          
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Адрес проживания</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.unit.adres" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите данные " 
                                              />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                         
                                        </div>
                                    </div>
                                </div>
                            </div>



                            <div class="row">
                                <div class="form-group col-md-12" ng-controller="ControllerProg as tctrl">
                                    <label class="col-md-2 control-lable" for="dolg">Пусковая программа клиетна</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.progclient" 
                                                id="dolg"
                                                name="dolg">
                                            <option ng-repeat="dep in tctrl.units" value="{{dep}}">{{dep.name}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12" ng-controller="ControllerOrg as depctrl">
                                    <label class="col-md-2 control-lable" for="dolg">Организация клиента</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.idorg" 
                                                id="dolg"
                                                name="dolg">
                                            <option ng-repeat="deps in depctrl.units" value="{{deps}}">{{deps.name}}</option>
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

                <br>
                <form>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="fa fa-search"></i></div>
                            <input type="text" class="form-control" placeholder="Поиск по таблице" ng-model="ctrl.searchFish">
                        </div>      
                    </div>
                </form>




               
                <div class="panel-heading"><span class="lead">Список клиентов гостиничного комплекса</span></div>
                <div class="tablecontainer">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Фио клиента</th>
                                <th>Фио (англиский)</th>
                                <th>Дата рождения</th>
                                <th>Пол</th>
                                <th>Вид документа</th>
                                <th>Серия</th>
                                <th>Номер</th>
                                <th>Кем выдан</th>
                                <th>Дата выдачи</th>
                                <th>Дата окончания</th>
                                <th>Гражданство</th>
                                <th>Адрес проживания</th>
                                <th>Летная программа</th>
                                <th>Организация</th>
                                <th></th>


                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="e in ctrl.units| filter:ctrl.searchFish">


                                <td><span ng-bind="e.fio"></span></td>
                                <td><span ng-bind="e.fioeng"></span></td>
                                <td><span ng-bind="e.dr"></span></td>
                                <td><span ng-bind="e.pol"></span></td>
                                <td><span ng-bind="e.viddock"></span></td>
                                <td><span ng-bind="e.serdok"></span></td>
                                <td><span ng-bind="e.numberdoc"></span></td>
                                <td><span ng-bind="e.kemvidan"></span></td>
                                <td><span ng-bind="e.datavid"></span></td>
                                <td><span ng-bind="e.dataokon"></span></td>
                                <td><span ng-bind="e.strana"></span></td>
                                <td><span ng-bind="e.adres"></span></td>
                                <td><span ng-bind="e.progclient.name"></span></td>
                                <td><span ng-bind="e.idorg.name"></span></td>
                                <td>
                                    <a type="button" ng-click="ctrl.edit(e)" 

                                       style=" width: 90px !important;">Изменить</a> 
                                    <br>
                                    <a  
                                        ng-click="ctrl.deleteU(e)" 

                                        style=" width: 90px !important;">Удалить</a>
                                    <br>
                                  
                                    <a href=""
                                       ng-click="ctrl.showViza(e)" 

                                       style=" width: 90px !important;">Виза</a>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                </div>


                <div ng-show="ctrl.vizaShow" class="formcontainer">
                    <div class="panel-heading"><span class="lead">Виза клиента</span></div>
                    <br>
                    <button class="btn-primary" ng-click="ctrl.showAddViza()" >Добавить</button>

                    <br>
                    <div class="formcontainer" ng-show="ctrl.vizaAdd">
                        <form ng-submit="ctrl.submitViza()" name="myForm1" class="form-horizontal">
                        <input type="hidden"  ng-model="ctrl.viza.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="lastname">Дата начала</label>
                                <div class="col-md-7">
                                    <input type="date" ng-model="ctrl.viza.beg" 
                                           id="lastname" 
                                           class="username form-control input-sm" 

                                         />
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
                                <label class="col-md-2 control-lable" for="lastname">Дата окончания</label>
                                <div class="col-md-7">
                                    <input type="date" ng-model="ctrl.viza.end" 
                                           id="lastname" 
                                           class="username form-control input-sm" 

                                          />
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
                                    <label class="col-md-2 control-lable" for="lastname">Номер визы</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.viza.number" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                              
                                             />
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.name.$error.required">Это обязательное поле</span>
                                            <span ng-show="myForm.name.$error.minlength">Минимальная длина - 1</span>
                                            <span ng-show="myForm.name.$invalid">Неверное значение в поле</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <div class="row">
                                <div class="form-actions floatRight">
                                    <input type="submit"  
                                           value="{{!ctrl.viza.id ? 'Добавить' : 'Изменить'}}" 
                                           class="btn btn-primary btn-sm" 
                                           ng-disabled="myForm.$invalid">
                                    <button type="button" 
                                            ng-click="ctrl.resetViza()" 
                                            class="btn btn-warning btn-sm" 
                                            ng-disabled="myForm.$pristine">Сбросить</button>
                                </div>
                            </div>
                    </form>
                        

                    </div>
                    <div class="tablecontainer">
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Дата начала</th>
                                    <th>Дата окончания</th>
                                    <th>Фио клиента</th>
                                    <th>Номер визы</th>
                                    <th>Действия</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-repeat="v in ctrl.vizas| filter:ctrl.selectedunit.fio">
                                    <td><span ng-bind="v.beg"></span></td>

                                    <td><span ng-bind="v.end"></span></td>
                                    <td><span ng-bind="v.idclient.fio"></span></td>
                                    <td><span ng-bind="v.number"></span></td>
                                    <td><a type="button" ng-click="ctrl.editViza(v)" 

                                           style=" width: 90px !important;">Изменить</a> 
                                        <br>
                                        <a  
                                            ng-click="ctrl.deleteUViza(v)" 

                                            style=" width: 90px !important;">Удалить</a>
                                        <br>

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
        <script src="resources/js/service/client-service.js"></script>
        <script src="resources/js/service/org-service.js"></script>
        <script src="resources/js/service/prog-service.js"></script>

        <script src="resources/js/controller/client-controller.js"></script>
        <script src="resources/js/controller/org-controller.js"></script> 
        <script src="resources/js/controller/prog-controller.js"></script> 
        <script src="resources/js/module/json-export-excel.js"></script> 
    </body>
</html>
