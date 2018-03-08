package com.denasales.core.jalo;

import com.denasales.core.constants.DenasalescoreConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class DenasalescoreManager extends GeneratedDenasalescoreManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( DenasalescoreManager.class.getName() );
	
	public static final DenasalescoreManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (DenasalescoreManager) em.getExtension(DenasalescoreConstants.EXTENSIONNAME);
	}
	
}
