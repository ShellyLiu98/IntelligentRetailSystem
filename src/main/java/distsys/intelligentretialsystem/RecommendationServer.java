package distsys.intelligentretialsystem;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 *
 * @author 刘佳
 */




public class RecommendationServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50053)
                .addService(new RecommendationServiceImpl())
                .build();

        System.out.println("✅ Recommendation gRPC Server started on port 50053");
        server.start();
        server.awaitTermination();
    }
}
