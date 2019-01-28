import java.util.List;

/**
 * 
 * @author ezliagu
 * @description 知识面可能是包含多个知识点，知识面也可能包含多个知识面
 */
public class KnowledgeScope
{
    private String name;
    private String path;
    private boolean isKnowledgePoint;
    private List<QuestionAnswerPair> questions;
    
    public KnowledgeScope(String name, String path, boolean isKnowledgePoint) {
        this.name = name;
        this.path = path;
        this.isKnowledgePoint = isKnowledgePoint;
    }
    static class QuestionAnswerPair {
        String question;
        String answer;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public List<QuestionAnswerPair> getQuestions()
    {
        return questions;
    }

    public void setQuestions(List<QuestionAnswerPair> questions)
    {
        this.questions = questions;
    }

    public boolean isKnowledgePoint()
    {
        return isKnowledgePoint;
    }

    public void setKnowledgePoint(boolean isKnowledgePoint)
    {
        this.isKnowledgePoint = isKnowledgePoint;
    }
    
    public String toString() {
        return name;
    }
}
