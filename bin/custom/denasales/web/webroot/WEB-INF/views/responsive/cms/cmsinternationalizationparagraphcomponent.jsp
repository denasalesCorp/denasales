<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="modalWindow"
	tagdir="/WEB-INF/tags/responsive/modalWindows"%>

<div class="footerInternationalization footerBackGroundColor">
	<table>
		<thead>
			<tr>
				<td>
					<div>
						<span class="denasales"><spring:theme code="denasales.logo" /></span>
					</div>
				</td>
				<td><a id="languageSelector" class="disableTextDecoratingForHref cursorPointer">
						<div class="languageBorder">
							<span class="languageText">${currentLanguage.name}
								<div class="arrow-up"></div>
								<div class="arrow-down"></div>
							</span>
						</div>
				</a></td>
				<td><a id="currencySelector" class="disableTextDecoratingForHref cursorPointer">
						<div class="currencyBorder">
							<span class="currencyText">${currentCurrency.symbol}
								${currentCurrency.isocode}
								<div class="arrow-up"></div>
								<div class="arrow-down"></div>
							</span>
						</div>
				</a></td>
			</tr>
		</thead>
	</table>
</div>
<modalWindow:i18nModalWindowLanguage unit="language" languages="${languages}" />
<modalWindow:i18nModalWindowCurrency unit="currency" currencies="${currencies}" />
