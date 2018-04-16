<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:url value="/search/" var="searchUrl" />
<spring:url value="/search/autocomplete/{/componentuid}"
	var="autocompleteUrl" htmlEscape="false">
	<spring:param name="componentuid" value="${component.uid}" />
</spring:url>

<div class="">
	<form name="search_form_${fn:escapeXml(component.uid)}" method="get"
		action="${searchUrl}">
		<div class="">
			<spring:theme code="search.placeholder" var="searchPlaceholder" />

			<input type="text" id="js-site-search-input"
				class="form-control js-site-search-input" name="text" value=""
				maxlength="100" placeholder="${searchPlaceholder}"
				data-options='{"autocompleteUrl" : "${autocompleteUrl}",
				"minCharactersBeforeRequest" : "${component.minCharactersBeforeRequest}",
				"waitTimeBeforeRequest" : "${component.waitTimeBeforeRequest}",
				"displayProductImages" : ${component.displayProductImages}}'>

			<span class="input-group-btn"> 
					<button class="js_search_button" type="submit"	disabled="true" style="height: 17px;">
						<span class="">Search</span>
					</button>
			</span>
		</div>
	</form>

</div>
