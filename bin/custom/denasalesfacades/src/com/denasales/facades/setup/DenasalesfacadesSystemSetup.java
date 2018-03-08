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
package com.denasales.facades.setup;

import static com.denasales.facades.constants.DenasalesfacadesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.denasales.facades.constants.DenasalesfacadesConstants;
import com.denasales.facades.service.DenasalesfacadesService;


@SystemSetup(extension = DenasalesfacadesConstants.EXTENSIONNAME)
public class DenasalesfacadesSystemSetup
{
	private final DenasalesfacadesService denasalesfacadesService;

	public DenasalesfacadesSystemSetup(final DenasalesfacadesService denasalesfacadesService)
	{
		this.denasalesfacadesService = denasalesfacadesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		denasalesfacadesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return DenasalesfacadesSystemSetup.class.getResourceAsStream("/denasalesfacades/sap-hybris-platform.png");
	}
}
