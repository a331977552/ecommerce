package com.food.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {

    public static void main(String[] args) throws IOException {
        int dot = "21321421321.jpg".lastIndexOf('.');
        String suffix = "21321421321.jpg".substring(dot);
        if(dot==-1){
            suffix = "";
        }else{
            suffix = "21321421321.jpg".substring(dot);
        }
    }

    public static File createFolder(String folder){

        File dic = new File(folder);
        boolean exists = dic.exists();
        if (!exists) {
            boolean mkdirs = dic.mkdirs();
            if (!mkdirs)
                throw new FileSystemException("创建文件夹 " + folder + " 失败");
        }
        return dic;
    }

    public static String  generateFileDirectory()  {
        String s = UUID.randomUUID().toString().replace("-", "");
        String folder1 = s.substring(0, 2);
        String folder2 = s.substring(2, 4);
        String folder3 = s.substring(4, 6);
        String folder4 = s.substring(8, 10);
        String folder5 = s.substring(10, 12);
        String folder6 = s.substring(12, 14);
        return folder1 +File.separator + folder2 + File.separator + folder3 + File.separator + folder4 + File.separator + folder5 + File.separator + folder6;

    }


}
