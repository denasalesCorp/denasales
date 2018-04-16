<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
	<thead>
		<tr>
			<c:forEach items="${footerColumnsData.columnNames}" var="name">
				<th>${name}</th>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${footerColumnsData.rows}" var="row">
			<tr>
				<c:forEach items="${row}" var="value">
					<th>${value}</th>
				</c:forEach>
			</tr>
		</c:forEach>
	</tbody>
</table>