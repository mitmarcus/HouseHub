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
            RemoteModel server = new RmiServer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
