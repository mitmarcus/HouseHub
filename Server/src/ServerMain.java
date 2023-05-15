import Model.ModelServer;
import Networking.RemoteModel;
import Networking.RmiServer;
import Model.*;

public class ServerMain
{
    public static void main(String[] args) throws Exception
    {
        ModelServer model = new ModelManagerServer();
        RemoteModel server = new RmiServer(model);
    }
}
