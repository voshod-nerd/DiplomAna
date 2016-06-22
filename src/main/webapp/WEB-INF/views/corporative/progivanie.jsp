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
                                    <li><a href="dolgnost" >Должности</a></li>
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
                                    <li><a href="progiv" >Заселение и выселение</a></li>
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
                                    <li><a href="dolgnost" >Должности</a></li>
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
                                    <li><a href="dolgnost" >Должности</a></li>
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
            <div class="generic-container" ng-controller="ControllerProgiv as ctrl">
                <div class="panel panel-default">
                    <div class="panel-heading"><span class="lead">Вселение/выселение</span></div>
                    <div class="formcontainer">
                        <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                            <input type="hidden"  ng-model="ctrl.unit.id" />
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="lastname">Дата вселения</label>
                                    <div class="col-md-7">
                                        <input type="date" ng-model="ctrl.unit.datein" 
                                               id="lastname" 
                                               class="username form-control input-sm" 
                                               placeholder="Дата вселения" 
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
                                    <label class="col-md-2 control-lable" for="firstname">Дата выселения</label>
                                    <div class="col-md-7">
                                        <input type="date" ng-model="ctrl.unit.dateout" 
                                               id="firstname" 
                                               class="username form-control input-sm" 
                                               placeholder="Введите дату конца полетной программы" 
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
                                <div class="form-group col-md-12" ng-controller="ControllerClient as ssctrl">
                                    <label class="col-md-2 control-lable" >Клиент</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.idclient">
                                            <option ng-repeat="ser in ssctrl.units" value="{{ser}}">{{ser.fio}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group col-md-12" >
                                    <label class="col-md-2 control-lable" for="dolg">Гостиница</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.hotel.name" 
                                                >
                                            <option ng-repeat="deptz in ctrl.hotels" value="{{deptz.name}}">{{deptz.name}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group col-md-12" >
                                    <label class="col-md-2 control-lable" >Номер</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.idnomer" 
                                                >
                                            <option ng-repeat="dt in ctrl.nomers | filter:ctrl.criteriaMatch " value="{{dt}}">{{dt.number}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12" ng-controller="ControllerStoimPitan as vctrl">
                                    <label class="col-md-2 control-lable" for="dolg">Питание</label>
                                    <div class="col-md-7">
                                        <select ng-model="ctrl.unit.idstoimostpit" 
                                                >
                                            <option ng-repeat="vv in vctrl.units" value="{{vv}}">{{vv.idpitanie.name +': тариф '+vv.idtarif.name}}</option>
                                        </select> 
                                    </div>
                                </div>
                            </div>



                            <div class="row">
                                <div class="form-actions floatRight">
                                    <input type="submit"  
                                           value="{{!ctrl.unit.id ? 'Вселить' : 'Изменить'}}" 
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
                </div>

                <p><strong>Cформировать отчет по проживающим по гостинице</strong></p>
                <select ng-model="ctrl.hotelLife.id"  >
                    <option ng-repeat="zz in ctrl.hotels" value="{{zz.id}}">{{zz.name}}</option>
                </select> 

                <button class="btn-success" ng-click="ctrl.reportLifeHotel()" >Сформировать</button>
                
               
                  
                <br>
                <br>
                <button class="btn-success" ng-click="ctrl.registr()" >Ходатайство</button>
                 <br>
                 <button class="btn-success" ng-click="ctrl.gurnal()" >Журнал регистрации</button>
                 
                 <p>Журнал измениений на  период</p>
                 <input type="date" ng-model="ctrl.datebegin" >
                 <input type="date" ng-model="ctrl.dateend">
                 <button ng-click="ctrl.izm()" >Сформировать</button>
   

                <form>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><i class="fa fa-search"></i></div>
                            <input type="text" class="form-control" placeholder="Поиск по таблице" ng-model="ctrl.searchFish">
                        </div>      
                    </div>
                </form>


                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">Список проживающих </span></div>
                <p>Проживают в текущий момент <input type="checkbox" ng-model="ctrl.filterpogiv"  /></p>
                <div class="tablecontainer">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Дата вселения</th>
                                <th>Дата выселения</th>
                                <th>Cумма доп услуг</th>
                                <th>Обшая сумма</th>
                                <th>ФИО</th>
                                <th>Гостиница и номер</th>

                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="m in ctrl.units| filter:ctrl.searchFish | filter: ctrl.customFilter">
                                <td><span ng-bind="m.datein"></span></td>
                                <td><span ng-bind="m.dateout"></span></td>
                                <td><span ng-bind="m.dopusl"></span></td>
                                <td><span ng-bind="m.totalsum"></span></td>
                                <td><span ng-bind="m.idclient.fio"></span></td>
                                <td><span ng-bind="mm.idnomer.idgostin.name +' :№ '+m.idnomer.number"></span></td>

                                <td>
                                    <button type="button" ng-click="ctrl.edit(m)" 
                                            class="btn btn-success custom-width"
                                            style=" width: 90px !important;">Изменить</button>  
                                    <button type="button" 
                                            ng-click="ctrl.deleteU(m)" 
                                            class="btn btn-danger custom-width"
                                            style=" width: 90px !important;">Удалить</button>
                                    <button type="button" 
                                            ng-click="ctrl.report(m)"
                                            class="btn btn-warning custom-width"
                                            style=" width: 90px !important;">Выселить</button>
                                    <button type="button" 
                                            ng-click="ctrl.anketa(m)"
                                            class="btn btn-warning custom-width"
                                            style=" width: 90px !important;">Анкета</button>
                                   
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                    
                <button class="btn-success" ng-click="ctrl.reestr1()" >Реестр на питание</button>
                 <button class="btn-success" ng-click="ctrl.reestr2()" >Реестр на проживание</button>
                    
                    
                </div>
            </div>
        </div>


        <script src="resources/js/helpfunction/FileSaver.js"></script>
        <script src="resources/js/app/hotels-app.js"></script>
       

        <script src="resources/js/service/client-service.js"></script>
        <script src="resources/js/controller/client-controller.js"></script> 
        <script src="resources/js/service/nomer-service.js"></script>
        <script src="resources/js/controller/nomer-controller.js"></script> 

        <script src="resources/js/service/stoimpitan-service.js"></script>
        <script src="resources/js/controller/stoimpitan-controller.js"></script> 
        
         <script src="resources/js/service/progiv-service.js"></script>
        <script src="resources/js/controller/progiv-controller.js"></script> 

        <script src="resources/js/module/json-export-excel.js"></script> 
    </body>
</html>
