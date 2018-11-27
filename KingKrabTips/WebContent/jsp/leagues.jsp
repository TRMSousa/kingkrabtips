<%@page import="com.king.krab.tips.servlet.FrontOfficeServlet"%>
<%@page import="com.king.krab.tips.servlet.AjaxServlet"%>
<%@page import="com.king.krab.tips.objects.Game"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.king.krab.tips.objects.Team"%>
<%@page import="com.king.krab.tips.objects.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Collapsible sidebar using Bootstrap 4</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
        crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="theme/style4.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
        crossorigin="anonymous"></script>

    <style>
        .fa-check {color: green;}
        
        .fa-times {color: red;}

    </style>
    
    <%
		List<Country> lstCountries	= request.getAttribute("lstCountries") 	== null ? new ArrayList<Country>()	: (List<Country>) request.getAttribute("lstCountries");
		List<Team> lstTeams			= request.getAttribute("lstTeams") 		== null ? new ArrayList<Team>()		: (List<Team>) request.getAttribute("lstTeams");
		List<Game> lstGames			= request.getAttribute("lstGames") 		== null ? new ArrayList<Game>()		: (List<Game>) request.getAttribute("lstGames");
		
		String nameCountry	= (String) request.getAttribute("nameCountry");
	%>

</head>

<body>

    <div class="wrapper">
	<form id="form-menu" method="get" action="<%=request.getContextPath()%>/FrontOfficeServlet">
		<input type="hidden" id="form-menu-cmd" name="cmd" value="" />
		<input type="hidden" id="form-menu-idCountry" name="idCountry" value="" />

        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>BETKRAB</h3>
                <strong>BK</strong>
                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-bars"></i>
                </button>
            </div>
			
            <ul class="list-unstyled components">
                <li title="Início" class="active">
                    <a href="#">
                        <i class="fas fa-home"></i>
                        <span class="nameOfLinks">Início</span>
                    </a>
                </li>
                <li title="Jogos" >
                    <a href="#">
                        <i class="fas fa-futbol"></i>
                        <span class="nameOfLinks">Jogos</span> 
                    </a>
                </li>
                <li title="Ligas" >
                    <a href="#leaguesSubMenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                        <i class="fas fa-home"></i>
                        <span class="nameOfLinks">Ligas</span> 
                    </a>
                    <ul class="collapse list-unstyled" id="leaguesSubMenu">
                    	<%for(Country oCountry : lstCountries){ %>
                    	<li title="<%=oCountry.getName() %>" >
							<a href="#" onclick="return getCountry('<%=oCountry.getId()%>');"><img src="media/flags/<%=oCountry.getAbbreviation().toLowerCase() %>.png"><%=oCountry.getName() %></a>
                        </li>
                    	<%} %>
                    </ul>
                </li>
                <li title="Estatísticas" >
                    <a href="#">
                        <i class="fas fa-chart-bar"></i>
                        <span class="nameOfLinks">Estatísticas</span>  
                    </a>
                </li>
                <li title="Prognósticos" >
                    <a href="#">
                        <i class="fas fa-clipboard-list"></i>
                        <span class="nameOfLinks">Prognósticos</span> 
                    </a>
                </li>
                <li title="Histórico" >
                    <a href="#">
                        <i class="fas fa-history"></i>
                        <span class="nameOfLinks">Histórico</span> 
                    </a>
                </li>
                <li title="Forum" >
                    <a href="#">
                        <i class="fas fa-comment"></i>
                        <span class="nameOfLinks">Forum</span>  
                    </a>
                </li>
                <li title="FAQ" >
                    <a href="#">
                        <i class="fas fa-question"></i>
                        <span class="nameOfLinks">FAQ</span> 
                    </a>
                </li>
                <li title="Contactos" >
                    <a href="#">
                        <i class="fas fa-paper-plane"></i>
                        <span class="nameOfLinks">Contactos</span>  
                    </a>
                </li>
            </ul>

            <ul class="list-unstyled CTAs">
                <li>
                    <a href="" class="download">Download source</a>
                </li>
            </ul>
        </nav>
</form>
        <!-- Page Content  -->
        <div id="content" style="background-color: rgb(230, 230, 230);">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel" style="width: 100%">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <span class="d-block w-100">Benfica 1 - 0 Porto&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                </div>
                                <div class="carousel-item">
                                    <span class="d-block w-100">Benfica 2 - 0 Porto&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                </div>
                                <div class="carousel-item">
                                    <span class="d-block w-100">Benfica 3 - 0 Porto&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>

       <div class="row" style="height: 80%!important; margin-right: 0px!important;">
                <div class="col-sm-4" style="overflow: hidden; position: relative">
                    <div class="box" style="box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);  background: #fff; height: 100%; width: 97%; position: absolute; padding: 10px 10px;">
                         <div id="teams-logos">
        <div id="sidebar2">
        <ul class="list-unstyled components" >
        <%for(Team oTeam : lstTeams) {%>
       		<li title="<%=oTeam.getName() %>">
                    <a href="#">
                        <img class="logos-teams" src="media/Clubes/<%=nameCountry %>/Logos/<%=oTeam.getAbbreviation().toLowerCase() %>.png">
                        <span class="nameOfLinks"><%=oTeam.getName() %></span>
                    </a>
                </li>
        <%} %>
            </ul>
        
        
          </div>
        
          </div>
        </div>
         
          </div>
          
          <div class="col-sm-8" style="overflow: hidden; position: relative; ">
	          <div class="box" style="box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);  background: #fff; height: 100%; width: 97%; position: absolute; padding: 10px 10px;">
	        <table class="table">
            <thead>
            	<tr>
              		<th><span class="fas fa-chevron-left" aria-hidden="true" style="cursor: pointer;"></span></th>
              		<th colspan="2" style="text-align: center;">Jornada 1</th>
              		<th><span class="fas fa-chevron-right" aria-hidden="true" style="cursor: pointer;" onclick="getRound()"></span></th>
              	</tr>
            </thead>
            <tbody>
        <%for(int i = 0 ; i < lstGames.size() ; i++){ %>
              <tr>
                <td style="width: 15%;"><img class="logoImg" src="media/Clubes/<%=nameCountry %>/Logos/<%=lstGames.get(i).getHomeAbbreviation().toLowerCase() %>.png" /></td>
                <td style="width: 35%;"><a class="textTable"><%=lstGames.get(i).getNameHomeTeam() %></a></td>
                <td style="width: 35%;"><a class="textTable"><%=lstGames.get(i).getNameAwayTeam() %></a></td>
                <td style="width: 15%;"><img class="logoImg" src="media/Clubes/<%=nameCountry %>/Logos/<%=lstGames.get(i).getAwayAbbreviation().toLowerCase() %>.png" /></td>
              </tr>
        <%} %> 
            </tbody>
            <tfoot></tfoot>
          </table>
	          </div>
          </div>
          </div>						
          																						
      </div>																				
    </div>


    <!-- jQuery CDN - Slim version (=without AJAX) -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js">
    
	<!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
            $('.carousel').carousel({
                interval: 5000
            })
        });
        
        function getRound(){
        	alert('1');

            $.ajax({
                url: "<%=request.getContextPath()%>/AjaxServlet?cmd=<%=AjaxServlet.CMD_GET_GAME_ROUND%>",
                data: { 
                    "round": 2
                },
                cache: false,
                type: "POST",
                success: function(response) {
					console.log(response);
                },
                error: function(xhr) {

                }
            });
        }
        
        function getCountry(idCountry){
        	$('#form-menu-idCountry').val(idCountry);
        	$('#form-menu-cmd').val('<%=FrontOfficeServlet.CMD_GET_LEAGUE_PAGE%>');
        	$('#form-menu').submit();
        }
        
    </script>
</body>

</html>