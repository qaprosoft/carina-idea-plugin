package com.qaprosoft.carinaplugin.actions.codeInsight;

import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.qaprosoft.carinaplugin.handlers.codeInsightHandlers.GenerateGetterActionHandler;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;

public class CheckerAction extends BaseGenerateAction {

    public CheckerAction() {
        super(new GenerateGetterActionHandler("Checkers", ExtendedPsiMemberType.CHECKER, ExtendedPsiMemberType.UNCHECKER));
    }
}
