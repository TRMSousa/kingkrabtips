<%@page import="com.king.krab.tips.servlet.MainLoginServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Login &amp; Register Templates</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/form-elements.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="<%=request.getContextPath() %>/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath() %>/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath() %>/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath() %>/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath() %>/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body style="background-image: url('<%=request.getContextPath()%>/assets/img/backgrounds/1.jpg');">

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>BET KRAB</strong></h1>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Login</h3>
	                            		<p>Insira email e password:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-lock"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="<%=request.getContextPath() %>/MainLoginServlet" method="post" class="login-form">
				                    	<input type="hidden" name="cmd" id="form-login-user-cmd" value="<%=MainLoginServlet.CMD_LOGIN %>" />

				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-login-user-username">Email</label>
				                        	<input type="text" name="form-login-user-username" placeholder="Email..." class="form-username form-control" id="form-username">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-login-user-password">Password</label>
				                        	<input type="password" name="form-login-user-password" placeholder="Password..." class="form-password form-control" id="form-password">
				                        </div>
				                        <button type="submit" class="btn">ENTRAR</button>
				                    </form>
			                    </div>
		                    </div>
                        </div>
                        
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        	
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Registe-se</h3>
	                            		<p>Preencha os campos:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="<%=request.getContextPath() %>/MainLoginServlet" method="post" class="registration-form">
				                    	<input type="hidden" name="cmd" id="form-sign-user-cmd" value="<%=MainLoginServlet.CMD_LOGIN %>" />
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-sign-user-first-name">Primeiro Nome</label>
				                        	<input type="text" name="form-sign-user-first-name" placeholder="Primeiro Nome..." class="form-first-name form-control" id="form-first-name">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-sign-user-Last-name">Último Nome</label>
				                        	<input type="text" name="form-sign-user-last-name" placeholder="Último Nome..." class="form-last-name form-control" id="form-last-name">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-sign-user-email">Email</label>
				                        	<input type="text" name="form-sign-user-email" placeholder="Email..." class="form-email form-control" id="form-email">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-sign-user-password">Email</label>
				                        	<input type="text" name="form-sign-user-password" placeholder="Password..." class="form-password form-control" id="form-password">
				                        </div>
				                        <button type="submit" class="btn">Inscrever-me!</button>
				                    </form>
			                    </div>
                        	</div>
                        	
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>

		<!-- Javascript -->
        <script src="<%=request.getContextPath() %>/assets/js/jquery-1.11.1.min.js"></script>
        <script src="<%=request.getContextPath() %>/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/jquery.backstretch.min.js"></script>
        <script src="<%=request.getContextPath() %>/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>