package com.paytm.thrift.tutorial.server;

import com.paytm.thrift.tutorial.service.CrossPlatformService;
import com.paytm.thrift.tutorial.service.impl.CrossPlatformServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class CrossPlatformServiceServer {

    TServer server;

    public void start() throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(9090);
        server = new TSimpleServer(new TServer.Args(serverTransport)
                .processor(new CrossPlatformService.Processor<>(new CrossPlatformServiceImpl())));

        System.out.print("Starting the server... ");
        server.serve();
        System.out.println("Done.");
    }

    public void stop() {
        if (server != null && server.isServing()) {
            System.out.print("Stopping the server... ");
            server.stop();
            System.out.println("Done.");
        }
    }
}