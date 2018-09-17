package com.taste.elasticsearch_taste.grpc;

import com.taste.grpc.ConnRequest;
import com.taste.grpc.ConnResponse;
import com.taste.grpc.ConnectionGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnClient {
    private static final Logger logger = Logger.getLogger(ConnClient.class.getName());

    private final ManagedChannel channel;
    //    private final ConnectionGrpc.ConnectionBlockingStub blockingStub;
    private final ConnectionGrpc.ConnectionStub asyncStub;

    public ConnClient(String host, int port){
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    //构建阻塞和异步两种客户端
    public ConnClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
//        blockingStub = ConnectionGrpc.newBlockingStub(channel);
        asyncStub = ConnectionGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

/****************以上都是连接服务端*******************/


    /********从外部调用此方法，向服务器传送消息，并返回结果*/
    public List<String> sendRequest(List<ConnRequest> datas) {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        int count = datas.size();

        List<String> result = new ArrayList<>();
        /**response 创建一个responseStreamObsever，用于接收服务端消息*/
        StreamObserver<ConnResponse> responseStreamObserver = new StreamObserver<ConnResponse>() {
            @Override
            public void onNext(ConnResponse connResponse) {
                /**此处接收服务端的数据*/
                result.add(connResponse.getResponse());
//                info("response: " + connResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                warning("get response failed : {0}", Status.fromThrowable(throwable));
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };


        /**request 发送请求部分*/
        StreamObserver<ConnRequest> requestStreamObserver = asyncStub.conn(responseStreamObserver);
        try {
            for(int i = 0; i < count; i++){
                ConnRequest data = datas.get(i);
                requestStreamObserver.onNext(data);

                Thread.sleep(500);//发完一条消息等一会
                if(finishLatch.getCount() == 0){
                    break;
                }
            }
        }catch (RuntimeException e){
            requestStreamObserver.onError(e);
            throw e;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestStreamObserver.onCompleted();

        /**如果消息未接收完毕，一直阻塞*/
        try {
            while(finishLatch.getCount() > 0){
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return result;

    }

    private void info(String msg, Object... params) {
        logger.log(Level.INFO, msg, params);
    }
    private void warning(String msg, Object... params) {
        logger.log(Level.WARNING, msg, params);
    }


    public static void main(String []args) throws InterruptedException{
        List<String> reqdata = new ArrayList<>();
        reqdata.add("java request1");
        reqdata.add("java request2");
        List<ConnRequest> test_datas= FormatGrpcData.formatDate(reqdata);
        ConnClient client = new ConnClient("localhost", 12345);
        try {
            List<String> result = client.sendRequest(test_datas);
            System.out.println("result: "+result);
//            Thread.sleep(2000);
        }finally{
            client.shutdown();
        }
    }

}