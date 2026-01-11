package com.acme.cxf.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Classe Person qui sera sérialisée en XML par JAXB.
 */
@XmlRootElement(name = "Person") // définit la balise racine <Person> dans le XML
public class Person {
    private String id;
    private String name;
    private int age;

    // Constructeur vide obligatoire pour JAXB
    public Person() {}

    // Constructeur pratique pour instancier directement un objet Person
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Chaque getter annoté avec @XmlElement sera transformé en balise XML
    @XmlElement
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @XmlElement
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @XmlElement
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
