package com.sandBox.workingExamples;

import com.model.Resume;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume("6");
        Constructor[] constructor = resume.getClass().getConstructors();
        Method method = resume.getClass().getMethod("toString");
        Object result = method.invoke(resume);
        System.out.println(result);
    }
}
