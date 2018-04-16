<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
	<jsp:attribute name="pageScripts">
		<script type="text/javascript" src="${commonResourcePath}/js/homepageTemplate.js"></script>
	</jsp:attribute>
	<jsp:attribute name="pageCss">
		<link rel="stylesheet"
			href="${commonResourcePath}/css/homepageTemplate.css">
	</jsp:attribute>
	<jsp:body>
	<cms:pageSlot position="Section1" var="feature" element="div">
		<cms:component component="${feature}" element="div"
				class="no-space yComponentWrapper" />
	</cms:pageSlot>

	<cms:pageSlot position="Section2" var="feature" element="div">
		<cms:component component="${feature}" element="div"
				class="no-space yComponentWrapper" />
	</cms:pageSlot>

	<cms:pageSlot position="Section3" var="feature" element="div">
		<cms:component component="${feature}" element="div"
				class="no-space yComponentWrapper" />
	</cms:pageSlot>

	<cms:pageSlot position="Section4" var="feature" element="div"
			class="row no-margin">
		<cms:component component="${feature}" element="div"
				class="col-xs-6 col-md-3 no-space yComponentWrapper" />
	</cms:pageSlot>

	<cms:pageSlot position="Section5" var="feature" element="div">
		<cms:component component="${feature}" element="div"
				class="yComponentWrapper" />
	</cms:pageSlot>
	</jsp:body>
</template:page>
