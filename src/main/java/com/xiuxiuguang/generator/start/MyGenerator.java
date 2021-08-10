package com.xiuxiuguang.generator.start;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*******************************************************************************
 *   @Author lixiuguang
 * - File Name: MyGenerator
 * - Description:
 * - History:
 * Date         Author          Modification
 * 2021/7/22     lixiuguang    Create the current class
 *******************************************************************************/
public class MyGenerator {

    private static final String configfile = "-configfile";
    private static final String overwrite = "-overwrite";

    public void run(String configXmlPath) {
        System.out.println("配置文件==" + configXmlPath);
        String[] args = new String[]{configfile, configXmlPath, overwrite};
        System.out.println("Mybatis逆向工程生成代码开始······");
        ShellRunner.main(args);
        System.out.println("Mybatis逆向工程生成代码结束。");
    }

}
