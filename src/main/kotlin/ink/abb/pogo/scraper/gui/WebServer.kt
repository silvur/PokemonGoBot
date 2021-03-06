package ink.abb.pogo.scraper.gui

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.io.IOException
import java.net.InetSocketAddress
import java.nio.file.Files
import java.nio.file.Paths

class WebServer {
    @Throws(Exception::class)
    fun start(port: Int) {
        Thread(){
            val server = HttpServer.create(InetSocketAddress(port), 0)
            server.createContext("/", RootHandler())
            server.executor = null
            server.start()
        }.start()
    }

    inner class RootHandler : HttpHandler {
        @Throws(IOException::class)
        override fun handle(t: HttpExchange) {
            val encoded = Files.readAllBytes(Paths.get("gui/index.html"))
            t.responseHeaders.set("Content-Type", "text/html; charset=UTF-8")
            t.sendResponseHeaders(200, encoded.size.toLong())
            t.responseBody.write(encoded)
            t.responseBody.close()
        }
    }
}