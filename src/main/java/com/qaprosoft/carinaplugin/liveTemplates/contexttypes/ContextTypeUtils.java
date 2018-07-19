package com.qaprosoft.carinaplugin.liveTemplates.contexttypes;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.qaprosoft.carinaplugin.ClassPath;

import java.util.Arrays;

public class ContextTypeUtils {

    protected static boolean isInContext(PsiElement element, ClassPath... classPathes) {
        return Arrays.stream(classPathes).filter(carinaElement -> PsiTreeUtil.getParentOfType(element, PsiClass.class) != null
                && PsiTreeUtil.getParentOfType(element, PsiClass.class).getSuperClass() != null
                && PsiTreeUtil.getParentOfType(element, PsiClass.class).getSuperClass().getQualifiedName()
                .equals(carinaElement.getClassName())).findFirst().orElse(null) != null;
    }
}
