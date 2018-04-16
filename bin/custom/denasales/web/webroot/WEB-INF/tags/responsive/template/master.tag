<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true"%>
<%@ attribute name="metaDescription" required="false"%>
<%@ attribute name="metaKeywords" required="false"%>
<%@ attribute name="pageCss" required="false" fragment="true"%>
<%@ attribute name="pageScripts" required="false" fragment="true"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="addonScripts"
	tagdir="/WEB-INF/tags/responsive/common/header"%>
<%@ taglib prefix="generatedVariables"
	tagdir="/WEB-INF/tags/shared/variables"%>
<%@ taglib prefix="debug" tagdir="/WEB-INF/tags/shared/debug"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="htmlmeta" uri="http://hybris.com/tld/htmlmeta"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<!DOCTYPE html>
<html lang="${fn:escapeXml(currentLanguage.isocode)}">
<head>
<title>${not empty pageTitle ? pageTitle : not empty cmsPage.title ? fn:escapeXml(cmsPage.title) : ''}
</title>

<%-- Meta Content --%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">

<%-- Favourite Icon --%>
<spring:theme code="img.favIcon" text="/" var="favIconPath" />

<c:choose>
	<%-- if empty webroot, skip originalContextPath, simply use favIconPath --%>
	<c:when test="${fn:length(originalContextPath) eq 1}">
		<link rel="shortcut icon" type="image/x-icon" media="all"
			href="${favIconPath}" />
	</c:when>
	<c:otherwise>
		<link rel="shortcut icon" type="image/x-icon" media="all"
			href="${originalContextPath}${favIconPath}" />
	</c:otherwise>
</c:choose>

<%-- Inject any additional CSS required by the page --%>
<jsp:invoke fragment="pageCss" />

</head>

<body
	class="${pageBodyCssClasses} ${cmsPageRequestContextData.liveEdit ? ' yCmsLiveEdit' : ''} language-${fn:escapeXml(currentLanguage.isocode)}"
	style="margin: 0 !important;">

	<%-- Inject the page body here --%>
	<jsp:doBody />

	<%-- Load JavaScript required by the site --%>
	<template:javaScript />

	<%-- Inject any additional JavaScript required by the page --%>
	<jsp:invoke fragment="pageScripts" />
</body>
</html>
