package com.qaprosoft.carinaplugin.handlers.codeInsightHandlers;

import com.intellij.codeInsight.generation.*;
import com.intellij.codeInsight.hint.HintManager;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.containers.ContainerUtil;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMember;
import com.qaprosoft.carinaplugin.templates.ExtendedPsiMemberType;
import com.qaprosoft.carinaplugin.templates.managers.GetterTemplateManager;
import org.apache.commons.lang.WordUtils;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.java.generate.exception.GenerateCodeException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.qaprosoft.carinaplugin.ClassPath.EXTENDED_WEB_ELEMENT;

public class GenerateGetterActionHandler extends GenerateMembersHandlerBase {

    private final GenerateActionsHandlerBase myGenerateGetterHandler = new GenerateActionsHandlerBase("Getters", ExtendedPsiMemberType.GETTER);
    private List<GenerateActionsHandlerBase> myGenerateActionHandlers;

    private String name;
    private List<ExtendedPsiMemberType> extendedPsiMemberTypes;

    public GenerateGetterActionHandler(String name, ExtendedPsiMemberType... memberTypes) {
        super(String.format("Select Fields to Generate %s", name));
        this.myGenerateActionHandlers = new ArrayList<>();
        this.name = name;
        this.extendedPsiMemberTypes = Arrays.asList(memberTypes);
        Arrays.stream(memberTypes).forEach(memberType -> myGenerateActionHandlers.add(new GenerateActionsHandlerBase(name, memberType)));
    }

    @Override
    protected String getHelpId() {
        return "Generate_Getter_Action_Dialog";
    }

    @Nullable
    @Override
    protected JComponent getHeaderPanel(Project project) {
        final JPanel panel = new JPanel(new BorderLayout(2, 2));
        panel.add(ExtendedGenerateGetterSetterHandlerBase.getHeaderPanel(project, GetterTemplateManager.getInstance(), "&Getter template:"), BorderLayout.NORTH);
        extendedPsiMemberTypes.forEach(memberType -> panel.add(ExtendedGenerateGetterSetterHandlerBase.getHeaderPanel(project, memberType.getTemplateManager(), String.format("&%s template:", WordUtils.capitalize(memberType.name().toLowerCase()))), BorderLayout.SOUTH));
        return panel;
    }

    @Override
    protected GenerationInfo[] generateMemberPrototypes(PsiClass psiClass, ClassMember classMember) throws IncorrectOperationException {
        ArrayList<GenerationInfo> array = new ArrayList<>();
        GenerationInfo[] getters = myGenerateGetterHandler.generateMemberPrototypes(psiClass, classMember);
        List<GenerationInfo> actions = new ArrayList<>();
        myGenerateActionHandlers.forEach(generateActionsHandlerBase -> actions.addAll(Arrays.asList(generateActionsHandlerBase.generateMemberPrototypes(psiClass, classMember))));

        if (getters.length > 0){
            Collections.addAll(array, getters);
        }
        array.addAll(actions);
        return array.toArray(GenerationInfo.EMPTY_ARRAY);
    }

    @Override
    protected ClassMember[] chooseOriginalMembers(PsiClass aClass, Project project, Editor editor) {
        final ClassMember[] allMembers = this.getAllOriginalMembers(aClass);
        if (allMembers == null) {
            HintManager.getInstance().showErrorHint(editor, getNothingFoundMessage());
            return null;
        }
        if (allMembers.length == 0) {
            HintManager.getInstance().showErrorHint(editor, getNothingAcceptedMessage());
            return null;
        }
        return chooseMembers(allMembers, false, false, project, editor);
    }

    @Nullable
    @Override
    protected ClassMember[] getAllOriginalMembers(PsiClass aClass) {
        final List<EncapsulatableClassMember> list = getAllEncapsulatedClassMembers(aClass);
        if (list.isEmpty()) {
            return null;
        }
        final List<EncapsulatableClassMember> members = ContainerUtil.findAll(list, member -> {
            try {
                return this.generateMemberPrototypes(aClass, member).length > 0;
            }
            catch (GenerateCodeException e) {
                return true;
            }
            catch (IncorrectOperationException e) {
                return false;
            }
        });
        return members.toArray(ClassMember.EMPTY_ARRAY);
    }

    @Override
    protected String getNothingFoundMessage() {
        return String.format("No fields have been found to generate Getters/%s for", this.name);
    }

    protected String getNothingAcceptedMessage() {
        return String.format("No fields without Getter/%s were found", this.name);
    }

    private static List<EncapsulatableClassMember> getAllEncapsulatedClassMembers(PsiClass psiClass) {
        if (psiClass.getLanguage() != JavaLanguage.INSTANCE) return Collections.emptyList();
        final List<EncapsulatableClassMember> result = new ArrayList<>();
        for (PsiField field : psiClass.getFields()) {
            PsiClass psiFieldClass = PsiUtil.resolveClassInType(field.getType());
            if (psiFieldClass != null && psiFieldClass.getQualifiedName() != null  && psiFieldClass.getQualifiedName().equals(EXTENDED_WEB_ELEMENT.getClassName())) {
                result.add(new ExtendedPsiMember(field));
            }
        }
        return result;
    }
}
