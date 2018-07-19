package com.qaprosoft.carinaplugin.actions.codeInsight;

import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.qaprosoft.carinaplugin.handlers.codeInsightHandlers.GenerateGetterActionHandler;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;

public class TypingAction extends BaseGenerateAction {

    public TypingAction() {
        super(new GenerateGetterActionHandler("Typings", ExtendedPsiMemberType.TYPING));
    }
}
