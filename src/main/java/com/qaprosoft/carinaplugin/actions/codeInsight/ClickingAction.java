package com.qaprosoft.carinaplugin.actions.codeInsight;

import com.intellij.codeInsight.generation.actions.BaseGenerateAction;
import com.qaprosoft.carinaplugin.handlers.codeInsightHandlers.GenerateGetterActionHandler;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;

public class ClickingAction extends BaseGenerateAction {

    public ClickingAction() {
        super(new GenerateGetterActionHandler("Clickings", ExtendedPsiMemberType.CLICKING));
    }
}
