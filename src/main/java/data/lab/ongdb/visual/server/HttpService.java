package data.lab.ongdb.visual.server;
/*
 *
 * Data Lab - graph database organization.
 *
 */

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import data.lab.ongdb.visual.common.NeoUrl;
import data.lab.ongdb.visual.util.FileUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yc-Ma
 * @PACKAGE_NAME: data.lab.ongdb.visual.server.HttpService
 * @Description: TODO(HTTP服务端)
 * @date 2020/4/28 17:22
 */
public class HttpService {

    private static Logger logger = LogManager.getLogger(HttpService.class.getName());

    private static String urlInterface;

    public static String getUrlInterface() {
        return urlInterface;
    }

    public static void setUrlInterface(String uri) throws UnknownHostException {
        HttpService.urlInterface = "http://" + getLocalhostIP() + ":8000" + uri;
    }

    public static void setUrlInterface(String uri, int port) throws UnknownHostException {
        HttpService.urlInterface = "http://" + getLocalhostIP() + ":" + port + uri;
    }

    private static String getLocalhostIP() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        return address.getHostAddress();
    }

    /**
     * @param
     * @Description: TODO(获取CSV文件)
     * @return
     */
    private static class NeoCsvHandle implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            URI uri = httpExchange.getRequestURI();
            String uriPath = uri.getPath();
            String csvName = uriPath.split("/")
                    .clone()[uriPath.split("/").length - 1];
            String csvContent = FileUtil.getFileContent(NeoUrl.NEO_CSV.getSymbolValue(), csvName);
            int length = 0;
            if (csvContent != null) {

                // SOLVE-PROBLEM-CORS:No 'Access-Control-Allow-Origin' header is present on the requested resource.
                Headers responseHeaders = httpExchange.getResponseHeaders();
                responseHeaders.set("Access-Control-Allow-Origin", "*");

                length = csvContent.getBytes().length;
                httpExchange.sendResponseHeaders(200, length);
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(csvContent.getBytes());
                outputStream.close();
            }
            logger.info("URI:" + uriPath + " CSV:" + csvName + " CSV-LENGTH:" + length);
        }
    }

    /**
     * @param port:端口号
     * @return
     * @Description: TODO(使用指定端口启动)
     */
    public void run(int port) throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                String uri = "/" + NeoUrl.NEO_CSV.getSymbolValue();
                setUrlInterface(uri, port);
                logger.info("Start http service:" + uri);
                HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
                server.createContext(uri, new NeoCsvHandle());
                server.setExecutor(Executors.newCachedThreadPool());
                server.start();
                logger.info("Http service register ok! URL:" + urlInterface);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param
     * @return
     * @Description: TODO(使用默认端口号启动)
     */
    public void run() throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                String uri = "/" + NeoUrl.NEO_CSV.getSymbolValue();
                setUrlInterface(uri);
                logger.info("Start http service:" + uri);
                HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
                server.createContext(uri, new NeoCsvHandle());
                server.setExecutor(Executors.newCachedThreadPool());
                server.start();
                logger.info("Http service register ok! URL:" + urlInterface);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Configurator.setAllLevels("", Level.INFO);
        new HttpService().run();
    }

}


