package com.qaprosoft.carinaplugin.liveTemplates.contexttypes;

import com.intellij.psi.PsiElement;

import static com.qaprosoft.carinaplugin.ClassPath.ABSTRACT_PAGE;
import static com.qaprosoft.carinaplugin.ClassPath.ABSTRACT_PAGE_UI_OBJECT;

public class WebElementContextType extends AbstractContextType {

    protected WebElementContextType() {
        super("ABSTRACT_PAGE", "Carina framework abstract page", Declaration.class);
    }

    @Override
    public boolean isInExtendedContext(PsiElement psiElement) {
        return ContextTypeUtils.isInContext(psiElement, ABSTRACT_PAGE, ABSTRACT_PAGE_UI_OBJECT);
    }
}
