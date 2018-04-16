<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="cms" tagdir="/WEB-INF/tags/responsive/template/cms"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>

<c:url value="/" var="siteRootUrl" />

<template:javaScriptVariables/>

<%-- jquery --%>
<script type="text/javascript" src="${commonResourcePath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${commonResourcePath}/js/jquery-ui-1.12.1.min.js"></script>

<script type="text/javascript" src="${commonResourcePath}/js/_autoload.js"></script>

