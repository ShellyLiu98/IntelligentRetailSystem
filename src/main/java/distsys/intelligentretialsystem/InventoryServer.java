
package distsys.intelligentretialsystem;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
/**
 *
 * @author 刘佳
 */

public class InventoryServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50052)
                .addService(new InventoryServiceImpl()) 
                .build();

        System.out.println("Inventory gRPC Server started on port 50052");
        server.start();
        server.awaitTermination();
    }
}

