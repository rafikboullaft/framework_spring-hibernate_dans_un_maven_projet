<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Etudiant Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Gestion des Etudinats
</h1>

<%-- <table>
		<tr>
		<td>
			<form:label path="code">
				<spring:message text="Code"/>
			</form:label>
		</td>
		<td>
			<form:input path="code" />
		</td> 
		<td><input type="submit"
					value="<spring:message text="Afficher"/>" /></td>
		
	</tr>

</table> --%>


<c:url var="addAction" value="/etudiant/add" ></c:url>

<form:form action="${addAction}" commandName="etudiant">
<h3>Rcherche:</h3>
<%--  <table>
		<tr>
		<td>
			<form:label path="code">
				<spring:message text="Code"/>
			</form:label>
		</td>
		<td>
			<form:input path="code" />
		</td> 
		<td><input type="submit"
					value="<spring:message text="Afficher"/>" /></td>
		
	</tr>

</table> --%>
<hr>
<h3> Edition</h3>
<table>
	<%-- <c:if test="${!empty etudiant.nom}">
	<tr>
		<td>
			<form:label path="code">
				<spring:message text="Code"/>
			</form:label>
		</td>
		<td>
			<form:input path="code" readonly="true" size="8"  disabled="true" />
			<form:hidden path="code" />
		</td> 
	</tr>
	</c:if> --%>
		<tr>
		<td>
			<form:label path="code">
				<spring:message text="Code"/>
			</form:label>
		</td>
		<td>
			<form:input path="code" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="nom">
				<spring:message text="Nom"/>
			</form:label>
		</td>
		<td>
			<form:input path="nom" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="prenom">
				<spring:message text="Prenom"/>
			</form:label>
		</td>
		<td>
			<form:input path="prenom" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="age">
				<spring:message text="Age"/>
			</form:label>
		</td>
		<td>
			<form:input path="age" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="ville">
				<spring:message text="Ville"/>
			</form:label>
		</td>
		<td>
			<form:input path="ville" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty etudiant.nom}">
				<input type="submit"
					value="<spring:message text="Edit Etudiant"/>" />
			</c:if>
			<c:if test="${empty etudiant.nom}">
				<input type="submit"
					value="<spring:message text="enregistrer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<hr>
<h3>Affichage:</h3>
<c:if test="${!empty listEtudiants}">
	<table class="tg">
	<tr>
		<th width="80">CODE</th>
		<th width="120">NOM</th>
		<th width="120">PRENOM</th>
		<th width="120">AGE</th>
		<th width="120">VILLE</th>
		<th width="60">Modifier</th>
		<th width="60">Supprimer</th>
	</tr>
	<c:forEach items="${listEtudiants}" var="etudiant">
		<tr>
			<td>${etudiant.code}</td>
			<td>${etudiant.nom}</td>
			<td>${etudiant.prenom}</td>
			<td>${etudiant.age}</td>
			<td>${etudiant.ville}</td>
			<td><a href="<c:url value='/edit/${etudiant.code}' />" >Modifier</a></td>
			<td><a href="<c:url value='/remove/${etudiant.code}' />" >Supprimer</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
