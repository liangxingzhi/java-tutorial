import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class Questionaire
{
    static final List<String> ignored_list = Arrays.asList(".git", ".gitignore",
            ".project", "mindmap", "README.txt");

    public static void main(String[] args)
    {
        String path = "C:\\git\\technical-recruiter\\question-bank";
        File bankDir = new File(path);
        if (bankDir != null && bankDir.isDirectory())
        {
            MutableTreeNode rootNode = listAll(bankDir, 0);
            System.out.println(rootNode);
            final JTree tree = new JTree(rootNode);
            JFrame f = new JFrame("JTreeDemo");
            f.add(tree);
            f.setSize(300, 300);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 添加选择事件
            tree.addTreeSelectionListener(new TreeSelectionListener() {
     
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
                            .getLastSelectedPathComponent();
     
                    if (node == null)
                        return;
     
                    Object object = node.getUserObject();
                    if (node.isLeaf()) {
                        User user = (User) object;
                        System.out.println("你选择了：" + user.toString());
                    }
     
                }
            });
            tree.setScrollsOnExpand(true);
        }
        else
        {
            String errorMessage = "question bank path is not correct";
        }
        
    }

    public static MutableTreeNode listAll(File f, int level)
    {
        String blanks = "";
        for(int i = 0; i < level; i++) {
            blanks += "    ";
        }
        if (f == null || ignored_list.contains(f.getName()))
        {
            return null;
        }
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(new KnowledgeScope(f.getName(), f.getPath(), !f.isDirectory()));
        if (f.isDirectory())
        {
            System.out.println(blanks + f.getName());
            for (File fi : f.listFiles())
            {
                MutableTreeNode subNode = listAll(fi, level + 1);
                if(subNode != null) {
                    node.add(subNode);
                }
            }
        }
        else
        {
            System.out.println(blanks + f.getName());
        }
        return node;
    }
}
