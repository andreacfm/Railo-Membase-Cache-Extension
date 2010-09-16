package railo.extension.io.cache.membase;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<InetSocketAddress> addrs = AddrUtil.getAddresses("127.0.0.1:11211 172.16.194.131:11211");

        try {
        	 MemcachedClient mc = new MemcachedClient(
        			 new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.TEXT).build(),
        			 addrs);            
            System.out.println(mc.isAlive());
            Object f = mc.set("test", 60, "value" );
            System.out.println(mc.get("test").toString());
            
        } catch (IOException ex) {
            System.err.println("Couldn't create a connection, bailing out: \nIOException " + ex.getMessage());
        }		
		
	}

}
