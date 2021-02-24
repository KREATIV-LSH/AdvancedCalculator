package ch.lsh.advancedcalculator.util;

import java.util.*;
import java.io.*;

public class FileUtils
{
    public static boolean exists(final String file) {
        final File x = new File(file);
        return x.exists();
    }
    
    public static boolean createFolder(String path) {
    	File x = new File(path);
    	return x.mkdirs();
    }
    
    public static String readFile(final String file) {
        String json = "";
        try {
            final Scanner x = new Scanner(new File(file));
            while (x.hasNext()) {
                json = String.valueOf(json) + "\n" + x.next();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("could not find file!");
        }
        return json;
    }
    
    public static void removeFile(final String file) {
        final File x = new File(file);
        x.delete();
    }
    
    public static void saveFile(final String file, final String contet) {
        final File x = new File(file);
        if (exists(file)) {
            try {
                x.setWritable(true);
                final FileWriter fw = new FileWriter(x);
                fw.write(contet);
                fw.flush();
                fw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                x.createNewFile();
                x.setWritable(true);
                saveFile(file, contet);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}