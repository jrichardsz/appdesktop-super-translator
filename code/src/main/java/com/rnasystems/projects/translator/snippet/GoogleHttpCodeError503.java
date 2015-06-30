package com.rnasystems.projects.translator.snippet;

import java.util.*;
import java.util.regex.*;

import javax.swing.*;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.rnasystems.projects.translator.common.util.*;
import com.rnasystems.projects.translator.view.*;

public class GoogleHttpCodeError503{

	
	public void resolve( View view,Exception e) throws Exception{
		view.setAlwaysOnTop(false);//  disable in order to show captcha popup on top
		
		System.out.println("captcha error");
		
			Pattern pattern = Pattern.compile("(http)://.*$");
			Matcher matcher = pattern.matcher(e.getCause().getMessage());
			
			if(!matcher.find()){
				throw new Exception("Failed to get url for captcha resolver.");
			}
			
			String urlRedirect = matcher.group(0);
			
			HtmlPage page = null;
			try{
				WebClient webClient = new WebClient();
		    	webClient.setThrowExceptionOnFailingStatusCode(false);
		    	webClient.setThrowExceptionOnScriptError(false);
		        page = (HtmlPage) webClient.getPage(urlRedirect);
			}catch(Exception exception){
				throw new Exception("Failed to getting html page from captcha redirect",exception);
			}
			
			List<HtmlImage> imageList = (List<HtmlImage>) page.getByXPath("//img");
	        for (HtmlImage image : imageList) {
	           
	           //ImageReader imageReader = image.	
	        	
	           String imageId = getId(image.getSrcAttribute());
	           String imageUrl = "http://ipv4.google.com"+image.getSrcAttribute();
	           String imagePath = ImageDownloader.download(imageUrl);
	           System.out.println(imagePath);
	           ImageIcon icon = new ImageIcon(imagePath);

	           Object captcha = JOptionPane.showInputDialog(null,"Para continuar, introduce los \n caracteres que aparecen a continuación:","GOOGLE CAPTCHA",JOptionPane.INFORMATION_MESSAGE,icon,null,null);
	           
	           HtmlInput intputBox = (HtmlInput) page.getHtmlElementById("captcha");
	           intputBox.setValueAttribute(""+captcha);
	           
	           HtmlForm form = (HtmlForm)page.getFirstByXPath("//form[@action='CaptchaRedirect']");
	           form.getInputByName("captcha").setValueAttribute(""+captcha);
	           HtmlSubmitInput button = (HtmlSubmitInput) form.getHtmlElementsByAttribute("input","name","submit").get(0);
	           
	           Page response = button.click();
	           WebResponse responseWeb = response.getWebResponse();
		       String content = responseWeb.getContentAsString();
		       
		       System.out.println(content);
		       
//	           System.out.println("link="+urlRedirect);
//	           System.out.println("captcha="+captcha);
//	           System.out.println("id="+imageId);
//	           
//	           StringBuilder newUrl = new StringBuilder(urlRedirect);
//	           newUrl.append("&captcha=" + captcha);
//               newUrl.append("&id=" + imageId);
//	           String result = WebUtils.source(newUrl.toString());
//	           
//	           System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
//	           System.out.println(result);
	           
	           break;
	           
	        }

    		view.setAlwaysOnTop(true);
	}
	
    private String getId(String srcImage) throws Exception{
    	Pattern pattern = Pattern.compile("\\d+");
    	Matcher matcher = pattern.matcher(srcImage);
    	if(matcher.find()){
    		return matcher.group(0);
    	}else {
    		throw new Exception("Failed to get captcha image id in order to resolver.");
    	}
    }
	
}
