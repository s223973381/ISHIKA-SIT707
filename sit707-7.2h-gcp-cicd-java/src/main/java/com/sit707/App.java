package com.sit707;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {// trigger build

    public static int add(int a, int b) {
        return a + b;
    }

    public static String getTaskStatus(int score) {
        if (score >= 80) {
            return "HD";
        } else if (score >= 70) {
            return "D";
        } else if (score >= 60) {
            return "C";
        } else if (score >= 50) {
            return "P";
        } else {
            return "N";
        }
    }

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", exchange -> {
            String response = "SIT707 Task 7.2H Java CI/CD Deployment Successful!";
            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server started on port " + port);
    }
}