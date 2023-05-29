package Model.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log {
    private static Log instance;
    private static Map<String, Log> map = new HashMap<>();
    private static Object lock = new Object();
    private ArrayList<LogLine> list;
    private String filename;

    private Log(String filename) {
        this.list = new ArrayList<>();
        this.filename = null;
    }

    /*public static Log getInstance() {
        if (instance == null) {
            synchronized (lock){
                if (instance == null){
                    instance = new Log();
                }
            }
        }
        return instance;
    }*/

    /**
     * This method is used to get an instance of the log
     * @param key the key
     * @return the instance of the log
     */
    public static Log getInstance(String key){
        Log instance = map.get(key);
        if (instance == null) {
            synchronized (map){
                instance = map.get(key);
                if (instance == null){
                    instance = new Log(key);
                    map.put(key, instance);
                }
            }
        }
        return instance;
    }

    /**
     * This method is used to add a log line
     * @param text the text
     */
    public void addLog(String text) {
        LogLine logLine = new LogLine(text);
        list.add(logLine);
        addToFile(logLine);
        System.out.println("Log Line: " + logLine);
    }

    public ArrayList<LogLine> getAll() {
        return list;
    }

    public String toString() {
        return "List: " + "{ " + list + "}";
    }

    private void addToFile(LogLine log) {
        if (log == null) {
            return;
        }
        BufferedWriter out = null;
        try {
            String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
            out = new BufferedWriter(new FileWriter(filename, true));
            out.write(log + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
