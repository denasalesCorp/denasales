/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package com.denasales.storefront;

import static com.denasales.storefront.constants.DenasalesstorefrontConstants.PLATFORM_LOGO_CODE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denasales.storefront.service.DenasalesstorefrontService;


/**
 *
 */
@Controller
public class SnippetController
{
	@Autowired
	private DenasalesstorefrontService denasalesstorefrontService;
	private static final Logger LOG = LoggerFactory.getLogger(SnippetController.class);

	@RequestMapping(value = "/den", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", denasalesstorefrontService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		LOG.info("HELLO!");
		return "welcome";
	}
}

