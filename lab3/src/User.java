public abstract class User {

    protected boolean _isAdmin;
    public User(boolean accessLevel){
        this._isAdmin = accessLevel;
    }

    public abstract void ShowActions();

}
