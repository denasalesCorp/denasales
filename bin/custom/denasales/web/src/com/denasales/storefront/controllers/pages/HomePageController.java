/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.denasales.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denasales.facades.data.FooterColumnsData;
import com.denasales.facades.footer.FooterComponentsFacade;

/**
 * Controller for home page
 */
@Controller
@RequestMapping("/")
public class HomePageController extends AbstractPageController {

    @Resource(name = "footerComponentsFacade")
    private FooterComponentsFacade footerComponentsFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String home(final Model model) throws CMSItemNotFoundException {
        final FooterColumnsData footerColumnsData = footerComponentsFacade.getFooterColumnsData();
        model.addAttribute("footerColumnsData", footerColumnsData);
        storeCmsPageInModel(model, getContentPageForLabelOrId("homepage"));
        return getViewForPage(model);
    }
}
