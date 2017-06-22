package com.util;

import com.model.Resume;
import com.storage.SqlStorage;
import com.storage.interfaces.Storage;
import config.Config;

import java.io.IOException;
import java.util.List;

public class TestData {

    private static final Storage storage = Config.getInstance().getStorage();


    public TestData() {
        try {
            storage.save(new Resume("uuid45"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  Storage getStorage() {
        return storage;
    }

    public static void main(String[] args) throws IOException {

        List<Resume> lr = storage.getAllSorted();
        System.out.println(lr.toString());
    }
}
