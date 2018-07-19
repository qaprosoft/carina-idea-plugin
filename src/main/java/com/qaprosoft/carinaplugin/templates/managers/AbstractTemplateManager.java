package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.exception.TemplateResourceException;
import org.jetbrains.java.generate.template.TemplateResource;
import org.jetbrains.java.generate.template.TemplatesManager;

import java.io.IOException;

import static com.qaprosoft.carinaplugin.registration.IApplicationComponentName.PLUGIN_NAME;

public abstract class AbstractTemplateManager extends TemplatesManager {

    protected final static String TEMPLATE_DEFAULT = String.format("%s default", PLUGIN_NAME);

    protected static String readFile(Class<? extends AbstractTemplateManager> aClass, String resource) throws IOException {
        return readFile(resource, aClass);
    }

    @Override
    public abstract TemplateResource[] getDefaultTemplates();

    protected TemplateResource[] getDefaultTemplates(String schema, Class<? extends AbstractTemplateManager> templateManager, ExtendedPsiMemberType memberType) {
        try {
            return new TemplateResource[]{new TemplateResource(schema, readFile(templateManager, memberType.getTemplatePath()), true)};
        }
        catch (IOException e) {
            throw new TemplateResourceException("Error loading default templates", e);
        }
    }

    protected TemplateResource[] getDefaultTemplates(Class<? extends AbstractTemplateManager> templateManager, ExtendedPsiMemberType memberType) {
        return getDefaultTemplates(TEMPLATE_DEFAULT, templateManager, memberType);
    }
}
