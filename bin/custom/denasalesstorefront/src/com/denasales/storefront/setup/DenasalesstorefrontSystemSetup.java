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
package com.denasales.storefront.setup;

import static com.denasales.storefront.constants.DenasalesstorefrontConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.denasales.storefront.constants.DenasalesstorefrontConstants;
import com.denasales.storefront.service.DenasalesstorefrontService;


@SystemSetup(extension = DenasalesstorefrontConstants.EXTENSIONNAME)
public class DenasalesstorefrontSystemSetup
{
	private final DenasalesstorefrontService denasalesstorefrontService;

	public DenasalesstorefrontSystemSetup(final DenasalesstorefrontService denasalesstorefrontService)
	{
		this.denasalesstorefrontService = denasalesstorefrontService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		denasalesstorefrontService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return DenasalesstorefrontSystemSetup.class.getResourceAsStream("/denasalesstorefront/sap-hybris-platform.png");
	}
}
