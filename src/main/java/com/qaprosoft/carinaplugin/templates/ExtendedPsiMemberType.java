package com.qaprosoft.carinaplugin.templates;

import com.qaprosoft.carinaplugin.templates.managers.*;

public enum ExtendedPsiMemberType {

    GETTER(GetterTemplateManager.getInstance(), "/codeInsight/Getter.vm"), TYPING(TypingTemplatesManager.getInstance(), "/codeInsight/Typing.vm"), CLICKING(ClickingTemplateManager.getInstance(), "/codeInsight/Clicking.vm"), CHECKER(CheckerTemplateManager.getInstance(), "/codeInsight/Checker.vm"), UNCHECKER(UncheckerTemplateManager.getInstance(), "/codeInsight/Unchecker.vm"), SELECTOR(SelectorTemplateManager.getInstance(), "/codeInsight/Selector.vm");

    private AbstractTemplateManager templateManager;
    private String templatePath;

    ExtendedPsiMemberType(AbstractTemplateManager templateManager, String templatePath) {
        this.templateManager = templateManager;
        this.templatePath = templatePath;
    }

    public AbstractTemplateManager getTemplateManager() {
        return templateManager;
    }

    public String getTemplatePath() {
        return templatePath;
    }
}
