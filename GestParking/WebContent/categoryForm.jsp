<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>

<body id="page-top">

	<div id="wrapper">

		<jsp:include page="sideTopBar.jsp"></jsp:include>

		<div class="row">

			<div class="col-lg-8 ml-5">

				<!-- Default Card Example -->
				<div class="card mb-5 m-0 font-weight-bold text-primary">
					<div class="card-header">Ajouter Une Categorie</div>
					<div class="card-body">

						<c:if test="${ emptyField != null }">
							<div class="alert alert-warning" role="alert">
								<c:out value="${emptyField}"></c:out>
							</div>
						</c:if>

						<c:if test="${ success != null }">
							<div class="alert alert-success" role="alert">
								<c:out value="${success}"></c:out>
							</div>
						</c:if>

						<form class="" method="Post" action="add">

							<div class="form-group">
								<input type="text" class="form-control" id="exampleInputEmail"
									aria-describedby="emailHelp"
									placeholder="Nom De la Categorie..." name="nom">
							</div>
							<hr>
							<input type="submit" class="btn btn-primary btn-user"
								name="addCat" value="Valide" />

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>