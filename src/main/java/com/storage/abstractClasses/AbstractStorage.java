package com.storage.abstractClasses;

import com.exception.ExistStorageException;
import com.exception.NotExistStorageException;
import com.model.Resume;
import com.storage.interfaces.Storage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public abstract class AbstractStorage<SK> implements Storage {
    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(Resume resume, SK searchKey) throws IOException;

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);
    protected abstract List<Resume> doCopyAll();
    @Override
    public void save(Resume resume) throws IOException {
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public void update(Resume resume) {
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);

        return doGet(searchKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);

        }
        return searchKey;
    }
    public List<Resume> getAllSorted(){
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }
}
