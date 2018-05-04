package lxz.tutorial.java.lang;

import java.io.*;

public class Test {
    static class StreamGobbler extends Thread {
        InputStream is;
        String type;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null)
                    System.out.println(type + ">" + line);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String rulFilePath = args[0];
        String inventoryFilePath = args[1];
        String outputSettingFilePath = args[2];
        executeShell(rulFilePath, inventoryFilePath, outputSettingFilePath);
    }

    public static boolean executeShell(String rulFilePath, String inventoryFilePath, String outputSettingFilePath)
            throws IOException, InterruptedException {
        String shell = "/home/ecap/data-integration/pan.sh" + " -file=" + rulFilePath + " -param:I_INVENTORY_JSON=" + inventoryFilePath
                + " -param:O_CONFIG_YAML=" + outputSettingFilePath;
        System.out.println(shell);
        Process ps = Runtime.getRuntime().exec(shell, null, new File("/home/ecap"));
        StreamGobbler out = new StreamGobbler(ps.getInputStream(), "OUT");
        StreamGobbler err = new StreamGobbler(ps.getErrorStream(), "ERROR");
        out.start();
        err.start();
        ps.waitFor();
        return false;
    }
}
