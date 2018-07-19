package com.qaprosoft.carinaplugin.services;

import com.qaprosoft.carinaplugin.models.UserArchetype;
import com.qaprosoft.carinaplugin.models.UserArchetypeRoot;

import java.util.ArrayList;

/**
 * Class used for creating carina archetype in maven user default archetypes list
 */
public class CarinaArchetypeService extends ArchetypeService {

    private static final String CARINA_ARCHETYPE_GROUP_ID = "com.qaprosoft";
    private static final String CARINA_ARCHETYPE_ARTIFACT_ID = "carina-archetype";
    private static final String CARINA_ARCHETYPE_VERSION = "1.0";

    private static final UserArchetypeRoot USER_ARCHETYPES = new UserArchetypeRoot(new UserArchetype(
            CARINA_ARCHETYPE_GROUP_ID, CARINA_ARCHETYPE_ARTIFACT_ID, CARINA_ARCHETYPE_VERSION));

    /**
     * Add carina archetype to maven user archetype list
     */
    public static void writeArchetype() {
        UserArchetypeRoot existsUserArchetypeRoot = getArchetypes();
        if(! isArchetypeAlreadyExists(existsUserArchetypeRoot, USER_ARCHETYPES.getArchetypes().get(0))) {
            existsUserArchetypeRoot = existsUserArchetypeRoot == null ? new UserArchetypeRoot() : existsUserArchetypeRoot;
            existsUserArchetypeRoot.setArchetypes(existsUserArchetypeRoot.getArchetypes() == null ? new ArrayList<>() : existsUserArchetypeRoot.getArchetypes());
            existsUserArchetypeRoot.getArchetypes().addAll(USER_ARCHETYPES.getArchetypes());
            writeArchetype(existsUserArchetypeRoot);
        }
    }
}
