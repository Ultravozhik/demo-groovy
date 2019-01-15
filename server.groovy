import java.net.*
class SimpleWebServer {
    public static void main(String[] args){
        def server = new ServerSocket(args[0].toInteger())
        while(true) {

            server.accept() { socket ->
                socket.withStreams { input, output ->
                    try {
                        println "------------------------------------"
                        input.eachLine() { line ->

                            if (line.length() == 0) {
                                throw new GroovyRuntimeException()
                            }
                            output.withWriter { writer ->
                                writer << "HTTP/1.1 200 OK"
                                writer.println()
                                writer << "Content-Type: text/html"
                                writer.println()
                                writer.println()
                                writer << "Hello World!"
                            }
                            println line

                        }
                    } catch (Exception b) {
                        if(!b)
                            println "nn sorry, exception : $b"

                        println "------------------------------------"
                    }
                }
            }
        }
    }
}