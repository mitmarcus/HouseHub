package ViewModel;

public class ViewState
{
    private String id;
    private boolean remove;

    public ViewState()
    {
        this.id = "";
        this.remove = false;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
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
