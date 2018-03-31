<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
    <cms:pageSlot position="SiteLogo" var="feature">
        <cms:component component="${feature}" />
    </cms:pageSlot>
    
    <cms:pageSlot position="HeaderLinks" var="feature">
        <cms:component component="${feature}" />
    </cms:pageSlot>

    <cms:pageSlot position="Section1" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="no-space yComponentWrapper"/>
    </cms:pageSlot>
    
    <cms:pageSlot position="Section2" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="no-space yComponentWrapper"/>
    </cms:pageSlot>
    
    <cms:pageSlot position="Section3" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="no-space yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="Section4" var="feature" element="div" class="row no-margin">
        <cms:component component="${feature}" element="div" class="col-xs-6 col-md-3 no-space yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="Section5" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>
    
    <cms:pageSlot position="Footer" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>

</template:page>

Hello!
BillingShippingAddressPage - https://localhost:9002/denasales/billship/ </br>
CheckingBillingShippingAddressPage - https://localhost:9002/denasales/billship/checking</br>
CartPage - https://localhost:9002/denasales/cart/</br>
CategoryPage - https://localhost:9002/denasales/cat/</br>
ContactUsPage - https://localhost:9002/denasales/contactus/</br></br>
FAQPage - https://localhost:9002/denasales/faq/</br>
MyAccountPage - https://localhost:9002/denasales/account/</br>
PostRegistrationPage - https://localhost:9002/denasales/registration/post</br>
RegistrationPage - https://localhost:9002/denasales/registration</br>
ProductDetailsPage - https://localhost:9002/denasales/pdp</br>
ProductListPage - https://localhost:9002/denasales/plp</br>
WishlistPage - https://localhost:9002/denasales/wishlist</br>
WishlistsPage - https://localhost:9002/denasales/wishlist/all</br>