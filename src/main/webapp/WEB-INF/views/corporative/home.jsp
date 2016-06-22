<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Служебный сайт комплекса гостиниц</title>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="resources/js/jquery-2.2.2.min.js"></script>
        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- css code for slider  -->
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="resources/js/bootstrap.min.js"></script>
          <style>
   .gradient {
    background: #fefcea; /* Для старых браузров */
    background: linear-gradient(to top, #fefcea, #f1da36);
    padding: 10px;
    border: 1px solid #333;
   }
  </style>
        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB --> 

    </head>
    <body style="gradient" >
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
        <br>


        <div style="background-image: url(/vc/resources/images/2004.jpg)" class="container">

            <div class="row">

                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <br>
                    <br>
                     <br>
                    <br>
                     <br>
                    <br>
                     <br>
                    <br>
                     <br>
                     <br>
                    <br>
                     <br>
                    <br>
                      <br>
                    <br>
                     <br>
                    <br>
                     <br>
                    <br>
                     <br>
                    <br>
                     <br>
                     <br>
                    <br>
                     <br>
                    <br>
                      <br>
                    <br>
                     <br>
                    <br>
                     <br>
                    <br>
                     <br>
                    
                     
                    
                   
                    
                    
                    
                    
                </div>
                <div class="col-md-1"></div>
            </div>    
        </div>


    </body>
</html>