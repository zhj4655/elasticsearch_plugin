package com.taste.elasticsearch_taste.grpc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**产生训练数据（目前代码是从文件中加载测试用的一组特定数据）*/
public class GenerateData{

    static final String PATH = "src/main/java/com/taste/elasticsearch_taste/grpc/data";

    public static List<String> generateData(){
        List<String> dataSet = readTxtFileIntoStringArrList(PATH);
        return dataSet;
    }

    public static List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "UTF8";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }
    public static void main(String []args){
//        GenerateData test = new GenerateData();
        List<String> dataSet = GenerateData.readTxtFileIntoStringArrList("src/main/java/com/taste/elasticsearch_taste/grpc/data");
        System.out.println(dataSet);
    }
}