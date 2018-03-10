package com.denasales.initialdata.jalo;

import com.denasales.initialdata.constants.DenasalesinitialdataConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class DenasalesinitialdataManager extends GeneratedDenasalesinitialdataManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( DenasalesinitialdataManager.class.getName() );
	
	public static final DenasalesinitialdataManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (DenasalesinitialdataManager) em.getExtension(DenasalesinitialdataConstants.EXTENSIONNAME);
	}
	
}
