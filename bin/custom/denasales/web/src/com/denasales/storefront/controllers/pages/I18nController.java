/**
 *
 */
package com.denasales.storefront.controllers.pages;

import de.hybris.platform.acceleratorservices.uiexperience.UiExperienceService;
import de.hybris.platform.acceleratorservices.urlencoder.UrlEncoderService;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;
import de.hybris.platform.commercefacades.storesession.StoreSessionFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.enumeration.EnumerationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author USER
 *
 */
@Controller
@RequestMapping("/_i18n_")
public class I18nController extends AbstractController {

    @Resource(name = "storeSessionFacade")
    private StoreSessionFacade storeSessionFacade;

    @Resource(name = "userFacade")
    private UserFacade userFacade;

    @Resource(name = "uiExperienceService")
    private UiExperienceService uiExperienceService;

    @Resource(name = "enumerationService")
    private EnumerationService enumerationService;

    @Resource(name = "urlEncoderService")
    private UrlEncoderService urlEncoderService;

    @RequestMapping(value = "/language", method = RequestMethod.POST)
    public String selectLanguage(@RequestParam("code") final String isoCode, final HttpServletRequest request) {
        storeSessionFacade.setCurrentLanguage(isoCode);
        if (!userFacade.isAnonymousUser()) {
            userFacade.syncSessionLanguage();
        }
        return REDIRECT_PREFIX + "/";
    }

    @RequestMapping(value = "/currency", method = RequestMethod.POST)
    public String selectCurrency(@RequestParam("code") final String isoCode, final HttpServletRequest request) {
        storeSessionFacade.setCurrentCurrency(isoCode);
        userFacade.syncSessionCurrency();
        return REDIRECT_PREFIX + "/";
    }
}
