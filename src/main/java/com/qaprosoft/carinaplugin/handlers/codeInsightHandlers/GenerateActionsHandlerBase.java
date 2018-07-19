package com.qaprosoft.carinaplugin.handlers.codeInsightHandlers;

import com.intellij.codeInsight.generation.*;
import com.intellij.psi.PsiClass;
import com.intellij.util.IncorrectOperationException;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMember;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;

public class GenerateActionsHandlerBase extends GenerateMembersHandlerBase {

    private ExtendedPsiMemberType memberType;

    public GenerateActionsHandlerBase(String title, ExtendedPsiMemberType memberType) {
        super(title);
        this.memberType = memberType;
    }

    @Override
    protected ClassMember[] getAllOriginalMembers(PsiClass psiClass) {
        return new ClassMember[0];
    }

    protected GenerationInfo[] generateMemberPrototypes(PsiClass aClass, ClassMember original) throws IncorrectOperationException {
        if (original instanceof ExtendedPsiMember) {
            final ExtendedPsiMember propertyClassMember = (ExtendedPsiMember) original;
            final GenerationInfo[] getters = propertyClassMember.generateActions(aClass, this.memberType);
            if (getters != null) {
                return getters;
            }
        }
        return GenerationInfo.EMPTY_ARRAY;
    }
}
