package com.taste.elasticsearch_taste.grpc;

import com.taste.grpc.ConnRequest;

import java.util.ArrayList;
import java.util.List;

public class FormatGrpcData {

    /**格式化数据，将string list转换为ConnRequest list*/
    public static List<ConnRequest> formatDate(String type,List<String> datas){
        List<ConnRequest> fDatas = new ArrayList<>();
        fDatas.add(ConnRequest.newBuilder().setRequest(type).build());
        for(String data : datas){
            fDatas.add(ConnRequest.newBuilder().setRequest(data).build());
        }
        return fDatas;
    }
    /**格式化一条数据，将String转换为ConnRequest*/
    public static ConnRequest formatOneData(String data){
        return ConnRequest.newBuilder().setRequest(data).build();
    }
}