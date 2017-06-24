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

       ContactType contactType = ContactType.PHONE;
        System.out.println(contactType.name());


    }
}
