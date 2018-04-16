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
package com.denasales.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.denasales.core.model.CMSFooterColumnsParagraphComponentModel;
import com.denasales.facades.data.FooterColumnsData;


public class FooterColumnsDataPopulator implements Populator<CMSFooterColumnsParagraphComponentModel, FooterColumnsData>
{

	@Override
	public void populate(final CMSFooterColumnsParagraphComponentModel source, final FooterColumnsData target)
			throws ConversionException
	{
		columnNamesPopulate(source, target);
		rowsPopulate(source, target);
	}

	private void columnNamesPopulate(final CMSFooterColumnsParagraphComponentModel source, final FooterColumnsData target)
	{
		final Map<String, List<String>> columns = source.getColumns();
		if (columns != null)
		{
			final List<String> keys = new ArrayList<>(columns.keySet());
			target.setColumnNames(keys);
		}
		else
		{
			target.setColumnNames(Collections.EMPTY_LIST);
		}
	}

	/**
	 * Rows are tr tags in a html table. One row consists of elements(or empty string) of every column. Example below. If we
	 * have the next table: ColumnName1 ColumnName2 ColumnName3 element11 element21 element31 element12 element22 element32
	 * element13 element23 element33
	 * 
	 * The next list will have in the rows: List:(List1:(element11; element21; element31); List2:(element12; element22;
	 * element32); List3:(element13; element23; element33))
	 */
	private void rowsPopulate(final CMSFooterColumnsParagraphComponentModel source, final FooterColumnsData target)
	{
		final Map<String, List<String>> columns = source.getColumns();
		if (columns != null)
		{
			final List<List<String>> values = new ArrayList<>(columns.values());
			final int longestList = getLongestListSize(values);
			target.setRows(getRows(values, longestList));
		}
		else
		{
			target.setRows(Collections.EMPTY_LIST);
		}
	}

	/**
	 *
	 */
	private List<List<String>> getRows(final List<List<String>> values, final int longestList)
	{
		final List<List<String>> rows = new ArrayList<>();
		int rowNumber = 0;
		for (int i = 0; i < longestList; i++)
		{
			final List<String> row = new ArrayList<>();
			for (final List<String> valueList : values)
			{
				if (rowNumber >= valueList.size())
				{
					row.add(StringUtils.EMPTY);
				}
				else
				{
					row.add(valueList.get(rowNumber));
				}
			}
			rows.add(row);
			rowNumber++;
		}
		return rows;
	}

	/**
	 * @param values
	 * @return Longest list size from the values
	 */
	private int getLongestListSize(final List<List<String>> values)
	{
		int longestList = 0;
		for (final List<String> valueList : values)
		{
			if (valueList.size() > longestList)
			{
				longestList = valueList.size();
			}
		}
		return longestList;
	}

}
