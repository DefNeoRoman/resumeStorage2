package com.storage.collectionImpl;

import com.model.Resume;
import com.storage.abstractClasses.AbstractStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<String,Resume> map = new TreeMap<>();
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        map.put((String)searchKey,resume);
    }

    @Override
    protected boolean isExist(Object uuid) {

        return map.containsKey(uuid);
    }
    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }
    @Override
    protected void doSave(Resume resume, Object uuid) {
        map.put((String)uuid, resume);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove(uuid);
    }
}
