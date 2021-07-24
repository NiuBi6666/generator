package com.xiuxiuguang.generator.start;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*******************************************************************************
 *   @Author lixiuguang
 * - File Name: StartUp
 * - Description:
 * - History:
 * Date         Author          Modification
 * 2021/7/22     lixiuguang    Create the current class
 *******************************************************************************/
@Component
public class StartUp {

    @Value("${mybatis-generator-xml-path}")
    private String generatorXmlPath;

    public static void main(String[] args) {
        String path = "C:/LiXiuGuang/Workspace/IntelliJIDEA_Workspace/Localhost_Workspace/generator/src/main/resources/generator/manager.xml";
        args = new String[]{"-configfile", path, "-overwrite"};
        ShellRunner.main(args);
    }

}
