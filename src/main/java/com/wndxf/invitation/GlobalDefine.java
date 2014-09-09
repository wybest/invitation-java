package com.wndxf.invitation;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wy
 */
public class GlobalDefine {

    public static String errorMessage="errorMessage";
    public static String message="message";
    public static String user="user";
    public static String ERROR = "error";
    public static String MESSAGE = "message";
    public static String imagePath;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
    private static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    public static String getFolderName(){
        return format.format(new Date());
    }

    public static String getFileName(){
        return format1.format(new Date());
    }

    public static void setImagePath(String imagePath) {
        GlobalDefine.imagePath = imagePath;
    }

    public static String getImagePath(){
        return GlobalDefine.imagePath;
    }

    public static boolean deleteFile(File file){
        if(file.isFile()){
            file.delete();
            return true;
        }else{
            return false;
        }
    }

    public static String getBackground(String[] images){
        String ims = "";
        for (String image:images){
            ims += image+",";
        }
        return ims;
    }
}
