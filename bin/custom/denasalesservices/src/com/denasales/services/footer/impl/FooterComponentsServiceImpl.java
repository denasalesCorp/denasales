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
package com.denasales.services.footer.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;

import org.springframework.beans.factory.annotation.Required;

import com.denasales.core.dao.FooterComponentsDao;
import com.denasales.core.model.CMSFooterColumnsParagraphComponentModel;
import com.denasales.services.footer.FooterComponentsService;


/**
 *
 */
public class FooterComponentsServiceImpl implements FooterComponentsService
{

	private FooterComponentsDao footerComponentsDao;

	@Override
	public CMSFooterColumnsParagraphComponentModel getFooterColumnsComponentByUid(final String uid,
			final CatalogVersionModel catalogVersion)
	{
		return footerComponentsDao.getFooterColumnsComponentByUid(uid, catalogVersion);
	}

	@Required
	public void setFooterComponentsDao(final FooterComponentsDao footerComponentsDao)
	{
		this.footerComponentsDao = footerComponentsDao;
	}


}
