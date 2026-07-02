public class TextDocument {
    private int id;
    private String title;
    private String content;

    // constructor
    public TextDocument(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    //setters
    public void setId(int id){
        this.id = id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    //toString method
    public String toString(){
        return id + "->" + title + "|" + content;
    }
}
