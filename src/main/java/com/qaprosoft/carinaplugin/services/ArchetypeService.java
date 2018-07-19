package com.qaprosoft.carinaplugin.services;

import com.intellij.openapi.application.PathManager;
import com.qaprosoft.carinaplugin.models.UserArchetype;
import com.qaprosoft.carinaplugin.models.UserArchetypeRoot;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Contains basic business logic for maven user archetypes adding
 */
public abstract class ArchetypeService {

    private static final String MAVEN_USER_ARCHETYPES_FILE_PATH = PathManager.getSystemPath() + "/Maven/Indices/UserArchetypes.xml";
    private static final Logger LOGGER = Logger.getLogger(ArchetypeService.class);

    protected static void writeArchetype(UserArchetypeRoot userArchetypeRoot) {
        try {
            Marshaller jaxbMarshaller = JAXBContext.newInstance(UserArchetypeRoot.class).createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
            File mavenUserArchetypesFile = new File(MAVEN_USER_ARCHETYPES_FILE_PATH);
            boolean isMavenUserArchetypesFileIsExist = mavenUserArchetypesFile.createNewFile();
            if(! isMavenUserArchetypesFileIsExist) {
                LOGGER.info("Maven user archetypes file was created: " + mavenUserArchetypesFile.getAbsolutePath());
            }
            jaxbMarshaller.marshal(userArchetypeRoot, mavenUserArchetypesFile);
        } catch(JAXBException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    protected static UserArchetypeRoot getArchetypes() {
        Unmarshaller jaxbUnmarshaller;
        UserArchetypeRoot userArchetypeRoot = null;
        File mavenUserArchetypesFile = new File(MAVEN_USER_ARCHETYPES_FILE_PATH);
        if(mavenUserArchetypesFile.exists()) {
            try {
                jaxbUnmarshaller = JAXBContext.newInstance(UserArchetypeRoot.class).createUnmarshaller();
                userArchetypeRoot = (UserArchetypeRoot) jaxbUnmarshaller.unmarshal(new File(MAVEN_USER_ARCHETYPES_FILE_PATH));
            } catch (JAXBException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return userArchetypeRoot;
    }

    protected static boolean isArchetypeEntityExists(UserArchetypeRoot userArchetypeRoot) {
        return userArchetypeRoot != null && userArchetypeRoot.getArchetypes() != null && ! userArchetypeRoot.getArchetypes().isEmpty();
    }

    protected static boolean isArchetypeAlreadyExists(UserArchetypeRoot userArchetypeRoot, UserArchetype userArchetype) {
        return isArchetypeEntityExists(userArchetypeRoot) && userArchetypeRoot.getArchetypes().contains(userArchetype);
    }

    public static String getMavenUserArchetypesFilePath() {
        return MAVEN_USER_ARCHETYPES_FILE_PATH;
    }
}
