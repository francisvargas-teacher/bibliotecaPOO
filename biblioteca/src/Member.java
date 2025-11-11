import java.util.Random;

public abstract class Member {
    private int  id;
    private String name;
    private String email;
    private boolean active;

    public long penalty;

    Random random = new Random();
    //-------------------

    public abstract boolean canBorrow();
    protected abstract void addPenalty();
    protected abstract void clearPenalty();
    public abstract void loadDaysFor(MediaItem item);
}
