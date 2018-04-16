<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="unit" required="true" type="java.lang.String"%>
<%@ attribute name="currencies" required="false" type="java.util.List"%>

<div id="i18nModal-${unit}" class="i18nModal">
	<div class="modal-content">
		<span class="close">&times;</span>
		<p class="i18nModalText">Choose a ${unit}</p>
		<form id="currency-form" action="/${siteUid}/_i18n_/currency"
			method="post">
			<div class="i18nDropDownMenu">
				<select name="code">
					<option selected disabled hidden> </option>
					<c:forEach items="${currencies}" var="currency" varStatus="rows">
						<option value="${currency.isocode}">${currency.symbol}${currency.isocode}</option>
					</c:forEach>
				</select>
			</div>
			<button class="modalButton modalIndigo">Select</button>
		</form>
	</div>
</div>