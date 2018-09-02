package lxz.tutorial.jsch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JschShellChannel {
	public static void main(String[] args) throws Exception {
		try {
			JSch jsch = new JSch();
			SshInfo sshInfo = new SshInfo("192.168.56.21", 22, "u01",
					"C:\\Users\\ezliagu\\Documents\\MobaXterm\\home\\.ssh\\id_rsa", "root");
			jsch.addIdentity(sshInfo.getKey());
			Session session = jsch.getSession(sshInfo.getUser(), sshInfo.getHost(), sshInfo.getPort());
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			Channel channel = session.openChannel("shell");
			OutputStream ops = channel.getOutputStream();
			PrintStream ps = new PrintStream(ops);
			channel.connect();

			ps.println("xxx");
			ps.println("mysql");
			ps.println("show databases;");
			ps.println("exit;");
			ps.println("xxx");
			ps.println("echo EOF");
			
			ps.flush();
			InputStream in = channel.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String jarOutput;
			while ((jarOutput = reader.readLine()) != null)
				System.out.println(jarOutput);
			reader.close();
			channel.disconnect();
			session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class SshInfo {
		String host = null;
		Integer port = 22;
		String user = null;
		String key = null;
		String passPhrase = null;

		public SshInfo(String host, Integer port, String user, String key, String passPhrase) {
			super();
			this.host = host;
			this.port = port;
			this.user = user;
			this.key = key;
			this.passPhrase = passPhrase;
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

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getPassPhrase() {
			return passPhrase;
		}

		public void setPassPhrase(String passPhrase) {
			this.passPhrase = passPhrase;
		}
	}
}
