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
package com.denasales.core.interceptors;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.util.localization.Localization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.denasales.core.model.CMSFooterColumnsParagraphComponentModel;


public class FooterColumnsParagraphComponentPrepareInterceptor
		implements PrepareInterceptor<CMSFooterColumnsParagraphComponentModel>
{
	private static final String CMS_FOOTER_COLUMNS_PARAGRAPH_COMPONENT_NEW_VALUE = "CMSFooterColumnsParagraphComponent.newValue";
	private static final String NEW_VALUE_NAME_IS_EMPTY_MASSAGE = "FooterColumnsComponent.newValueName.isEmptyMassage";
	private static final String NEW_COLUMN_NAME_IS_EMPTY_MASSAGE = "FooterColumnsComponent.newColumnName.isEmptyMassage";

	@Override
	public void onPrepare(final CMSFooterColumnsParagraphComponentModel component, final InterceptorContext context)
			throws InterceptorException
	{
		if (!newValueIsValid(component))
		{
			return;
		}

		if (component.isRemove())
		{
			removeValue(component);
		}
		else
		{
			addColumnValue(component);
		}
		component.setNewColumnName(StringUtils.EMPTY);
		component.setNewReferenceForColumnValue(StringUtils.EMPTY);
		component.setNewValueName(StringUtils.EMPTY);
	}

	/**
	 *
	 */
	private void removeValue(final CMSFooterColumnsParagraphComponentModel component)
	{
		final String newColumnName = component.getNewColumnName();
		final String newValueName = component.getNewValueName();
		final String newReferenceForColumnValue = component.getNewReferenceForColumnValue();
		Map<String, List<String>> columns = component.getColumns();

		if (MapUtils.isEmpty(columns))
		{
			columns = new HashMap<>();
			return;
		}
		else
		{
			columns = new HashMap<>(columns);
		}

		if (isColumnWasRemoved(component, newColumnName, newValueName, newReferenceForColumnValue, columns))
		{
			return;
		}

		final List<String> columnValues = columns.get(newColumnName);
		if (CollectionUtils.isEmpty(columnValues))
		{
			return;
		}

		final List<String> newValues = getNewValues(newValueName, newReferenceForColumnValue, columnValues);

		columns.put(newColumnName, newValues);
		component.setColumns(columns);
	}

	/**
	 *
	 */
	private boolean isColumnWasRemoved(final CMSFooterColumnsParagraphComponentModel component, final String newColumnName,
			final String newValueName, final String newReferenceForColumnValue, final Map<String, List<String>> columns)
	{
		if (StringUtils.isEmpty(newValueName) && StringUtils.isEmpty(newReferenceForColumnValue))
		{
			columns.remove(newColumnName);
			component.setColumns(columns);
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	private List<String> getNewValues(final String newValueName, final String newReferenceForColumnValue,
			final List<String> columnValues)
	{
		List<String> newValues = null;
		if (StringUtils.isNotEmpty(newValueName) && StringUtils.isEmpty(newReferenceForColumnValue))
		{
			newValues = columnValues.stream().filter(value -> !value.contains(">" + newValueName + "<"))
					.collect(Collectors.toList());
		}
		else if (StringUtils.isEmpty(newValueName) && StringUtils.isNotEmpty(newReferenceForColumnValue))
		{
			newValues = columnValues.stream().filter(value -> !value.contains("\"" + newReferenceForColumnValue + "\""))
					.collect(Collectors.toList());
		}
		else
		{
			final String link = Localization.getLocalizedString(CMS_FOOTER_COLUMNS_PARAGRAPH_COMPONENT_NEW_VALUE, new Object[]
			{ newReferenceForColumnValue, newValueName });
			newValues = columnValues.stream().filter(value -> !Objects.equals(value, link)).collect(Collectors.toList());
		}
		return newValues;
	}

	/**
	 *
	 */
	private boolean newValueIsValid(final CMSFooterColumnsParagraphComponentModel component) throws InterceptorException
	{
		final String newColumnName = component.getNewColumnName();
		final String newValueName = component.getNewValueName();
		final String newReferenceForColumnValue = component.getNewReferenceForColumnValue();
		if (StringUtils.isEmpty(newColumnName) && StringUtils.isEmpty(newValueName)
				&& StringUtils.isEmpty(newReferenceForColumnValue))
		{
			return false;
		}
		if (StringUtils.isEmpty(newValueName) && !component.isRemove())
		{
			throw new InterceptorException(Localization.getLocalizedString(NEW_VALUE_NAME_IS_EMPTY_MASSAGE));
		}
		if (StringUtils.isEmpty(newColumnName))
		{
			throw new InterceptorException(Localization.getLocalizedString(NEW_COLUMN_NAME_IS_EMPTY_MASSAGE));
		}

		return true;
	}

	private void addColumnValue(final CMSFooterColumnsParagraphComponentModel component)
	{
		final String newColumnName = component.getNewColumnName();
		String newValueName = component.getNewValueName();
		final String newReferenceForColumnValue = component.getNewReferenceForColumnValue();

		Map<String, List<String>> columns = component.getColumns();
		if (columns == null)
		{
			columns = new HashMap<>();
		}
		else
		{
			columns = new HashMap<>(columns);
		}
		if (CollectionUtils.isEmpty(columns.get(newColumnName)))
		{
			columns.put(newColumnName, new ArrayList<>());
		}
		final List<String> currentColumnValues = new ArrayList<>(columns.get(newColumnName));
		newValueName = Localization.getLocalizedString(CMS_FOOTER_COLUMNS_PARAGRAPH_COMPONENT_NEW_VALUE, new Object[]
		{ newReferenceForColumnValue, newValueName });
		currentColumnValues.add(newValueName);
		columns.put(newColumnName, currentColumnValues);
		component.setColumns(columns);
	}

}
