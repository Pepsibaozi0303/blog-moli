import org.junit.Test;
import top.touchface.md2x.Md2x;
import top.touchface.md2x.entity.Options;

import java.io.*;


/**  解析md文件测试
 * @Author: k1181521
 * @Date: 2020/12/21
 */
public class ParseTest {
    @Test
    public void test() {
        String name = "mysqlInstall/mysql.md";
        String markdown = this.getStr(name);
        // 创建对解析器的设置对象
        Options option=new Options();

        // 创建解析器对象
        Md2x md2x = new Md2x(option);

        // 循环解析Markdown文本
        int num=1000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            md2x.parse(markdown);
        }
        System.out.println(markdown);

    }

    private String getStr(String name) {
        File file = new File(ClassLoader.getSystemResource(name).getFile());
        if (file.isFile() && file.exists()) {
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String line;
                StringBuilder sb = new StringBuilder();
                while (null != (line = bufferedReader.readLine())) {
                    sb.append(line).append("\n");
                }

                bufferedReader.close();
                return sb.toString();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else {
            System.out.println("md2x:file not found!");
        }
        return null;
    }
}
