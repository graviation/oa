package priv.oa.utils;

public class StringUtils {

    /**
     * 判断字符串是不是为空
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        return (cs == null) || (cs.length() == 0);
    }

    /**
     * 不为空
     * @param cs
     * @return
     */
    public static boolean notEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

}
