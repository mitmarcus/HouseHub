package ViewModel;

public class ViewState
{
    private String id;
    private String username;
    private boolean remove;

    public ViewState()
    {
        this.id = "";
        this.remove = false;
        this.username = "";
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void removeId()
    {
        this.id = null;
    }
    public boolean isRemove()
    {
        return  remove;
    }
    public void setRemove(boolean remove)
    {
        this.remove = remove;
    }
}
