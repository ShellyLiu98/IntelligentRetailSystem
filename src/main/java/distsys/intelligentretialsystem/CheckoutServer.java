
package distsys.intelligentretialsystem;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
/**
 *
 * @author JiaLiu
 */

public class CheckoutServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new CheckoutServiceImpl()) 
                .build();

        System.out.println("Checkout gRPC Server started on port 50051");
        server.start();
        server.awaitTermination();
    }
}
