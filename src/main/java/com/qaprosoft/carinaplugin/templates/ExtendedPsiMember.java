package com.qaprosoft.carinaplugin.templates;

import com.intellij.codeInsight.generation.*;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiSubstitutor;
import com.qaprosoft.carinaplugin.prototypes.*;
import com.qaprosoft.carinaplugin.templates.managers.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType.*;

public class ExtendedPsiMember extends PsiFieldMember {

    public ExtendedPsiMember(@NotNull PsiField field) {
        super(field);
    }

    public ExtendedPsiMember(@NotNull PsiField psiMember, PsiSubstitutor substitutor) {
        super(psiMember, substitutor);
    }

    @Nullable
    public PsiMethod[] generateGetters(PsiField field) {
        return GenerateMemberPrototype.<GetterTemplateManager>generateActions(field, GETTER);
    }

    @Nullable
    public PsiMethod[] generateClickings(PsiField field) {
        return GenerateMemberPrototype.<ClickingTemplateManager>generateActions(field, CLICKING);
    }

    @Nullable
    public PsiMethod[] generateTypings(PsiField field) {
        return GenerateMemberPrototype.<TypingTemplatesManager>generateActions(field, TYPING);
    }

    @Nullable
    public PsiMethod[] generateCheckers(PsiField field) {
        return GenerateMemberPrototype.<CheckerTemplateManager>generateActions(field, CHECKER);
    }

    @Nullable
    public PsiMethod[] generateUncheckers(PsiField field) {
        return GenerateMemberPrototype.<UncheckerTemplateManager>generateActions(field, UNCHECKER);
    }

    @Nullable
    public PsiMethod[] generateSelectors(PsiField field) {
        return GenerateMemberPrototype.<SelectorTemplateManager>generateActions(field, SELECTOR);
    }

    @Nullable
    public GenerationInfo[] generateActions(PsiClass aClass, ExtendedPsiMemberType memberType) {
        final PsiField field = getElement();
        if (GetterSetterPrototypeProvider.isReadOnlyProperty(field)) {
            return null;
        }
        PsiMethod[] result = null;
        switch(memberType) {
            case GETTER:
                result = generateGetters(field);
                break;
            case CLICKING:
                result = generateClickings(field);
                break;
            case TYPING:
                result = generateTypings(field);
                break;
            case CHECKER:
                result = generateCheckers(field);
                break;
            case UNCHECKER:
                result = generateUncheckers(field);
                break;
            case SELECTOR:
                result = generateSelectors(field);
                break;
            default:
                break;
        }
        return createGenerateInfos(aClass, result);
    }

    private static GenerationInfo[] createGenerateInfos(PsiClass aClass, PsiMethod[] prototypes) {
        final List<GenerationInfo> methods = new ArrayList<>();
        for (PsiMethod prototype : prototypes) {
            final PsiMethod method = createMethodIfNotExists(aClass, prototype);
            if (method != null) {
                methods.add(new PsiGenerationInfo(method));
            }
        }
        return methods.isEmpty() ? null : methods.toArray(GenerationInfo.EMPTY_ARRAY);
    }

    @Nullable
    private static PsiMethod createMethodIfNotExists(PsiClass aClass, final PsiMethod template) {
        PsiMethod existing = aClass.findMethodBySignature(template, false);
        return existing == null || !existing.isPhysical() ? template : null;
    }
}
