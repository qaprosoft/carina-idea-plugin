package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.template.TemplateResource;

public class TypingTemplatesManager extends AbstractTemplateManager {

    public static TypingTemplatesManager getInstance() {
        return new TypingTemplatesManager();
    }

    @Override
    public TemplateResource[] getDefaultTemplates() {
        return super.getDefaultTemplates(TypingTemplatesManager.class, ExtendedPsiMemberType.TYPING);
    }
}
