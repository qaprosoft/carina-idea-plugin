package com.qaprosoft.carinaplugin.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "archetypes")
public class UserArchetypeRoot {

    private List<UserArchetype> archetypes;

    public UserArchetypeRoot() {
    }

    public UserArchetypeRoot(UserArchetype... archetypes) {
        this.archetypes = Arrays.asList(archetypes);
    }

    public UserArchetypeRoot(List<UserArchetype> archetypes) {
        this.archetypes = archetypes;
    }

    public List<UserArchetype> getArchetypes() {
        return archetypes;
    }

    @XmlElement(name = "archetype")
    public void setArchetypes(List<UserArchetype> archetypes) {
        this.archetypes = archetypes;
    }
}
