package com.qaprosoft.carinaplugin.intentions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.JavaFileElementType;
import com.intellij.psi.impl.source.PsiFieldImpl;
import com.intellij.psi.impl.source.PsiTypeElementImpl;
import com.intellij.psi.impl.source.tree.java.ClassElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import static com.qaprosoft.carinaplugin.ClassPath.ABSTRACT_PAGE;
import static com.qaprosoft.carinaplugin.ClassPath.WEB_ELEMENT;

@NonNls
public class WebElementFieldConverter extends PsiElementBaseIntentionAction implements IntentionAction {

    @Override
    public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement psiElement) throws IncorrectOperationException {
        /*PsiVariable psiField = PsiTreeUtil.getParentOfType(psiElement, PsiVariable.class, false);
        if(psiField != null) {
            final PsiElementFactory factory = JavaPsiFacade.getInstance(project).getElementFactory();
            final PsiClass psiClass = PsiUtil.resolveGenericsClassInType(psiField.getType()).getElement();
            if(psiClass != null) {
                psiClass.replace(factory.createTypeElementFromText(ABSTRACT_PAGE.getClassName(), psiElement));
            }
        }*/
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement psiElement) {
        if (psiElement.isWritable() && psiElement instanceof PsiJavaToken) {
            final PsiJavaToken token = (PsiJavaToken) psiElement;
            if (token.getTokenType().equals(JavaTokenType.IDENTIFIER) && token.getParent() instanceof PsiField) {
                final PsiField parent = (PsiField) token.getParent();
                final PsiClass psiClass = PsiUtil.resolveClassInType(parent.getType());
                return psiClass != null && psiClass.getQualifiedName() != null && psiClass.getQualifiedName().equals(WEB_ELEMENT.getClassName());
            }
        }
        return false;
    }

    @Nls
    @NotNull
    @Override
    public String getFamilyName() {
        return this.getText();
    }

    @NotNull
    @Override
    public String getText() {
        return "Convert common web element to extended web element";
    }


}
