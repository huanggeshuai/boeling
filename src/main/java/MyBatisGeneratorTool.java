import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2017/9/22.
 */
public class MyBatisGeneratorTool {
    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        String generatorConfigPath =
                MyBatisGeneratorTool.class.getResource("generatorConfig.xml").getPath();
        File configFile = new File(generatorConfigPath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    private static Logger log = Logger.getLogger(MyBatisGeneratorTool.class);
    public static void main(String[] args) throws Exception {
        try {
            MyBatisGeneratorTool generatorSqlmap = new MyBatisGeneratorTool();
            generatorSqlmap.generator();
            log.info("hahah");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
