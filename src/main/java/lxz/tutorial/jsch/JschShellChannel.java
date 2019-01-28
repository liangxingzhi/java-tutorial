package lxz.tutorial.jsch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * //remove the ansi color codes, messy codes etc. // sed 's/\x1b\[[0-9;]*m\x0f?//g'
 *
 */
public class JschShellChannel {
	public static void main(String[] args) throws Exception {
		try {
			JSch jsch = new JSch();
			SshInfo sshInfo = new SshInfo("192.168.56.10", 22, "root",
					"C:\\Users\\ezliagu\\Documents\\MobaXterm\\home\\.ssh\\id_rsa", "root");
			jsch.addIdentity(sshInfo.getKey());
			Session session = jsch.getSession(sshInfo.getUser(), sshInfo.getHost(), sshInfo.getPort());
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(sshInfo.getPassPhrase());
			session.connect();
			ChannelShell channel = (ChannelShell)session.openChannel("shell");
			channel.setPtyType("exec");
			OutputStream ops = channel.getOutputStream();
			PrintStream ps = new PrintStream(ops);
			channel.connect();

			ps.println("ssh root@192.168.56.20");
			ps.println("pwd");
			ps.println("ls");
			ps.flush();
			ps.println("exit");
			ps.flush();
			ps.println("logout");
			ps.flush();
			InputStream in = channel.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("US-ASCII")));
			String jarOutput;
			while ((jarOutput = reader.readLine()) != null) {
				System.out.println(jarOutput);
//				for(byte b: jarOutput.getBytes()) {
//					System.out.print(Integer.toHexString(b) + ":" + (char)b + "  ") ;	
//				}
				System.out.println();
//				System.out.println(jarOutput.replaceAll("\u001B\\[[;\\d]*m(\u000F)?|(\\u0020)(\\u0008)", ""));
//				System.out.println("------------------------------------------------");
//				// remove the ansi color codes, messy codes etc.
//				// sed 's/\x1b\[[0-9;]*m//g'
//				System.out.println("----------------");
//				System.out.println(jarOutput.replaceAll("\u001B\\[[;\\d]*mf", "").replaceAll("\u001B\\[[;\\d]*m", "").replaceAll("\u001B\\[[;\\d]*f", ""));
//				for(byte b: jarOutput.replaceAll("\u001B\\[[;\\d]*mf", "").getBytes("UTF-8")) {
//					System.out.print(Integer.toHexString(b) + ":" + (char)b + "  ") ;	
//				}
//				System.out.println();
//				System.out.println("----------------");
//				System.out.println("----------------");
//				System.out.println(jarOutput);
//				for(byte b: jarOutput.getBytes("UTF-8")) {
//					System.out.print(Integer.toHexString(b) + ":" + (char)b + "  ") ;	
//				}
//				System.out.println();
//				System.out.println("----------------");
				if(jarOutput.equals("Connection to 192.168.56.20 closed.")) {
					ps.println("logout");
					ps.flush();
				}
				
			}
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
