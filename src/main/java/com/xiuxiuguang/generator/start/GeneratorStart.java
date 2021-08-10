package com.xiuxiuguang.generator.start;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*******************************************************************************
 *   @Author lixiuguang
 * - File Name: GeneratorStart
 * - Description:
 * - History:
 * Date         Author          Modification
 * 2021/7/22     lixiuguang    Create the current class
 *******************************************************************************/
@Configuration
public class GeneratorStart {

    @Value("${generatorConfigUrl}")
    private String generatorConfigUrl;

    private static final String configfile = "-configfile";
    private static final String overwrite = "-overwrite";

    public void generator(String configXmlPath) {
        String[] args = new String[]{configfile, configXmlPath, overwrite};
        ShellRunner.main(args);
    }

    @Bean
    public GeneratorStart init() {
        GeneratorStart generatorStart = new GeneratorStart();
        generatorStart.generator(generatorConfigUrl);
        return generatorStart;
    }

}
