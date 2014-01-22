package com.rnasystems.projects.translator.core;

import java.io.File;

import com.gtranslate.context.TranslateEnvironment;
import com.linet.util.file.FileUtil;
import com.rnasystems.projects.translator.common.util.TranslatorConstants;
import com.rnasystems.projects.translator.common.util.TranslatorParameters;

public class SystemEnvironment{

	public static void init() throws Exception{

		TranslatorParameters.initializePath(FileUtil.getPathFromWhereApplicationIsRunning() + File.separator + "config" + File.separator + "config.properties");
		initializeParametersTranslator();
	}

	public static void initializeParametersTranslator() throws Exception{

		String enableProxy=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_ENABLE_PROXY);
		String proxy=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_PROXY);
		String port=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_PORT);
		String googleTranslateText=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_GOOGLE_TRANSLATE_TEXT);
		String googleTranslateAudio=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_GOOGLE_TRANSLATE_AUDIO);
		String googleTranslateDetect=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_GOOGLE_TRANSLATE_DETECT);
		String locale=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_LOCALE);

		TranslateEnvironment.init(enableProxy,proxy,port,googleTranslateText,googleTranslateAudio,googleTranslateDetect,locale);
	}

}
