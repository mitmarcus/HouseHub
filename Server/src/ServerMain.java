import Networking.RemoteModel;
import Networking.RmiServer;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
    public static void main(String[] args)
    {
        try {
//            Database database = new Database();
//            database.connect();
//            Model model = new ModelManager(database);
            RemoteModel server = new RmiServer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
