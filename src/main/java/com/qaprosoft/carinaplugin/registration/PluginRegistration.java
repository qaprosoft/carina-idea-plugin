package com.qaprosoft.carinaplugin.registration;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class PluginRegistration implements ApplicationComponent {

    // If you register the MyPluginRegistration class in the <application-components> section of
    // the plugin.xml file, this method is called on IDEA start-up.
    @Override
    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    public String getComponentName() {
        return "";
    }
}
