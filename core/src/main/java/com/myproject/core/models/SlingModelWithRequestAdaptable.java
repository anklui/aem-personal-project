package com.myproject.core.models;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.designer.Style;
import com.myproject.core.services.ExampleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.apache.sling.settings.SlingSettingsService;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class)
public class SlingModelWithRequestAdaptable {
    @ValueMapValue /*for Injecting resource dialog when adaptable is not resource, also works for resource*/
    private String text3;
    @ValueMapValue
    private String text4;
    @ValueMapValue
    private String text5;
    //@Inject /*for Injecting resource dialog when adaptable is resource*/
    @ValueMapValue
    @Default(values="abc")/*to give default value if NULL*/
    @Named("title")/*when we want to refer the variable with some other name*/
    private String text1;

    @Required/*To Override default injection stratergy*/
    @ValueMapValue
    private String text2;


    @OSGiService
    private SlingSettingsService slingSettingsService;
    @SlingObject /*to use sling APIs like ResourceResolver or Sling settings*/
    private ResourceResolver resourceResolver;

    @ScriptVariable
    private ValueMap properties;

    @ScriptVariable
    private Style currentStyle;

    @ScriptVariable
    private Page currentPage;

    @Self
    private SlingHttpServletRequest request;



    public static final String PIPE = " | ";

    @PostConstruct
    /* Executes after the page load, function name can be anything */
    public void slingModelWithRequestAdaptablePostConstruct() {

     text2 = request.getResource().getResourceType();
     text4 = currentPage.getPageTitle();
     text5 = currentStyle.getDesign().getCssPath();

    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public String getText4() {
        return text4;
    }

    public String getText5() {
        return text5;
    }
}
