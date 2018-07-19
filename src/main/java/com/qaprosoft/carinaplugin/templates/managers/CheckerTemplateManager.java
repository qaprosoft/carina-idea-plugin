package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.template.TemplateResource;

public class CheckerTemplateManager extends AbstractTemplateManager {

    public static CheckerTemplateManager getInstance() {
        return new CheckerTemplateManager();
    }

    @Override
    public TemplateResource[] getDefaultTemplates() {
        return super.getDefaultTemplates(CheckerTemplateManager.class, ExtendedPsiMemberType.CHECKER);
    }
}
