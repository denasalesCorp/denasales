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
package com.denasales.services.footer;

import de.hybris.platform.catalog.model.CatalogVersionModel;

import com.denasales.core.model.CMSFooterColumnsParagraphComponentModel;


/**
 *
 */
public interface FooterComponentsService
{
	CMSFooterColumnsParagraphComponentModel getFooterColumnsComponentByUid(final String uid, CatalogVersionModel catalogVersion);
}
