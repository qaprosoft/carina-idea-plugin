package com.qaprosoft.carinaplugin.actions.codeInsight;

import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.qaprosoft.carinaplugin.handlers.codeInsightHandlers.GenerateGetterActionHandler;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;

public class SelectorAction extends BaseGenerateAction {

    public SelectorAction() {
        super(new GenerateGetterActionHandler("Selectors", ExtendedPsiMemberType.SELECTOR));
    }
}
