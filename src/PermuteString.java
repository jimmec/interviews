import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 02/09/14
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermuteString {
    public static List<String> permute(String str) {
        // Base case
        if (str.length() < 2) {
            return Arrays.asList(str);
        }

        String firstChar = str.substring(0,1);
        List<String> perms = permute(str.substring(1));
        List<String> fullPerms = new ArrayList<String>();
        for (String perm: perms) {
            // Insert the remaining charater at each possible position
            for (int i = 0; i < str.length(); i++) {
                StringBuilder fullPerm = new StringBuilder(perm);
                fullPerm.insert(i,firstChar);
                fullPerms.add(fullPerm.toString());
            }
        }
        return fullPerms;
    }
}
