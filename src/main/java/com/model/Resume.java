package com.model;

import com.model.enums.ContactType;
import com.model.enums.SectionType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * com.urise.com.model.com.model.Resume class
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>,Serializable {

    private static final long serialVersionUID = -6564477512163458052L;
    public static final Resume EMPTY = new Resume();
    private String uuid;
    private String fullName;
    private Map<ContactType,String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType,Section> sections = new EnumMap<>(SectionType.class);
    static {
        EMPTY.setSection(SectionType.OBJECTIVE, TextSection.EMPTY);
        EMPTY.setSection(SectionType.PERSONAL, TextSection.EMPTY);
        EMPTY.setSection(SectionType.ACHIEVEMENT, ListSection.EMPTY);
        EMPTY.setSection(SectionType.QUALIFICATIONS, ListSection.EMPTY);
        EMPTY.setSection(SectionType.WORK_EXPERIENCE, OrganizationSection.EMPTY);
        EMPTY.setSection(SectionType.EDUCATION, OrganizationSection.EMPTY);
    }
    public Resume() {
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(),fullName);
      }
    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid,"must be not null");
        Objects.requireNonNull(fullName,"must be not null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Map<SectionType, Section> getSections() {
        return sections;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public boolean isNew(){
        return uuid == null;
    }
    public String getUuid() {
        return uuid;
    }

    public void addContact(ContactType contactType, String value){
        contacts.put(contactType,value);
    }
    public void addSection(SectionType sectionType, Section section){
        sections.put(sectionType,section);
    }
    public String getContact(ContactType type){
        return contacts.get(type);
    }
    public Section getSection(SectionType type){
        return sections.get(type);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }
    public void setSection(SectionType type, Section section) {
        sections.put(type, section);
    }
    @Override
    public int compareTo(Resume o) {
        int compar = fullName.compareTo(o.fullName);

        return compar != 0 ? compar:uuid.compareTo(o.getUuid());
    }
    public void setContact(ContactType type, String value) {
        contacts.put(type, value);
    }
    @Override
    public String toString() {
        return uuid;
    }
}
