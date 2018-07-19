package com.qaprosoft.carinaplugin.liveTemplates;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

public class TemplateProvider implements DefaultLiveTemplatesProvider {

    @Override
    public String[] getDefaultLiveTemplateFiles() {
        return new String[] {"liveTemplates/WebElementTemplateMarkdown", "liveTemplates/CarinaTestTemplateMarkdown", "liveTemplates/Plain"};
    }

    @Nullable
    @Override
    public String[] getHiddenLiveTemplateFiles() {
        return new String[0];
    }
}
