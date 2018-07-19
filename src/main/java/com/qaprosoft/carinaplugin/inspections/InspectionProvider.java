package com.qaprosoft.carinaplugin.inspections;

import com.intellij.codeInspection.InspectionToolProvider;
import org.jetbrains.annotations.NotNull;

public class InspectionProvider implements InspectionToolProvider {

    @NotNull
    @Override
    public Class[] getInspectionClasses() {
        return new Class[] {WebElementInspection.class};
    }
}
