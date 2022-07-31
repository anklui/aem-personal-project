package com.myproject.core.models;

import com.adobe.granite.jmx.annotation.Name;
import com.myproject.core.services.ExampleService;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.apache.sling.settings.SlingSettingsService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AllAnnotationsModelImpl implements AllAnnotationsModel {


    @OSGiService/* Replacement of @Reference*/
    private ExampleService exampleService;
    @Self /*when we need to inject the same adaptable*/

    @SlingObject /*to use sling APIs like ResourceResolver or Sling settings*/
    private SlingSettingsService slingSettingsService;

    @Named/*when we want to refer the variable with some other name*/
    @ScriptVariable/*When we want variables like Page,Node etc*/
    @Required/*To Override default injection stratergy*/
    //@Optional/*To Override default injection stratergy*/
    @Default /*to give default value if NULL*/
    @Inject /*for Injecting resource dialog when adaptable is resource*/
    @Via /*Companion of @Inject when adaptable is not resource*/
    @ValueMapValue /*for Injecting resource dialog when adaptable is not resource*/


    @Override
    @PostConstruct
    /* Executes after the page load, function name can be anything */
    public void init() {

//doNothing
    }
}
