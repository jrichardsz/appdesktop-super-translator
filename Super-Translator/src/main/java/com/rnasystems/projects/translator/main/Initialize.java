/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.main;

import com.linet.util.file.FileUtil;
import java.io.File;
import com.rnasystems.projects.translator.util.TranslatorParameters;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class Initialize {

    public Initialize() {
        TranslatorParameters.initializePath(FileUtil.getPathFromWhereApplicationIsRunning() + File.separator +"config"+ File.separator +"config.properties");
    }
    
}
