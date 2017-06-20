package com.storage;

import com.exception.StorageException;
import com.model.Resume;
import com.storage.abstractClasses.AbstractStorage;
import com.storage.interfaces.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File>{
    private File directory;
    private StreamSerializer streamSerializer;
    public FileStorage(File directory, StreamSerializer streamSerializer) {
        Objects.requireNonNull(directory,"directory must not be null");
        this.streamSerializer = streamSerializer;
        if(!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath()+" is not directory");
        }if(!directory.canRead() || !directory.canWrite()){
            throw new IllegalArgumentException(directory.getAbsolutePath()+" is not readable / writable");
        }
        this.directory = directory;
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if(list == null){
            throw new StorageException("Directory read error");
        }
        return list.length;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if(files != null){
            for (File file: files){
                doDelete(file);
            }
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            streamSerializer.doWrite(resume,new BufferedOutputStream(new FileOutputStream(file)));
            } catch (IOException e) {
            throw new StorageException("File write error",file.getName(),e);
        }
    }

    @Override
    protected boolean isExist(File file) {

            return file.exists();
    }

    @Override
    protected void doSave(Resume resume, File file) throws IOException {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException(" cannot create file error"+file.getAbsolutePath(),  file.getName(), e);
        }
        doUpdate(resume, file);
    }

    @Override
    protected Resume doGet(File file) {
        try {
           return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if(!file.delete()){
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = directory.listFiles();
        if(files == null){
            throw new StorageException("Directory read error", null);
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file: files){
            list.add(doGet(file));
        }
        return list;
    }
}
