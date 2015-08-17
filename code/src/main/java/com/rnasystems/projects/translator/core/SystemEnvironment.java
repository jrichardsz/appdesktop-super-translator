package com.rnasystems.projects.translator.core;

import java.io.*;
import java.net.*;
import java.util.*;

import com.gtranslate.context.*;
import com.linet.util.file.*;
import com.rnasystems.projects.translator.common.util.*;
import com.rnasystems.projects.translator.core.impl.*;

public class SystemEnvironment{
	
	public static String THIRD_PARTY_TRANSLATOR_ENGINE = "third.party.translator.engine";
	public static String THIRD_PARTY_TRANSLATOR_ENGINE_EXTENSION = ".jar";
	public static boolean isThirdPartyTranslatorEngineEnabled = false;
	public static ITranslator translatorEngine = null;
	
	public static void init() throws Exception{
		TranslatorParameters.initializePath(FileUtil.getPathFromWhereApplicationIsRunning() + File.separator + "config" + File.separator + "config.properties");
		initializeParametersTranslator();
		defineDefaultTranslatorEngine();
	}

	public static void initializeParametersTranslator() throws Exception{

		String enableProxy=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_ENABLE_PROXY);
		String proxy=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_PROXY);
		String port=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_PORT);
		String locale=TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_LOCALE);

		System.getProperties().put(Const.ENABLE_PROXY,enableProxy);
    	System.getProperties().put(Const.PROXY,proxy);
    	System.getProperties().put(Const.PORT,port);
    	System.getProperties().put(Const.LOCALE,locale);		
		
	}
	
	public static void defineDefaultTranslatorEngine() throws Exception{
		
		String thirdPartyTranslatorEngine = null;
		
		try{
			thirdPartyTranslatorEngine = TranslatorParameters.getProperty(THIRD_PARTY_TRANSLATOR_ENGINE);
		}catch(Exception exception){
			System.out.println("Is not an error, just does not set a third party translator engine."+exception.getMessage());
		}
		
		if(thirdPartyTranslatorEngine==null || thirdPartyTranslatorEngine.equals("")){
			enableGenericTranslatorEngine();
			return;
		}

		//If this pathname does not denote a directory, then listFiles() returns null. 
		File[] files = new File(FileUtil.getPathFromWhereApplicationIsRunning() + File.separator + "thirdparty").listFiles();

		//search third party in accordance with config.properties 
		File jarFile = null;
		
		for (File file : files) {
		    if (file.isFile()) {
		    	
		    	if(file.getName()!=null 
		    			&& !file.getName().equals("") 
		    			&& file.getName().equals(thirdPartyTranslatorEngine+THIRD_PARTY_TRANSLATOR_ENGINE_EXTENSION)){
		    		
		    		jarFile = file;
		    		break;
		    	}
		    }
		}
		
		if(jarFile==null){
			enableGenericTranslatorEngine();
			return;
		}
		
		
		//if jar file exists
		try{
			URL fileURL=jarFile.toURI().toURL();
			String jarURL="jar:" + fileURL + "!/";
			URL urls[]={new URL(jarURL)};
			URLClassLoader urlJarClassLoader=new URLClassLoader(urls);

			ThirdPartyProperties thirdPartyProperties = new ThirdPartyProperties(urlJarClassLoader);
			String className = thirdPartyProperties.getProperty("entrypoint");
			
			ITranslator thirdPartTranslatorEgine =(ITranslator) Class.forName(className,true,urlJarClassLoader).newInstance();
			
			System.out.println(thirdPartTranslatorEgine.getInfo());
			
			if(thirdPartTranslatorEgine.getInfo()!=null 
	    			&& !thirdPartTranslatorEgine.getInfo().equals("")){
	    		
				isThirdPartyTranslatorEngineEnabled = true;
				translatorEngine = thirdPartTranslatorEgine;
				return;				
	    	}
			
		}
		catch(MalformedURLException ex){
			ex.printStackTrace();
			enableGenericTranslatorEngine();
		}
		catch(InstantiationException ex){
			ex.printStackTrace();
			enableGenericTranslatorEngine();
		}
		catch(IllegalAccessException ex){
			ex.printStackTrace();
			enableGenericTranslatorEngine();
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
			enableGenericTranslatorEngine();
		}

	}
	
	protected static void enableGenericTranslatorEngine(){
		isThirdPartyTranslatorEngineEnabled = false;
		System.out.println("Starting default translator engine configuration.");
		translatorEngine = new HtmlUnitGoogleUITranslator();
	}
	
	public static void main(String[] args) throws Exception{
		defineDefaultTranslatorEngine();
	}
	
	public static class ThirdPartyProperties {
		
		Properties properties;
		
		public ThirdPartyProperties(URLClassLoader urlJarClassLoader){
			
			properties = new Properties();
	    	InputStream input = null;
	 
	    	try {
	 
	    		String filename = "third.party.properties";
	    		input = urlJarClassLoader.getResourceAsStream(filename);
	    		if(input==null){
	    	            System.out.println("Sorry, unable to find " + filename);
	    		    return;
	    		}
	 
	    		//load a properties file from class path, inside static method
	    		properties.load(input);
	 
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
			}
			finally{
				if(input != null) {
					try{
						input.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}
			}
			
		}
		
		public String getProperty(String key) throws Exception{
			if(properties!=null){
				return properties.getProperty(key);
			}else {
				throw new Exception("Properties file is null");
			}
		}
		
	}

}
