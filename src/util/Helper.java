package util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;

/**
 * @author Twikura
 * @create 2018/12/2 12:13
 */
public class Helper {
    private static String webroot ;

    public static String getWebroot () {
        return webroot;
    }

    // 获取文件目录
    public Helper (String webroot) {
        Helper.webroot=webroot+"Files";
    }

    public static File[] getFiles () {
        File folder = new File(webroot);
        return folder.listFiles();
    }

    public static String getRelativePath (File file) {
        String absolutePath = file.getAbsolutePath();
        String s = absolutePath.substring(webroot.length()).replace('\\', '/');
        return s;
    }


    public static String getPathIfDir (File f) {

        String temp = (getRelativePath(f));
        try {
            temp = URLEncoder.encode(temp, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public static String[] getPathes (String s) {
        File f = new File(webroot + File.separator + s);
        String[] pathes = null;
        if (f.exists()) {
            File[] fs = f.listFiles();
            pathes = new String[fs.length];
            for (int i = 0; i < fs.length; i++) {

                if (fs[i].isDirectory()) {

                    pathes[i] = "index.jsp?path=" + getPathIfDir(fs[i]);

                } else {
                    try {
                        pathes[i] = "Files" + getRelativePath(fs[i]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("not exist");

            pathes = new String[]{"/"};
        }
        return pathes;
    }

    public static String getFileName (String s) {
        try {

            s = URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] subs = s.split("/");
        if (subs.length > 0)
            return subs[subs.length - 1];
        else
            return "/";
    }

    public static void main (String[] args) {
        String[] ss = Helper.getPathes("/");

        for (String s : ss) {
            System.out.println((s));
            System.out.println(getFileName(s));
        }
    }
}
