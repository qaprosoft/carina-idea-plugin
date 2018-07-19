package com.qaprosoft.carinaplugin.prototypes;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.util.IncorrectOperationException;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import com.qaprosoft.carinaplugin.templates.managers.AbstractTemplateManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.java.generate.GenerationUtil;
import org.jetbrains.java.generate.template.TemplatesManager;

import java.util.Collections;
import java.util.HashMap;

import static com.intellij.codeInsight.generation.GenerateMembersUtil.annotateOnOverrideImplement;
import static com.intellij.codeInsight.generation.GenerateMembersUtil.setVisibility;

public class GenerateMemberPrototype {

    protected static final Logger LOGGER = Logger.getLogger(GenerateMemberPrototype.class);

    public static <T extends AbstractTemplateManager> PsiMethod[] generateActions(@NotNull PsiField field, ExtendedPsiMemberType memberType) {
        return new PsiMethod[] {generatePrototype(field, field.getContainingClass(), memberType.getTemplateManager())};
    }

    protected static PsiMethod generatePrototype(@NotNull PsiField field,
                                               PsiClass psiClass,
                                               TemplatesManager templatesManager) {
        Project project = field.getProject();
        PsiElementFactory factory = JavaPsiFacade.getInstance(project).getElementFactory();
        String template = templatesManager.getDefaultTemplate().getTemplate();
        String methodText = GenerationUtil.velocityGenerateCode(psiClass, Collections.singletonList(field), new HashMap<>(), template, 0, false);

        PsiMethod result = null;
        try {
            result = factory.createMethodFromText(methodText, psiClass);
        }
        catch (IncorrectOperationException e) {
            LOGGER.info(e.getMessage(), e);
        }
        result = result != null ? (PsiMethod)CodeStyleManager.getInstance(project).reformat(result) : null;

        return generatePrototype(field, result);
    }

    @NotNull
    private static PsiMethod generatePrototype(@NotNull PsiField field, @NotNull PsiMethod result) {
        return setVisibility(field, annotateOnOverrideImplement(field.getContainingClass(), result));
    }
}
