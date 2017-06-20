package com.storage.interfaces;

import com.model.Resume;

import java.io.IOException;
import java.util.List;

public interface Storage {
    int size();
    void save(Resume resume) throws IOException;
    void delete(String uuid);
    void update(Resume resume);
    Resume get(String uuid);
    List<Resume> getAllSorted();
    void clear();
}
