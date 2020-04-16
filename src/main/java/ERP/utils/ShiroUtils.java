package ERP.utils;

import ERP.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroUtils {

    public static User getUser() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        return user;
    }


    public static String enPas(String pas, String salt) {
        String hashAlgorithmName = "MD5";   //使用哪种加密算法
        int hashIterations = 1024;          //加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        Object obj = new SimpleHash(hashAlgorithmName, pas, credentialsSalt, hashIterations);
        return obj.toString();

    }

    public static void main(String[] args) {
        System.out.println(enPas("123", "3e4fa7b9796a438a82c3d124b2e5b4c2"));
    }
}
