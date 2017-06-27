package com.sandBox;

import com.model.Resume;
import com.storage.interfaces.Storage;
import com.Config;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Storage storage = Config.getInstance().getStorage();
        Resume r = new Resume("Ivanov");
        storage.clear();
        storage.save(r);
        System.out.println(storage.get(r.getUuid()).toString());

    }
}
