package com.rnasystems.projects.translator.generic;

import com.rnasystems.projects.translator.core.impl.*;

public class HtmlUnitGoogleUITranslatorTest{
	public static void main(String[] args) throws Exception{
		HtmlUnitGoogleUITranslator htmlUnitTranslator = new HtmlUnitGoogleUITranslator();
		String output = htmlUnitTranslator.translate("¿hola como estas?","es","en");
		System.out.println(output);
	}
}
