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
package com.denasales.core.dao.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import org.springframework.beans.factory.annotation.Required;

import com.denasales.core.dao.FooterComponentsDao;
import com.denasales.core.model.CMSFooterColumnsParagraphComponentModel;


/**
 *
 */
public class FooterComponentsDaoImpl implements FooterComponentsDao
{

	private FlexibleSearchService flexibleSearchService;

	@Override
	public CMSFooterColumnsParagraphComponentModel getFooterColumnsComponentByUid(final String uid,
			final CatalogVersionModel catalogVersion)
	{
		final String query = "SELECT {c:PK} FROM {CMSFooterColumnsParagraphComponent AS c} WHERE {c.catalogVersion}=?catalogVersion"
				+ " AND {c.uid}=?uid";
		final FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query);
		flexibleSearchQuery.addQueryParameter("uid", uid);
		flexibleSearchQuery.addQueryParameter("catalogVersion", catalogVersion);
		return flexibleSearchService.<CMSFooterColumnsParagraphComponentModel> search(flexibleSearchQuery).getResult().get(0);
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

}
