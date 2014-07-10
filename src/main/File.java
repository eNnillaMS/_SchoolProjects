package main;
import java.io.IOException;
public class File {
    private java.io.File file;
    private java.io.FileReader fr;
    private java.io.FileWriter fw;
    private java.io.BufferedReader br;
    private java.io.BufferedWriter bw;
    
    public File(String filepath){
        file = new java.io.File(filepath);
    }
    
    public boolean exists(){
        return file.exists();
    }
    public boolean isFile(){
        return file.isFile();
    }
    public boolean create(){
        boolean a;
        try {
            a = file.createNewFile();
        } catch (IOException e){
            a = false;
        }
        return a;
    }
    public boolean write(String text){
        try {
            if (!exists()) create();
            fw = new java.io.FileWriter(file);
            bw = new java.io.BufferedWriter(fw);
            for (String a : text.split("\n")){
                bw.write(a);
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public String read(){
        String a = "", t;
        try {
            fr = new java.io.FileReader(file);
            br = new java.io.BufferedReader(fr);
            while ((t = br.readLine()) != null){
                if (!a.equals("")) a += "\n";
                a += t;
            }
            br.close();
            fr.close();
        } catch (Exception ex){
            a = null;
        }
        return a;
    }
    public boolean rename(String newName){
        boolean a = file.renameTo(new java.io.File(newName));
        if (a) file = new java.io.File(newName);
        return a;
    }
    public boolean compare(String otherFile){
        return (file.compareTo(new java.io.File(otherFile)) == 0);
    }
    public boolean delete(){
        return file.delete();
    }
    public String getName(){
        return file.getName().substring(0, file.getName().lastIndexOf("."));
    }
    public String getFullName(){
        return file.getName();
    }
    public String getPath(){
        return file.getPath().substring(0, file.getPath().lastIndexOf("\\") + 1);
    }
    public String getFullPath(){
        return file.getPath();
    }
    public long getSize(){
        if (exists()) return file.length();
        else return -1;
    }
}