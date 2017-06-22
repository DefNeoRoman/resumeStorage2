package com.storage.dataImpl;

import com.exception.StorageException;
import com.model.Resume;
import com.storage.abstractClasses.AbstractStorage;
import com.storage.interfaces.StreamSerializer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;

    private StreamSerializer streamSerializer;

    public PathStorage(String directory, StreamSerializer streamSerializer) {
        Objects.requireNonNull(directory, "directory must not be null");
        this.directory = Paths.get(directory);
        if(!Files.isDirectory(this.directory) || !Files.isWritable(this.directory)){
            throw new IllegalArgumentException(directory + " is not directory or is not writable");
        }
        this.streamSerializer = streamSerializer;
    }

    @Override
    public int size() {

        return  (int)getFilesList().count();
    }
    private Stream<Path> getFilesList(){
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error",null, e);
        }
    }
    @Override
    public void clear() {
        getFilesList().forEach(this::doDelete);
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, Path path) {
        try {
            streamSerializer.doWrite(resume, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path write error", getFileName(path), e);
        }
    }
    private String getFileName(Path path){
        return path.getFileName().toString();
    }
    @Override
    protected boolean isExist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void doSave(Resume resume, Path path) throws IOException {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create path " + path.toString(), getFileName(path), e);
        }
        doUpdate(resume, path);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", getFileName(path), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", getFileName(path), e);

        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        return getFilesList().map(this::doGet).collect(Collectors.toList());
    }
}
