<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>

<body id="page-top">

	<div id="wrapper">

		<jsp:include page="sideTopBar.jsp"></jsp:include>

		<div class="row">

			<div class="col-lg-8 ml-5">

				<!-- Default Card Example -->
				<div class="card mb-5 m-0 font-weight-bold text-primary">
					<div class="card-header">Nouveau Vehicule</div>
					<div class="card-body">

						<c:if test="${ errors != null }">
							<div class="alert alert-warning" role="alert">
								<c:out value="${errors}"></c:out>
							</div>
						</c:if>

						<c:if test="${ success != null }">
							<div class="alert alert-success" role="alert">
								<c:out value="${success}"></c:out>
							</div>
						</c:if>

						<form class="" method="Post" action="addVehicule">
							<div class="form-group">
								<label>Categorie</label>
								<select name="listCategory" class="form-control">
									<c:if test="${ fn:length(categorys) gt 0 }">
										<c:forEach var="cat" items="${categorys}">
											<option value='<c:out value="${cat.id}"></c:out>'>
												<c:out value="${cat.categoryName}"></c:out></option>
										</c:forEach>
									</c:if>
									<c:if test="${ fn:length(categorys) eq 0 }">
										<option>Aucune Categorie</option>
									</c:if>
								</select>
							</div>

							<div class="form-group">
								<label>Place</label>
								<select name="listSlot" class="form-control">
									<c:if test="${ fn:length(slots) gt 0 }">
										<c:forEach var="slt" items="${slots}">
											<option value='<c:out value="${slt.id}"></c:out>'>Place
												#
												<c:out value="${slt.id}"></c:out></option>
										</c:forEach>
									</c:if>
									<c:if test="${ fn:length(slots) eq 0 }">
										<option>Aucun Resultat</option>
									</c:if>

								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id=""
									aria-describedby="" placeholder="Vehicule Compagnie"
									name="vehcomp">
							</div>

							<div class="form-group">
								<input type="text" class="form-control" id=""
									aria-describedby="" placeholder="Nom du Proprietaire"
									name="propnom">
							</div>

							<div class="form-group">
								<input type="email" class="form-control" id="exampleInputEmail"
									aria-describedby="emailHelp"
									placeholder="Email du Proprietaire" name="propmail">
							</div>

							<hr>
							<input type="submit" class="btn btn-primary btn-user"
								name="addVeh" value="valide" />

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>