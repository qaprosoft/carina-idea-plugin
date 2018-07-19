package com.qaprosoft.carinaplugin.registration;

import com.qaprosoft.carinaplugin.services.CarinaArchetypeService;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import static com.qaprosoft.carinaplugin.registration.IApplicationComponentName.MAVEN_ARCHETYPE_NAME;

/**
 * Application component writes carina archetype on ide start
 */
public class MavenRegistration implements ApplicationComponent {

    @Override
    public void initComponent() {
        CarinaArchetypeService.writeArchetype();
    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    public String getComponentName() {
        return MAVEN_ARCHETYPE_NAME;
    }
}
