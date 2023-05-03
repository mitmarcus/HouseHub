package ModelServer.ModelServer.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Log {
    private static Log instance;
    private static Map<String, Log> map = new HashMap<>();
    private static Object lock = new Object();
    private ArrayList<ModelServer.Log.LogLine> list;
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

    public void addLog(String text) {
        ModelServer.Log.LogLine logLine = new ModelServer.Log.LogLine(text);
        list.add(logLine);
        addToFile(logLine);
        System.out.println("Log Line: " + logLine);
    }

    public ArrayList<ModelServer.Log.LogLine> getAll() {
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
