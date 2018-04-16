<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="unit" required="true" type="java.lang.String"%>
<%@ attribute name="languages" required="false" type="java.util.List"%>

<div id="i18nModal-${unit}" class="i18nModal">
	<div class="modal-content">
		<span class="close">&times;</span>
		<p class="i18nModalText">Choose a ${unit}</p>
		<form id="lang-form" action="/${siteUid}/_i18n_/language"
			method="post">
			<div class="i18nDropDownMenu">
				<select name="code">
					<option selected disabled hidden> </option>
					<c:forEach items="${languages}" var="lang" varStatus="rows">
						<option value="${lang.isocode}">${lang.name}</option>
					</c:forEach>
				</select>
			</div>
			<button class="modalButton modalIndigo">Select</button>
		</form>

	</div>
</div>