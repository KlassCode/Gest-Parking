<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<!-- Sing in  Form -->
	<div class="main">
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/splash2.png" alt="sing up image">
						</figure>

					</div>

					<div class="signin-form">
						<h2 class="form-title text-info">Gest Parking</h2>
						<form method="POST" class="register-form" id="login-form">
							<c:if test="${ error != null }">
								<div class="alert alert-danger center" role="alert">${ error }</div>
							</c:if>
							
							<c:if test="${ emptyField != null }">
								<div class="alert alert-warning center" role="alert">${ emptyField }</div>
							</c:if>
							
							<div class="form-group">
								<label for="your_name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="your_name"
									placeholder="Nom d'utilisateur" />
							</div>
							<div class="form-group">
								<label for="your_pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="your_pass"
									placeholder="Mot de passe" />
							</div>

							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Se Connecter" />
							</div>
						</form>

					</div>
				</div>
			</div>
		</section>

	</div>
</body>
</html>