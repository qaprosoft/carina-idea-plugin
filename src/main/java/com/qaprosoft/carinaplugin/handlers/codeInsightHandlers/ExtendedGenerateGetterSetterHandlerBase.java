package com.qaprosoft.carinaplugin.handlers.codeInsightHandlers;

import com.intellij.codeInsight.generation.ClassMember;
import com.intellij.codeInsight.generation.GenerateGetterSetterHandlerBase;
import com.intellij.codeInsight.generation.GenerationInfo;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.java.generate.template.TemplatesManager;

import javax.swing.*;

/**
 * Class to get access to getHeaderPanel GenerateGetterSetterHandlerBase method
 */
public class ExtendedGenerateGetterSetterHandlerBase extends GenerateGetterSetterHandlerBase {

    public ExtendedGenerateGetterSetterHandlerBase() {
        super("Getter and Setter");
    }

    @Override
    protected String getNothingFoundMessage() {
        return null;
    }

    @Override
    protected GenerationInfo[] generateMemberPrototypes(PsiClass psiClass, ClassMember classMember) throws IncorrectOperationException {
        return new GenerationInfo[0];
    }

    @Override
    protected String getNothingAcceptedMessage() {
        return null;
    }

    public static JComponent getHeaderPanel(final Project project, final TemplatesManager templatesManager, final String templatesTitle) {
        return GenerateGetterSetterHandlerBase.getHeaderPanel(project, templatesManager, templatesTitle);
    }
}
