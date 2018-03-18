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
package com.denasales.initialdata.setup;

import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;

import java.util.ArrayList;
import java.util.List;

import com.denasales.initialdata.constants.DenasalesinitialdataConstants;


@SystemSetup(extension = DenasalesinitialdataConstants.EXTENSIONNAME, process = Process.ALL, type = Type.PROJECT)
public class DenasalesSystemSetup extends AbstractSystemSetup
{
	private static final String FALSE = "false";
	private static final String TRUE = "true";

	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		final SystemSetupParameter coreData = new SystemSetupParameter("coreData");
		coreData.setLabel("Create core data?");
		coreData.addValue(TRUE, true);
		coreData.addValue(FALSE);
		params.add(coreData);

		final SystemSetupParameter categories = new SystemSetupParameter("categories");
		categories.setLabel("Create categories?");
		categories.addValue(TRUE, true);
		categories.addValue(FALSE);
		params.add(categories);

		final SystemSetupParameter products = new SystemSetupParameter("products");
		products.setLabel("Create products?");
		products.addValue(TRUE, true);
		products.addValue(FALSE);
		params.add(products);

		return params;
	}

	@SystemSetup(extension = DenasalesinitialdataConstants.EXTENSIONNAME, type = Type.PROJECT, process = Process.ALL)
	public void createCoreData(final SystemSetupContext context) throws Exception
	{
		if (TRUE.equalsIgnoreCase(context.getParameter(DenasalesinitialdataConstants.EXTENSIONNAME + "_coreData")))
		{
			importImpexFile(context, "/denasalesinitialdata/import/coredata/common/essential-data.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/productCatalogs/denasalesProductCatalog/catalog.impex",
					true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/productCatalogs/denasalesProductCatalog/catalog_en.impex", true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/productCatalogs/denasalesProductCatalog/catalog_de.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/contentCatalogs/denasalesContentCatalog/catalog.impex",
					true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/contentCatalogs/denasalesContentCatalog/catalog_en.impex", true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/contentCatalogs/denasalesContentCatalog/catalog_de.impex", true);

			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/contentCatalogs/denasalesContentCatalog/cms-content.impex", true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/contentCatalogs/denasalesContentCatalog/cms-content_en.impex", true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/contentCatalogs/denasalesContentCatalog/cms-content_de.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/store.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/store_en.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/store_de.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/store-responsive.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/store-responsive_en.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/store-responsive_de.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/site-responsive.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/site-responsive_en.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/site-responsive_de.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/site.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/site_en.impex", true);
			importImpexFile(context, "/denasalesinitialdata/import/coredata/stores/denasales/site_de.impex", true);

			importImpexFile(context, "/denasalesinitialdata/import/coredata/syncjobs.impex");
		}
	}

	@SystemSetup(extension = DenasalesinitialdataConstants.EXTENSIONNAME, type = Type.PROJECT, process = Process.ALL)
	public void createCategoriesData(final SystemSetupContext context) throws Exception
	{
		if (TRUE.equalsIgnoreCase(context.getParameter(DenasalesinitialdataConstants.EXTENSIONNAME + "_categories")))
		{
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/productCatalogs/denasalesProductCatalog/categories.impex", true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/productCatalogs/denasalesProductCatalog/categories_en.impex", true);
			importImpexFile(context,
					"/denasalesinitialdata/import/coredata/productCatalogs/denasalesProductCatalog/categories_de.impex", true);
		}
	}

	@SystemSetup(extension = DenasalesinitialdataConstants.EXTENSIONNAME, type = Type.PROJECT, process = Process.ALL)
	public void createProductsData(final SystemSetupContext context) throws Exception
	{
		if (TRUE.equalsIgnoreCase(context.getParameter(DenasalesinitialdataConstants.EXTENSIONNAME + "_products")))
		{
			// There are no any products at this moment
		}
	}


}
