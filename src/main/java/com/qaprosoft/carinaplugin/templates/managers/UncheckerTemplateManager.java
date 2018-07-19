package com.qaprosoft.carinaplugin.templates.managers;

import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import org.jetbrains.java.generate.template.TemplateResource;

public class UncheckerTemplateManager extends AbstractTemplateManager {

    public static UncheckerTemplateManager getInstance() {
        return new UncheckerTemplateManager();
    }

    @Override
    public TemplateResource[] getDefaultTemplates() {
        return super.getDefaultTemplates(UncheckerTemplateManager.class, ExtendedPsiMemberType.UNCHECKER);
    }
}
