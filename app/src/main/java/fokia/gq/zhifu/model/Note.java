package fokia.gq.zhifu.model;

/**
 * Created by archie on 6/14/17.
 */

public class Note {
    private String content;
    private int id;

    public Note(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
