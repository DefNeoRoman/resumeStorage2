package com.storage.arrayImpl;

import com.model.Resume;
import com.storage.abstractClasses.AbstractArrayStorage;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid){
        for (int i = 0; i < size; i++) {
            if(uuid.equals(storage[i].getUuid())){
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insert(Integer index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected void fillDeleted(Integer index) {
        storage[index] = storage[size-1];
    }


}
