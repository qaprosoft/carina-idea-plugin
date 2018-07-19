package com.qaprosoft.carinaplugin.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "archetype")
public class UserArchetype {

    private String groupId;
    private String artifactId;
    private String version;

    public UserArchetype() {
    }

    public UserArchetype(String groupId, String artifactId, String version) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public String getGroupId() {
        return groupId;
    }

    @XmlAttribute(name = "groupId")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    @XmlAttribute(name = "artifactId")
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    @XmlAttribute(name = "version")
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        return (groupId + ":" + artifactId + ":" + groupId).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UserArchetype) {
            UserArchetype userArchetype = (UserArchetype) obj;
            return userArchetype.groupId.equals(this.groupId) && userArchetype.artifactId.equals(this.artifactId) && userArchetype.version.equals(this.version);
        }
        return false;
    }

    @Override
    public String toString() {
        return "group id : " + groupId + ", artifact id :" + artifactId + ", version : " + version;
    }
}
