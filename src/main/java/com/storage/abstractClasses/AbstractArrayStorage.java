package com.storage.abstractClasses;

import com.exception.StorageException;
import com.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage{
    protected int size = 0;
    public static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }


    @Override
    protected Resume doGet(Object index) {

        return storage[(Integer)index];
    }
   @Override
    public void clear() {
        Arrays.fill(storage,0,size,null);
        size = 0;
    }
    @Override
    protected  void doSave(Resume resume, Object index){
        if (size == STORAGE_LIMIT - 1) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }else{
            insert((int)index, resume);
            size++;
        }

    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage[(int)index] = resume;
    }

    @Override
    protected boolean isExist(Object index) {
        return (int)index >= 0;
    }

    @Override
    protected void doDelete(Object index) {
        fillDeleted((int)index);
        storage[size - 1] = null;
        size--;
    }
    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }
    protected abstract Integer getSearchKey(String uuid);
    protected abstract void insert(Integer index, Resume resume);
    protected abstract void fillDeleted(Integer index);
}
