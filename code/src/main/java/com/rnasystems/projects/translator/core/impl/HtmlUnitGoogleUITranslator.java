package com.rnasystems.projects.translator.core.impl;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.rnasystems.projects.translator.common.util.*;
import com.rnasystems.projects.translator.core.*;

public class HtmlUnitGoogleUITranslator implements ITranslator{
	
	public static String TRANSLATE_GENERIC_MAIN_HOST = "translate.generic.main.host";
	
	private WebClient webClient = null;
	
	public HtmlUnitGoogleUITranslator(){
		webClient = new WebClient();
    	webClient.setThrowExceptionOnFailingStatusCode(false);
    	webClient.setThrowExceptionOnScriptError(false);
	}

	@Override
	public String translate(String palabra,String languajeIni,String languajeEnd) throws Exception{

        StringBuilder urlWebTranslatorHost = new StringBuilder(TranslatorParameters.getProperty(TRANSLATE_GENERIC_MAIN_HOST));
        urlWebTranslatorHost.append("hl=" + languajeIni);
        urlWebTranslatorHost.append("&tl=" + languajeEnd);
		
    	HtmlPage page = (HtmlPage) webClient.getPage(urlWebTranslatorHost.toString());
    	
    	HtmlTextArea htmlTextArea = (HtmlTextArea) page.getHtmlElementById("source");
    	htmlTextArea.setText(palabra);
    	
    	HtmlSubmitInput htmlSubmitInput = (HtmlSubmitInput) page.getHtmlElementById("gt-submit");
    	
    	HtmlPage pageResult = (HtmlPage) htmlSubmitInput.click();   	
    	
    	HtmlSpan htmlSpan = (HtmlSpan) pageResult.getHtmlElementById("result_box");
    	HtmlSpan resultSpan = (HtmlSpan) htmlSpan.getFirstDomChild();
    	return resultSpan.asText();
	}

	@Override
	public String getInfo(){	
		return "Generic Translator Engine by JRichardsz";
	}
	

}
