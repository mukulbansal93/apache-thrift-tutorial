package com.paytm.thrift.tutorial;

import com.paytm.thrift.tutorial.client.CrossPlatformServiceClient;
import com.paytm.thrift.tutorial.server.CrossPlatformServiceServer;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheThriftTutorialApplication {

	public static void main(String[] args) throws TTransportException {
		SpringApplication.run(ApacheThriftTutorialApplication.class, args);

		new Thread(){
			@Override
			public void run() {
				CrossPlatformServiceServer server = new CrossPlatformServiceServer();
				try {
					server.start();
				} catch (TTransportException e) {
					e.printStackTrace();
				}
			}
		}.start();

		CrossPlatformServiceClient client = new CrossPlatformServiceClient();
		client.ping();
	}

}
