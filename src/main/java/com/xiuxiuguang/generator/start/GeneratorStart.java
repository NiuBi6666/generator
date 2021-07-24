package com.xiuxiuguang.generator.start;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*******************************************************************************
 *   @Author lixiuguang
 * - File Name: GeneratorStart
 * - Description:
 * - History:
 * Date         Author          Modification
 * 2021/7/22     lixiuguang    Create the current class
 *******************************************************************************/
public class GeneratorStart {

    private static final String configfile = "-configfile";
    private static final String overwrite = "-overwrite";

    public static void generator(String configXmlPath) {
        String[] args = new String[]{configfile, configXmlPath, overwrite};
        ShellRunner.main(args);
    }

    public static void main(String[] args) {
        generator("C:\\LiXiuGuang\\Workspace\\IntelliJIDEA_Workspace\\Git_NiuBi6666_Workspace\\generator\\src\\main\\resources\\config\\manager.xml");
    }

}
