package distsys.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: inventory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InventoryServiceGrpc {

  private InventoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "distsys.InventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<distsys.generated.ProductRequest,
      distsys.generated.StockResponse> getCheckStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckStock",
      requestType = distsys.generated.ProductRequest.class,
      responseType = distsys.generated.StockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<distsys.generated.ProductRequest,
      distsys.generated.StockResponse> getCheckStockMethod() {
    io.grpc.MethodDescriptor<distsys.generated.ProductRequest, distsys.generated.StockResponse> getCheckStockMethod;
    if ((getCheckStockMethod = InventoryServiceGrpc.getCheckStockMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getCheckStockMethod = InventoryServiceGrpc.getCheckStockMethod) == null) {
          InventoryServiceGrpc.getCheckStockMethod = getCheckStockMethod =
              io.grpc.MethodDescriptor.<distsys.generated.ProductRequest, distsys.generated.StockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.StockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("CheckStock"))
              .build();
        }
      }
    }
    return getCheckStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.generated.StockUpdateRequest,
      distsys.generated.StockUpdateResponse> getMonitorStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorStock",
      requestType = distsys.generated.StockUpdateRequest.class,
      responseType = distsys.generated.StockUpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.generated.StockUpdateRequest,
      distsys.generated.StockUpdateResponse> getMonitorStockMethod() {
    io.grpc.MethodDescriptor<distsys.generated.StockUpdateRequest, distsys.generated.StockUpdateResponse> getMonitorStockMethod;
    if ((getMonitorStockMethod = InventoryServiceGrpc.getMonitorStockMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getMonitorStockMethod = InventoryServiceGrpc.getMonitorStockMethod) == null) {
          InventoryServiceGrpc.getMonitorStockMethod = getMonitorStockMethod =
              io.grpc.MethodDescriptor.<distsys.generated.StockUpdateRequest, distsys.generated.StockUpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.StockUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.StockUpdateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("MonitorStock"))
              .build();
        }
      }
    }
    return getMonitorStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.generated.ProductRequest,
      distsys.generated.StockUpdateResponse> getStreamStockUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamStockUpdates",
      requestType = distsys.generated.ProductRequest.class,
      responseType = distsys.generated.StockUpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.generated.ProductRequest,
      distsys.generated.StockUpdateResponse> getStreamStockUpdatesMethod() {
    io.grpc.MethodDescriptor<distsys.generated.ProductRequest, distsys.generated.StockUpdateResponse> getStreamStockUpdatesMethod;
    if ((getStreamStockUpdatesMethod = InventoryServiceGrpc.getStreamStockUpdatesMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getStreamStockUpdatesMethod = InventoryServiceGrpc.getStreamStockUpdatesMethod) == null) {
          InventoryServiceGrpc.getStreamStockUpdatesMethod = getStreamStockUpdatesMethod =
              io.grpc.MethodDescriptor.<distsys.generated.ProductRequest, distsys.generated.StockUpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamStockUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.StockUpdateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("StreamStockUpdates"))
              .build();
        }
      }
    }
    return getStreamStockUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub>() {
        @java.lang.Override
        public InventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceStub(channel, callOptions);
        }
      };
    return InventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub>() {
        @java.lang.Override
        public InventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return InventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub>() {
        @java.lang.Override
        public InventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceFutureStub(channel, callOptions);
        }
      };
    return InventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void checkStock(distsys.generated.ProductRequest request,
        io.grpc.stub.StreamObserver<distsys.generated.StockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckStockMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<distsys.generated.StockUpdateRequest> monitorStock(
        io.grpc.stub.StreamObserver<distsys.generated.StockUpdateResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMonitorStockMethod(), responseObserver);
    }

    /**
     */
    default void streamStockUpdates(distsys.generated.ProductRequest request,
        io.grpc.stub.StreamObserver<distsys.generated.StockUpdateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamStockUpdatesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InventoryService.
   */
  public static abstract class InventoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InventoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InventoryService.
   */
  public static final class InventoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InventoryServiceStub> {
    private InventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkStock(distsys.generated.ProductRequest request,
        io.grpc.stub.StreamObserver<distsys.generated.StockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.generated.StockUpdateRequest> monitorStock(
        io.grpc.stub.StreamObserver<distsys.generated.StockUpdateResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMonitorStockMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void streamStockUpdates(distsys.generated.ProductRequest request,
        io.grpc.stub.StreamObserver<distsys.generated.StockUpdateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamStockUpdatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InventoryService.
   */
  public static final class InventoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InventoryServiceBlockingStub> {
    private InventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public distsys.generated.StockResponse checkStock(distsys.generated.ProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<distsys.generated.StockUpdateResponse> streamStockUpdates(
        distsys.generated.ProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamStockUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InventoryService.
   */
  public static final class InventoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InventoryServiceFutureStub> {
    private InventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<distsys.generated.StockResponse> checkStock(
        distsys.generated.ProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_STOCK = 0;
  private static final int METHODID_STREAM_STOCK_UPDATES = 1;
  private static final int METHODID_MONITOR_STOCK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_STOCK:
          serviceImpl.checkStock((distsys.generated.ProductRequest) request,
              (io.grpc.stub.StreamObserver<distsys.generated.StockResponse>) responseObserver);
          break;
        case METHODID_STREAM_STOCK_UPDATES:
          serviceImpl.streamStockUpdates((distsys.generated.ProductRequest) request,
              (io.grpc.stub.StreamObserver<distsys.generated.StockUpdateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_STOCK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorStock(
              (io.grpc.stub.StreamObserver<distsys.generated.StockUpdateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCheckStockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              distsys.generated.ProductRequest,
              distsys.generated.StockResponse>(
                service, METHODID_CHECK_STOCK)))
        .addMethod(
          getMonitorStockMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              distsys.generated.StockUpdateRequest,
              distsys.generated.StockUpdateResponse>(
                service, METHODID_MONITOR_STOCK)))
        .addMethod(
          getStreamStockUpdatesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              distsys.generated.ProductRequest,
              distsys.generated.StockUpdateResponse>(
                service, METHODID_STREAM_STOCK_UPDATES)))
        .build();
  }

  private static abstract class InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return distsys.generated.InventoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryService");
    }
  }

  private static final class InventoryServiceFileDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier {
    InventoryServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryServiceMethodDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InventoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryServiceFileDescriptorSupplier())
              .addMethod(getCheckStockMethod())
              .addMethod(getMonitorStockMethod())
              .addMethod(getStreamStockUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
