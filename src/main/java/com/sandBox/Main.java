package com.sandBox;

import com.model.Resume;
import com.model.TextSection;
import com.model.enums.ContactType;
import com.model.enums.SectionType;
import com.storage.interfaces.Storage;
import config.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Storage storage = Config.getInstance().getStorage();

        Resume resume = new Resume("Петров");
        resume.addContact(ContactType.EMAIL, "java@u-rise.com");
        resume.setSection(SectionType.OBJECTIVE, new TextSection("тестовая секция"));
        storage.save(resume);
        List<Resume> lr;
        lr = storage.getAllSorted();
        System.out.println(lr.toString());


    }
}
