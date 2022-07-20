package com.example.a05androidpemula;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServices {
    public static List<String> readFileTxt (String filename){
        try {
            List<String> data = new ArrayList<>();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){ // ada tidaknya data
                String lineData = scanner.nextLine();// baru yang ditangkap nextline
                data.add(lineData);
            }
            return data;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }}
