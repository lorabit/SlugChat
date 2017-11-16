package main.java.slugchat.mobile.service;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class Main {

    @Parameter(names = {"--port", "--p"})
    private int port = 50051;

    @Parameter(names = {"--log", "--l"}, required = true)
    private String log;

    @Parameter(names = {"--db.url", "--db"}, required = true)
    private String dbUrl;

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private Server server;

    private void start() throws IOException {

        server = ServerBuilder.forPort(port)
                .addService(new Actions(dbUrl))
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                Main.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void configureLogging(){
        Properties properties = new Properties();
        properties.setProperty("log4j.rootLogger","DEBUG, FILE");
        properties.setProperty("log4j.appender.FILE","org.apache.log4j.FileAppender");
        properties.setProperty("log4j.appender.FILE.File",log);
        properties.setProperty("log4j.appender.FILE.layout","org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.FILE.layout.conversionPattern","5p [%t] (%F:%L) - %m%n");
        PropertyConfigurator.configure(properties);
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        final Main server = new Main();
        JCommander.newBuilder()
                .addObject(server)
                .build()
                .parse(args);

        server.configureLogging();
        server.start();
        server.blockUntilShutdown();
    }

}