/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.languages;

import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.SupportingFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PythonFlaskConnexionServerCodegen extends PythonAbstractConnexionServerCodegen {
    private static final Logger LOGGER = LoggerFactory.getLogger(PythonFlaskConnexionServerCodegen.class);

    public PythonFlaskConnexionServerCodegen() {
        super("python-flask", false);
    }

    /**
     * Configures a friendly name for the generator.  This will be used by the generator
     * to select the library with the -g flag.
     *
     * @return the friendly name for the generator
     */
    @Override
    public String getName() {
        return "python-flask";
    }

    @Override
    protected void addSupportingFiles() {
        supportingFiles.add(new SupportingFile("gitignore.mustache", "", ".gitignore"));
//        supportingFiles.add(new SupportingFile("Dockerfile.mustache", "", "Dockerfile"));
//        supportingFiles.add(new SupportingFile("dockerignore.mustache", "", ".dockerignore"));
        supportingFiles.add(new SupportingFile("setup.mustache", "", "setup.py"));
//        supportingFiles.add(new SupportingFile("tox.mustache", "", "tox.ini"));
//        supportingFiles.add(new SupportingFile("git_push.sh.mustache", "", "git_push.sh"));
//        supportingFiles.add(new SupportingFile("travis.mustache", "", ".travis.yml"));
        supportingFiles.add(new SupportingFile("encoder.mustache", packagePath(), "encoder.py"));
        supportingFiles.add(new SupportingFile("__init__test.mustache", packagePath() + File.separatorChar + testPackage, "__init__.py"));
        supportingFiles.add(new SupportingFile("__init__.mustache", packagePath(), "__init__.py"));
        testPackage = packageName + "." + testPackage;
    }
    
//    @Override
//    public Map<String, Object> postProcessAllModels(Map<String, Object> objs) {
//        Map<String, Object> result = super.postProcessAllModels(objs);
//        for (Map.Entry<String, Object> entry : result.entrySet()) {
//            Map<String, Object> inner = (Map<String, Object>) entry.getValue();
//            List<Map<String, Object>> models = (List<Map<String, Object>>) inner.get("models");
//            for (Map<String, Object> mo : models) {
//                CodegenModel cm = (CodegenModel) mo.get("model");
//	   		     if (cm.classname.equals("ConstantNode")) {
//			    	 System.out.println("JCT2 ::: >> " + cm.discriminator + " >>> ");
//			    	 System.out.println("JCT2 ::: >> " + (cm.discriminator == null));
//			    	 System.out.println("JCT2 ::: >> " + cm.parent);
//			    	 System.out.println("JCT2 ::: >> " + (cm.getParentModel() == null));
//			     }
//            }
//        }
//        return result;
//    }
    
    @Override
    public Map<String, Object> postProcessModels(Map<String, Object> objs) {
    	objs = super.postProcessModels(objs);
		List<Object> models = (List<Object>) objs.get("models");
		for (Object _mo : models) {
		     Map<String, Object> mo = (Map<String, Object>) _mo;
		     CodegenModel cm = (CodegenModel) mo.get("model");
//		     System.out.println("JCT ::: " + cm.classname + " : " + cm.discriminator + " ^ " + cm.parent);
		     if (cm.classname.equals("Node")) {
		    	 System.out.println("JCT ::: Node :::");
		    	 System.out.println("JCT ::: " + cm.imports);
//		    	 System.out.println("JCT ::: >> " + cm.discriminator);
//		    	 System.out.println("JCT ::: >> " + (cm.discriminator == null));
//		    	 System.out.println("JCT ::: >> " + cm.parent);
//		    	 System.out.println("JCT ::: >> " + (cm.getParentModel() == null));
		     }
//		     if (cm.discriminator == null && cm.parentModel != null) {
//		    	 if (cm.parentModel.discriminator != null) {
//		    		 System.out.println("FOUND RELEVANT! " + cm.getClassname());
//		    	 }
//		    	 
//		     }
//		
		 }
		 return objs;
////    	Map<String, Object> ret = super.postProcessModels(objs);
////    	
////    	ret.forEach((key, val) -> {
////    		System.out.println("PP " + key + ": " + val.getClass());
////    	});
////    	
////    	
////    	return ret;
    }
}
