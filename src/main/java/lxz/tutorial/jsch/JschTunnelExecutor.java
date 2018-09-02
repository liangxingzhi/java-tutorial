package lxz.tutorial.jsch;

import com.jcraft.jsch.*;
import java.io.*;

import org.apache.commons.io.IOUtils;

/**
 * This class describes how to connect to a internal host with ssh with a jump
 * host
 * 
 * @author lxz
 * 
 */
public class JschTunnelExecutor {

	public static void main(String[] args) {
		JschTunnelExecutor t = new JschTunnelExecutor();
		try {
			t.go();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Session createSession(SshInfo sshInfo) throws Exception {
		JSch jsch = new JSch();
		Session session = jsch.getSession(sshInfo.getUser(), sshInfo.getHost(), sshInfo.getPort());
		session.setPassword(sshInfo.getPassword());
		session.setConfig("StrictHostKeyChecking", "no");
		return session;
	}

	public void go() throws Exception {
		SshInfo jumpHost = new SshInfo("192.168.56.21", 22, "u01", "root");
		SshInfo remoteHost = new SshInfo("192.168.100.22", 22, "u01", "root");
		SshInfo localHost = new SshInfo("127.0.0.1", 2222, remoteHost.getUser(), remoteHost.getPassword());

		Session jumpSession = createSession(jumpHost);
		jumpSession.setPortForwardingL(localHost.getPort(), remoteHost.getHost(), remoteHost.getPort());
		jumpSession.connect();
		jumpSession.openChannel("direct-tcpip");

		// create a session connected to port 2233 on the local host.
		Session secondSession = createSession(localHost);
		secondSession.connect(); // now we're connected to the secondary system

		// /Core/home/om_conf
		String out = executeInSession(secondSession, "hostname");
		System.out.println(out);

		secondSession.disconnect();
		jumpSession.disconnect();
	}

	public String executeInSession(Session secondSession, String command) throws JSchException, IOException {
		Channel channel = secondSession.openChannel("exec");
		((ChannelExec) channel).setCommand(command);
		// channel.setInputStream(null);
		InputStream stdout = channel.getInputStream();
		channel.connect();
		String out = IOUtils.toString(stdout, "UTF-8");
		channel.disconnect();
		return out;
	}

	/**
	 * 
	 * @author lxz
	 *
	 */
	class SshInfo {
		String host = null;
		Integer port = 22;
		String user = null;
		String password = null;

		public SshInfo(String host, Integer port, String user, String password) {
			super();
			this.host = host;
			this.port = port;
			this.user = user;
			this.password = password;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
