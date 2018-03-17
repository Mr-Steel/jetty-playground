package net.steel.jetty.playground;

import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class HelloWorld {

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        WebAppContext ctx = new WebAppContext();
        ctx.setResourceBase("src/main/webapp");

        HashLoginService loginService = new HashLoginService("TestRealm");
        loginService.setConfig("testrealm.txt");
        server.addBean(loginService);
        server.setHandler(ctx);

        server.start();
        server.join();
    }
}
