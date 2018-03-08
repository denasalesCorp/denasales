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
package com.denasales.services.setup;

import static com.denasales.services.constants.DenasalesservicesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.denasales.services.constants.DenasalesservicesConstants;
import com.denasales.services.service.DenasalesservicesService;


@SystemSetup(extension = DenasalesservicesConstants.EXTENSIONNAME)
public class DenasalesservicesSystemSetup
{
	private final DenasalesservicesService denasalesservicesService;

	public DenasalesservicesSystemSetup(final DenasalesservicesService denasalesservicesService)
	{
		this.denasalesservicesService = denasalesservicesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		denasalesservicesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return DenasalesservicesSystemSetup.class.getResourceAsStream("/denasalesservices/sap-hybris-platform.png");
	}
}
