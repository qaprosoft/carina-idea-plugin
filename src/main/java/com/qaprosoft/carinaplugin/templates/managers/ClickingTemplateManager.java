package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.template.TemplateResource;

public class ClickingTemplateManager extends AbstractTemplateManager {

    public static ClickingTemplateManager getInstance() {
        return new ClickingTemplateManager();
    }

    @Override
    public TemplateResource[] getDefaultTemplates() {
        return super.getDefaultTemplates(ClickingTemplateManager.class, ExtendedPsiMemberType.CLICKING);
    }
}
