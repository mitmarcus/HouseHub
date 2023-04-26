package Log;

public class LogLine {
    private DateTime dateTime;
    private String text;

    public LogLine(String text){
        this.text = text;
        this.dateTime = new DateTime();
    }
    public String getText(){
        return text;
    }
    public DateTime getDateTime(){
        return dateTime;
    }
    public String toString(){
        return "Text: " + text + "\n Time: " + dateTime.toString();
    }
}
