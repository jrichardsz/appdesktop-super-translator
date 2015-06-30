package com.rnasystems.projects.translator.core;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlUnitTranslator implements ITranslator{
	
	private WebClient webClient = null;
	
	public HtmlUnitTranslator(){
		webClient = new WebClient();
    	webClient.setThrowExceptionOnFailingStatusCode(false);
    	webClient.setThrowExceptionOnScriptError(false);
	}	
	
	
	public static void main(String[] args) throws Exception{
		
//		String urlWebTranslator = "http://translate.google.com/?hl=en&tl=es";
//		
//		WebClient webClient = new WebClient();
//    	webClient.setThrowExceptionOnFailingStatusCode(false);
//    	webClient.setThrowExceptionOnScriptError(false);
//    	HtmlPage page = (HtmlPage) webClient.getPage(urlWebTranslator);
//    	
//    	HtmlTextArea htmlTextArea = (HtmlTextArea) page.getHtmlElementById("source");
//    	htmlTextArea.setText("If you can not see the images or links do not work, open the message in your browser.");
//    	
//    	HtmlSubmitInput htmlSubmitInput = (HtmlSubmitInput) page.getHtmlElementById("gt-submit");
//    	
//    	HtmlPage pageResult = (HtmlPage) htmlSubmitInput.click();   	
//    	
//    	HtmlSpan htmlSpan = (HtmlSpan) pageResult.getHtmlElementById("result_box");
//    	HtmlSpan resultSpan = (HtmlSpan) htmlSpan.getFirstDomChild();
//    	System.out.println(resultSpan.asText());
		
		HtmlUnitTranslator htmlUnitTranslator = new HtmlUnitTranslator();
		String output = htmlUnitTranslator.translate("¿hola como estas?","es","en");
		
		System.out.println(output);
		
	}

	@Override
	public String translate(String palabra,String languajeIni,String languajeEnd) throws Exception{

        StringBuilder urlWebTranslatorHost = new StringBuilder("http://translate.google.com/?");
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
	

}
