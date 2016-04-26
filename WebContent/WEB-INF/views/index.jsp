<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/t/dt/dt-1.10.11/datatables.min.js"></script>

<script type="text/javascript" src="resources/js/dungeonCrawler.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/t/dt/dt-1.10.11/datatables.min.css" />



<title>Super fun text adventure!</title>
</head>
<body>
	<div class="container bs-docs-container" role="main">

		<jsp:include page="/includes/modal.jsp" />
		<div id="wrapper" class="toggled">

			<div id="sidebar-wrapper" class="toggled">
				<jsp:include page="/includes/menu.jsp" />
			</div>


			<div>
				<a id="menu-toggle" class="pull-right" href="#menu-toggle"><span
					class="glyphicon glyphicon-align-justify" aria-hidden="true"></span></a>
			</div>

			<div id="page-content-wrapper" class="col-md-8">
				<div class="panel panel-default">
					<div id="game_input_panel" class="panel-body">
						<p id="game_input"></p>
					</div>
				</div>
				<jsp:include page="/includes/buttons.jsp" />
				<jsp:include page="/includes/jumbotron.jsp" />
			</div>
		</div>
	</div>
</body>
</html>