package tommy_kw.esoutline.model;

/**
 * Created by tomita on 15/06/26.
 */
public abstract class ListLayoutModel {
    private static final String TAG = ListLayoutModel.class.getSimpleName();

    public static final int LAYOUT_TYPE_ERROR = -1;
    public static final int LAYOUT_TYPE_1     = 1;
    public static final int LAYOUT_TYPE_2     = 2;

    private int type;

    public ListLayoutModel() {
        type = LAYOUT_TYPE_1;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
