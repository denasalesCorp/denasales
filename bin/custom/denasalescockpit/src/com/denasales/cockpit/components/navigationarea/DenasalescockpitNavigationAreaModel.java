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
package com.denasales.cockpit.components.navigationarea;

import de.hybris.platform.cockpit.components.navigationarea.DefaultNavigationAreaModel;
import de.hybris.platform.cockpit.session.impl.AbstractUINavigationArea;

import com.denasales.cockpit.session.impl.DenasalescockpitNavigationArea;


/**
 * Denasalescockpit navigation area model.
 */
public class DenasalescockpitNavigationAreaModel extends DefaultNavigationAreaModel
{
	public DenasalescockpitNavigationAreaModel()
	{
		super();
	}

	public DenasalescockpitNavigationAreaModel(final AbstractUINavigationArea area)
	{
		super(area);
	}

	@Override
	public DenasalescockpitNavigationArea getNavigationArea()
	{
		return (DenasalescockpitNavigationArea) super.getNavigationArea();
	}
}
