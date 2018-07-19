package com.qaprosoft.carinaplugin.handlers;

import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.JavaCreateFromTemplateHandler;
import com.intellij.ide.fileTemplates.JavaTemplateUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

public class CreateFromTemplateHandler extends JavaCreateFromTemplateHandler {

    @Override
    public boolean handlesTemplate(@NotNull FileTemplate template) {
        return ArrayUtil.contains(template.getName(), ArrayUtils.addAll(JavaTemplateUtil.INTERNAL_CLASS_TEMPLATES, "PageObject"));
    }

    @Override
    public boolean canCreate(PsiDirectory[] dirs) {
        return false;
    }
}
