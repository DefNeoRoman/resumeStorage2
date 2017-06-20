package com.storage.collectionImpl;

import com.model.Resume;
import com.storage.abstractClasses.AbstractStorage;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }
    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        
        list.set(searchKey, resume);
    }

    @Override
    protected boolean isExist(Integer searchKey) {

        return searchKey != null;
    }

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        list.add(resume);
    }

    @Override
    protected Resume doGet(Integer searchKey) {

        return list.get(searchKey);
    }
    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(list);
    }
    @Override
    protected void doDelete(Integer searchKey) {
        list.remove(searchKey.intValue());
    }
}
