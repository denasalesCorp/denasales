/**
 *
 */
package com.denasales.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author USER
 *
 */
@Controller
@RequestMapping("/account/**")
public class MyAccountPageController extends AbstractPageController
{
	@RequestMapping(method = RequestMethod.GET)
	public String home(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId("myAccountPage"));
		return getViewForPage(model);
	}
}
