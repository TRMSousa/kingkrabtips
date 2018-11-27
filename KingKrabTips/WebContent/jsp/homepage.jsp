<%@page import="com.king.krab.tips.objects.Team"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.king.krab.tips.objects.Country"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

  <title>Hello, worlds!</title>

  <style>

    body {font-family: PremierSans-Regular,Arial,Helvetica Neue,Helvetica,sans-serif; font-weight: 400; text-align: center; max-width: 100%;}

    .flag {display: inline-block;} 
    .bottomLineFlag {border-bottom: 5px solid #E90052;} 
    
    .flagImg        {position: relative; width: 50px; height: 30px;}
    .flagOpacity    {opacity: 0.2;} 
    .flagNoOpacity  {opacity: 1.0;} 

    .logoImg        {floag: left; width: 30px; height: 30px;}

    img:hover {opacity: 1.0;}

    .titleBox {font-family: PremierSans-Bold,Arial,Helvetica Neue,Helvetica,sans-serif; font-size: 1.2rem; color: white!important; }

    .twoColors1{background-color: #38003C; background-image: -webkit-linear-gradient(50deg, #38003C 50%, #916F9F 50%); min-height: 100px;}
    
    .twoColors2{background-color: #916F9F; background-image: -webkit-linear-gradient(310deg, #916F9F 50%, #38003C 50%); min-height: 100px;}

    .tabFlag{border-bottom: 3px solid #E90052; }    
    
    .roseLine {height: 3px; width: 100%; background: #E90052; display: block;}    
  	
  	.textTable {display:block; text-align: left; font-family: PremierSans-Bold,Arial,Helvetica Neue,Helvetica,sans-serif; font-size: 0.8rem; color: black!important; }
  </style>

<%
	List<Country> lstCountries	= request.getAttribute("lstCountries") 	== null ? new ArrayList<Country>()	: (List<Country>) request.getAttribute("lstCountries");
	List<Team> lstTeams			= request.getAttribute("lstTeams") 		== null ? new ArrayList<Team>()		: (List<Team>) request.getAttribute("lstTeams");
%>

</head>

<body>
  <div class="container-fluid">
    <div class="header_tips">
      <div class="header_tips_1" style="height: 100px; background-color: #916F9F;">
        <div class="row">
          <div class="col-sm-1 col-md-1 twoColors1"></div>
          <div class="col-sm-10 col-md-10" style="text-align: center; margin-top: 10px;">
		<%for(Country oCountry : lstCountries){ %>
            <div class="flag"><img class="flagImg flagOpacity" src="media/flags/<%=oCountry.getAbbreviation().toLowerCase() %>.png" /></div>
		<%} %>
          </div>
          <div class="col-sm-1 col-md-1 twoColors2"></div>
        </div>
      </div>
    </div>

    <div class="row" style="height: 5px; background: #E90052; margin-bottom: 10px;"></div>

    <div class="row">
      <div class="col-sm-4" style="margin-left: 10px; margin-right: 10px;">
        <div class="roseLine"></div>
        <div>
        <div class="table-responsive">
          <table class="table">
            <thead>
            	<tr>
              		<th colspan="4">Clubes</th>
              </tr>
            </thead>
            <tbody>
        <%for(int i = 0 ; i < lstTeams.size() ; i+=2){ %>
              <tr>
                <td style="width: 15%;"><img class="logoImg" src="media/clubs_logos/<%=lstTeams.get(i).getAbbreviation().toLowerCase() %>.gif" /></td>
                <td style="width: 35%;"><a class="textTable"><%=lstTeams.get(i).getName() %></a></td>
                <td style="width: 15%;"><img class="logoImg" src="media/clubs_logos/<%=lstTeams.get(i+1).getAbbreviation().toLowerCase() %>.gif" /></td>
                <td style="width: 35%;"><a class="textTable"><%=lstTeams.get(i+1).getName() %></a></td>
              </tr>
        <%} %>
            </tbody>
            <tfoot></tfoot>
          </table>
          </div>
        </div>
      </div>
      <div class="col" style="margin-left: 10px; margin-right: 10px;">
        <div class="roseLine"></div>
		<div>
        <div class="table-responsive">
          <table class="table">
            <thead>
            	<tr>
              		<th><span class="fas fa-chevron-left" aria-hidden="true" style="cursor: pointer;"></span></th>
              		<th>Jornada 1</th>
              		<th><span class="fas fa-chevron-right" aria-hidden="true" style="cursor: pointer;"></span></th>
              	</tr>
            </thead>
            <tbody>
        <%-- <%for(int i = 0 ; i < lstTeams.size() ; i+=2){ %>
              <tr>
                <td style="width: 15%;"><img class="logoImg" src="media/clubs_logos/<%=lstTeams.get(i).getAbbreviation().toLowerCase() %>.gif" /></td>
                <td style="width: 35%;"><a class="textTable"><%=lstTeams.get(i).getName() %></a></td>
                <td style="width: 15%;"><img class="logoImg" src="media/clubs_logos/<%=lstTeams.get(i+1).getAbbreviation().toLowerCase() %>.gif" /></td>
                <td style="width: 35%;"><a class="textTable"><%=lstTeams.get(i+1).getName() %></a></td>
              </tr>
        <%} %> --%>
            </tbody>
            <tfoot></tfoot>
          </table>
          </div>
        </div>
      </div>
      <div class="col" style="background: #17181C; height: 300px; margin-left: 10px; margin-right: 10px;">
        <div class="roseLine"></div>
        <div style="height: 30px;">
          <a class="titleBox">Classificação</a>
        </div>
      </div>
    </div>

  </div>

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
  <script src=" https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</body>



<script type="text/javascript">
  $(document).ready(function () {
    $('.flag').click(function () {
      var bottomLineClass = "bottomLineFlag";
      if (!$(this).hasClass(bottomLineClass)) {
        removeClassOfActiveItems(bottomLineClass);
        $(this).addClass(bottomLineClass);
        removeClassOfActiveItems('flagNoOpacity', 'flagOpacity');
        $(this).children().removeClass('flagOpacity');
        $(this).children().addClass('flagNoOpacity');
      }
    })
  });

  function removeClassOfActiveItems(nameClass, newClass) {
    $('.' + nameClass).each(function () {
      if ($(this).hasClass(nameClass)) {
        $(this).removeClass(nameClass);
        if (newClass != '') {
          $(this).addClass(newClass);
        }
      }
    });
  }

</script>

</html>