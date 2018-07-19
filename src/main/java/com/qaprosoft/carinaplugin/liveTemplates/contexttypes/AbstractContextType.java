package com.qaprosoft.carinaplugin.liveTemplates.contexttypes;

import com.intellij.codeInsight.template.JavaCodeContextType;
import com.intellij.psi.PsiElement;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractContextType extends JavaCodeContextType {

    private static final Logger LOGGER = Logger.getLogger(AbstractContextType.class);

    protected JavaCodeContextType contextType;
    private Class<? extends JavaCodeContextType> clazz;

    protected AbstractContextType(@NotNull String id, @NotNull String presentableName, Class<? extends JavaCodeContextType> clazz) {
        super(id, presentableName, Generic.class);
        this.clazz = clazz;
        try {
            this.contextType = this.clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected boolean isInContext(@NotNull PsiElement psiElement) {
        return contextType.isInContext(psiElement.getContainingFile(), psiElement.getTextOffset()) && isInExtendedContext(psiElement);
    }

    protected abstract boolean isInExtendedContext(PsiElement psiElement);
}
