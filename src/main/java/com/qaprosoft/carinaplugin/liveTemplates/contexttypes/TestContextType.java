package com.qaprosoft.carinaplugin.liveTemplates.contexttypes;

import com.intellij.psi.PsiElement;

import static com.qaprosoft.carinaplugin.ClassPath.ABSTRACT_TEST;

public class TestContextType extends AbstractContextType {

    public TestContextType() {
        super("ABSTRACT_TEST", "Carina framework abstract test", Declaration.class);
    }

    @Override
    protected boolean isInExtendedContext(PsiElement psiElement) {
        return ContextTypeUtils.isInContext(psiElement, ABSTRACT_TEST);
    }
}
