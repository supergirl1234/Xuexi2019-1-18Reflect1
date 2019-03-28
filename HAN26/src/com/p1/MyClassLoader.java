package com.p1;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> loadData(String name) throws ClassNotFoundException {

        try {
            byte[] classData = loadClassByte(name);

            return this.defineClass(name, classData, 0, classData.length);
        }catch(Exception e){
            e.printStackTrace();

        }

        return super.findClass(name);
    }



    //通过指定的文件路径进行类的文件加载，实际上就是进行二进制文件读取
    //name类-》.class
    //将class文件通过文件读取的方式变成byte[]
    private byte[] loadClassByte(String name) {

        File file=Paths.get("D:","Member.class").toFile();

        try(FileInputStream inputStream=new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream()) {

            int len=-1;

            byte[] buff =new byte[1024];
            while((len=inputStream.read(buff))!=-1){

               byteArrayOutputStream.write(buff,0,len);

            }
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
