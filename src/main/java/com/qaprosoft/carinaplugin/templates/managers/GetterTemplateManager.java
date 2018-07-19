package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.template.TemplateResource;

public class GetterTemplateManager extends AbstractTemplateManager {

    public static GetterTemplateManager getInstance() {
        return new GetterTemplateManager();
    }

    @Override
    public TemplateResource[] getDefaultTemplates() {
        return super.getDefaultTemplates(GetterTemplateManager.class, ExtendedPsiMemberType.GETTER);
    }
}
