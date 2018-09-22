package com.taste.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: connection.proto")
public final class ConnectionGrpc {

  private ConnectionGrpc() {}

  public static final String SERVICE_NAME = "es.Connection";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.taste.grpc.ConnRequest,
      com.taste.grpc.ConnResponse> getConnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Conn",
      requestType = com.taste.grpc.ConnRequest.class,
      responseType = com.taste.grpc.ConnResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.taste.grpc.ConnRequest,
      com.taste.grpc.ConnResponse> getConnMethod() {
    io.grpc.MethodDescriptor<com.taste.grpc.ConnRequest, com.taste.grpc.ConnResponse> getConnMethod;
    if ((getConnMethod = ConnectionGrpc.getConnMethod) == null) {
      synchronized (ConnectionGrpc.class) {
        if ((getConnMethod = ConnectionGrpc.getConnMethod) == null) {
          ConnectionGrpc.getConnMethod = getConnMethod = 
              io.grpc.MethodDescriptor.<com.taste.grpc.ConnRequest, com.taste.grpc.ConnResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "es.Connection", "Conn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.taste.grpc.ConnRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.taste.grpc.ConnResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ConnectionMethodDescriptorSupplier("Conn"))
                  .build();
          }
        }
     }
     return getConnMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectionStub newStub(io.grpc.Channel channel) {
    return new ConnectionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConnectionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConnectionFutureStub(channel);
  }

  /**
   */
  public static abstract class ConnectionImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.taste.grpc.ConnRequest> conn(
        io.grpc.stub.StreamObserver<com.taste.grpc.ConnResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getConnMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConnMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.taste.grpc.ConnRequest,
                com.taste.grpc.ConnResponse>(
                  this, METHODID_CONN)))
          .build();
    }
  }

  /**
   */
  public static final class ConnectionStub extends io.grpc.stub.AbstractStub<ConnectionStub> {
    private ConnectionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.taste.grpc.ConnRequest> conn(
        io.grpc.stub.StreamObserver<com.taste.grpc.ConnResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getConnMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ConnectionBlockingStub extends io.grpc.stub.AbstractStub<ConnectionBlockingStub> {
    private ConnectionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ConnectionFutureStub extends io.grpc.stub.AbstractStub<ConnectionFutureStub> {
    private ConnectionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CONN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConnectionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConnectionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.conn(
              (io.grpc.stub.StreamObserver<com.taste.grpc.ConnResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.taste.grpc.ConnectionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Connection");
    }
  }

  private static final class ConnectionFileDescriptorSupplier
      extends ConnectionBaseDescriptorSupplier {
    ConnectionFileDescriptorSupplier() {}
  }

  private static final class ConnectionMethodDescriptorSupplier
      extends ConnectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConnectionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectionFileDescriptorSupplier())
              .addMethod(getConnMethod())
              .build();
        }
      }
    }
    return result;
  }
}
