package com.sandBox.workingExamples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFile {
    private static List<String> files = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       
        String filePath = ".\\.gitignore";
        File file = new File(filePath);

        if (file.isFile()) {
            System.out.println("File is Already exist");
        }
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException("Error ", e);
        }


        fileSearcher("src");
        files.forEach(System.out::println);

            try(FileWriter fileWriter = new FileWriter("D:\\forJava\\examples\\resumeStorage\\sandBoxText.txt"))
            {
                files.forEach(s -> {
                    try {
                        fileWriter.write(s+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }catch (IOException e) {
                e.printStackTrace();
            }
        }




    private static void fileSearcher(String path) throws IOException {
        File file = new File(path);

        if(file.isDirectory()){
            File[] files2 = file.listFiles();
            for(File f: files2){
                if(f.isDirectory()){

                    fileSearcher(f.getAbsolutePath());
                }else{
                    files.add(f.getCanonicalPath());
                // System.out.println(f.getCanonicalPath());
                }
            }
        } else {
            files.add(file.getAbsolutePath());
          // System.out.println(file.getCanonicalPath());
        }
        //filesBefore.forEach(System.out::println);

    }
//    private void copyAndExecute(File file) throws IOException {
//
//
//        File sourceFile = new File(file.getPath());
//        Path sourcePath = sourceFile.toPath();
//        File destFile = new File(new File("bla") + "\\" + file.getName());
//        Path destPath = destFile.toPath();
//        CopyOption[] options = new CopyOption[]{
//                StandardCopyOption.REPLACE_EXISTING,
//                StandardCopyOption.COPY_ATTRIBUTES
//        };
//        Files.copy(sourcePath, destPath, options);
//        Desktop.getDesktop().open(destFile);
//    }
}
