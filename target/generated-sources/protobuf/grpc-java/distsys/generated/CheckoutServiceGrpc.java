package distsys.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: checkout.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CheckoutServiceGrpc {

  private CheckoutServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "distsys.CheckoutService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<distsys.generated.ShoppingCart,
      distsys.generated.PaymentResponse> getProcessPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPayment",
      requestType = distsys.generated.ShoppingCart.class,
      responseType = distsys.generated.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.generated.ShoppingCart,
      distsys.generated.PaymentResponse> getProcessPaymentMethod() {
    io.grpc.MethodDescriptor<distsys.generated.ShoppingCart, distsys.generated.PaymentResponse> getProcessPaymentMethod;
    if ((getProcessPaymentMethod = CheckoutServiceGrpc.getProcessPaymentMethod) == null) {
      synchronized (CheckoutServiceGrpc.class) {
        if ((getProcessPaymentMethod = CheckoutServiceGrpc.getProcessPaymentMethod) == null) {
          CheckoutServiceGrpc.getProcessPaymentMethod = getProcessPaymentMethod =
              io.grpc.MethodDescriptor.<distsys.generated.ShoppingCart, distsys.generated.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.ShoppingCart.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.PaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckoutServiceMethodDescriptorSupplier("ProcessPayment"))
              .build();
        }
      }
    }
    return getProcessPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.generated.PaymentRequest,
      distsys.generated.PaymentResponse> getPaymentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PaymentStatus",
      requestType = distsys.generated.PaymentRequest.class,
      responseType = distsys.generated.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.generated.PaymentRequest,
      distsys.generated.PaymentResponse> getPaymentStatusMethod() {
    io.grpc.MethodDescriptor<distsys.generated.PaymentRequest, distsys.generated.PaymentResponse> getPaymentStatusMethod;
    if ((getPaymentStatusMethod = CheckoutServiceGrpc.getPaymentStatusMethod) == null) {
      synchronized (CheckoutServiceGrpc.class) {
        if ((getPaymentStatusMethod = CheckoutServiceGrpc.getPaymentStatusMethod) == null) {
          CheckoutServiceGrpc.getPaymentStatusMethod = getPaymentStatusMethod =
              io.grpc.MethodDescriptor.<distsys.generated.PaymentRequest, distsys.generated.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PaymentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.PaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckoutServiceMethodDescriptorSupplier("PaymentStatus"))
              .build();
        }
      }
    }
    return getPaymentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<distsys.generated.PaymentRequest,
      distsys.generated.PaymentResponse> getStreamPaymentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamPaymentStatus",
      requestType = distsys.generated.PaymentRequest.class,
      responseType = distsys.generated.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<distsys.generated.PaymentRequest,
      distsys.generated.PaymentResponse> getStreamPaymentStatusMethod() {
    io.grpc.MethodDescriptor<distsys.generated.PaymentRequest, distsys.generated.PaymentResponse> getStreamPaymentStatusMethod;
    if ((getStreamPaymentStatusMethod = CheckoutServiceGrpc.getStreamPaymentStatusMethod) == null) {
      synchronized (CheckoutServiceGrpc.class) {
        if ((getStreamPaymentStatusMethod = CheckoutServiceGrpc.getStreamPaymentStatusMethod) == null) {
          CheckoutServiceGrpc.getStreamPaymentStatusMethod = getStreamPaymentStatusMethod =
              io.grpc.MethodDescriptor.<distsys.generated.PaymentRequest, distsys.generated.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamPaymentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  distsys.generated.PaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckoutServiceMethodDescriptorSupplier("StreamPaymentStatus"))
              .build();
        }
      }
    }
    return getStreamPaymentStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckoutServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceStub>() {
        @java.lang.Override
        public CheckoutServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutServiceStub(channel, callOptions);
        }
      };
    return CheckoutServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckoutServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceBlockingStub>() {
        @java.lang.Override
        public CheckoutServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutServiceBlockingStub(channel, callOptions);
        }
      };
    return CheckoutServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckoutServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutServiceFutureStub>() {
        @java.lang.Override
        public CheckoutServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutServiceFutureStub(channel, callOptions);
        }
      };
    return CheckoutServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<distsys.generated.ShoppingCart> processPayment(
        io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getProcessPaymentMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<distsys.generated.PaymentRequest> paymentStatus(
        io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPaymentStatusMethod(), responseObserver);
    }

    /**
     */
    default void streamPaymentStatus(distsys.generated.PaymentRequest request,
        io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamPaymentStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CheckoutService.
   */
  public static abstract class CheckoutServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CheckoutServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CheckoutService.
   */
  public static final class CheckoutServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CheckoutServiceStub> {
    private CheckoutServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.generated.ShoppingCart> processPayment(
        io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<distsys.generated.PaymentRequest> paymentStatus(
        io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPaymentStatusMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void streamPaymentStatus(distsys.generated.PaymentRequest request,
        io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamPaymentStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CheckoutService.
   */
  public static final class CheckoutServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CheckoutServiceBlockingStub> {
    private CheckoutServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<distsys.generated.PaymentResponse> streamPaymentStatus(
        distsys.generated.PaymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamPaymentStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CheckoutService.
   */
  public static final class CheckoutServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CheckoutServiceFutureStub> {
    private CheckoutServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_PAYMENT_STATUS = 0;
  private static final int METHODID_PROCESS_PAYMENT = 1;
  private static final int METHODID_PAYMENT_STATUS = 2;

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
        case METHODID_STREAM_PAYMENT_STATUS:
          serviceImpl.streamPaymentStatus((distsys.generated.PaymentRequest) request,
              (io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse>) responseObserver);
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
        case METHODID_PROCESS_PAYMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processPayment(
              (io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse>) responseObserver);
        case METHODID_PAYMENT_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.paymentStatus(
              (io.grpc.stub.StreamObserver<distsys.generated.PaymentResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getProcessPaymentMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              distsys.generated.ShoppingCart,
              distsys.generated.PaymentResponse>(
                service, METHODID_PROCESS_PAYMENT)))
        .addMethod(
          getPaymentStatusMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              distsys.generated.PaymentRequest,
              distsys.generated.PaymentResponse>(
                service, METHODID_PAYMENT_STATUS)))
        .addMethod(
          getStreamPaymentStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              distsys.generated.PaymentRequest,
              distsys.generated.PaymentResponse>(
                service, METHODID_STREAM_PAYMENT_STATUS)))
        .build();
  }

  private static abstract class CheckoutServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckoutServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return distsys.generated.CheckoutProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckoutService");
    }
  }

  private static final class CheckoutServiceFileDescriptorSupplier
      extends CheckoutServiceBaseDescriptorSupplier {
    CheckoutServiceFileDescriptorSupplier() {}
  }

  private static final class CheckoutServiceMethodDescriptorSupplier
      extends CheckoutServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CheckoutServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CheckoutServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckoutServiceFileDescriptorSupplier())
              .addMethod(getProcessPaymentMethod())
              .addMethod(getPaymentStatusMethod())
              .addMethod(getStreamPaymentStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
