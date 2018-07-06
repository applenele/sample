package com.dxy.lenny.sample.boot.support;

import com.dxy.lenny.sample.boot.controller.IndexController;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.cache.ICacheEntryValidity;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;
import org.thymeleaf.templateresource.StringTemplateResource;

import java.util.Map;

/**
 * @author niele
 * @date 2018/7/6
 */
public class SampleViewTemplateResolver extends AbstractTemplateResolver {


    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate, String template, Map<String, Object> templateResolutionAttributes) {
        return new StringTemplateResource(template);
    }

    @Override
    protected TemplateMode computeTemplateMode(IEngineConfiguration configuration, String ownerTemplate, String template, Map<String, Object> templateResolutionAttributes) {
        TemplateMode templateMode = IndexController.TEMPLATE_MODE.get();
        return templateMode != null ? templateMode : TemplateMode.HTML;
    }

    @Override
    protected ICacheEntryValidity computeValidity(IEngineConfiguration configuration, String ownerTemplate, String template, Map<String, Object> templateResolutionAttributes) {
        return new ICacheEntryValidity() {
            @Override
            public boolean isCacheable() {
                return false;
            }

            @Override
            public boolean isCacheStillValid() {
                return false;
            }
        };
    }
}
