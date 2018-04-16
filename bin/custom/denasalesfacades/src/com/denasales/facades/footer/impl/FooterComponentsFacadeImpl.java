package com.denasales.facades.footer.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;

import com.denasales.core.model.CMSFooterColumnsParagraphComponentModel;
import com.denasales.facades.data.FooterColumnsData;
import com.denasales.facades.footer.FooterComponentsFacade;
import com.denasales.services.footer.FooterComponentsService;


public class FooterComponentsFacadeImpl implements FooterComponentsFacade
{

	private FooterComponentsService footerComponentsService;
	private CatalogVersionService catalogVersionService;
	private Converter<CMSFooterColumnsParagraphComponentModel, FooterColumnsData> footerColumnsComponentConverter;

	@Override
	public FooterColumnsData getFooterColumnsData()
	{
		final CatalogVersionModel catalogVersion = catalogVersionService.getCatalogVersion("denasalesContentCatalog", "Online");
		final CMSFooterColumnsParagraphComponentModel footerColumnsComponent = footerComponentsService
				.getFooterColumnsComponentByUid("footerColumnsParagraphComponent", catalogVersion);
		final FooterColumnsData componentData = footerColumnsComponentConverter.convert(footerColumnsComponent);
		return componentData;
	}

	@Required
	public void setFooterComponentsService(final FooterComponentsService footerComponentsService)
	{
		this.footerComponentsService = footerComponentsService;
	}

	@Required
	public void setCatalogVersionService(final CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}

	public Converter<CMSFooterColumnsParagraphComponentModel, FooterColumnsData> getFooterColumnsComponentConverter()
	{
		return footerColumnsComponentConverter;
	}

	@Required
	public void setFooterColumnsComponentConverter(
			final Converter<CMSFooterColumnsParagraphComponentModel, FooterColumnsData> footerColumnsComponentConverter)
	{
		this.footerColumnsComponentConverter = footerColumnsComponentConverter;
	}

}
