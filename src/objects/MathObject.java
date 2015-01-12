package objects;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathObject {
    public final static int TYPE_OPERATOR = 1;
    public final static int TYPE_FUNCTION = 2;
    public final static int TYPE_PARENTHESIS_LEFT = 3;
    public final static int TYPE_PARENTHESIS_RIGHT = 4;
    public final static int TYPE_NUMBER = 5;
    public final static int TYPE_CONSTANT = 6;

    protected String mName;
    protected int mType;

    protected MathObject(String name, int type) {
        this.mName = name;
        this.mType = type;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }

    public static MathObject find(String expression, int startFrom,
            ArrayList<? extends MathObject> where) {
        String substr = expression.substring(startFrom);

        Pattern pattern = Pattern.compile("^[\\w]+");
        Matcher matcher = pattern.matcher(substr);
        if (matcher.find()) {
            String match = matcher.group();

            for (MathObject o : where) {
                if (match.equals(o.getName())) {
                    return o;
                }
            }
        }

        return null;
    }
}
