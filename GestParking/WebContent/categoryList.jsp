<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>

<body id="page-top">

	<div id="wrapper">

		<jsp:include page="sideTopBar.jsp"></jsp:include>

		<div class="container">
			<!-- Page Heading -->
			<h1 class="h3 mb-2 text-gray-800">Gest Parking</h1>


			<!-- DataTales Example -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Liste des
						Categories</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>id</th>
									<th>Nom Categorie</th>
									<th>Action</th>

								</tr>
							</thead>

							<tbody>
								<c:forEach var="category" items="${listCategory }">

									<tr>
										<td>${category.id }</td>
										<td>${category.categoryName }</td>
										<td><a href="category/edit?id=${category.id}"
											class="btn btn-success">Modifier</a>
											<a
											href="category/delete?id=${category.id}"
											class="btn btn-danger">Supprimer</a></td>
									</tr>

								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>
			</div>

			<!-- /.container-->


		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>