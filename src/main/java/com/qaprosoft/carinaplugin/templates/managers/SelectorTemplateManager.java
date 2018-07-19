package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.template.TemplateResource;

public class SelectorTemplateManager extends AbstractTemplateManager {

    public static SelectorTemplateManager getInstance() {
        return new SelectorTemplateManager();
    }

    @Override
    public TemplateResource[] getDefaultTemplates() {
        return super.getDefaultTemplates(SelectorTemplateManager.class, ExtendedPsiMemberType.SELECTOR);
    }
}
