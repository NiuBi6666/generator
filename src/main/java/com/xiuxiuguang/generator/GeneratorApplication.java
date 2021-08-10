package com.xiuxiuguang.generator;

import com.xiuxiuguang.generator.constant.MyGeneratorConstant;
import com.xiuxiuguang.generator.start.MyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
        generator(args);
    }

    private static void generator(String[] args) {
        if (null == args || "".equals(args) || args.length == 0) {
            return;
        }
        for (String arg : args) {
            if (arg.contains(MyGeneratorConstant.paramName)) {
                if (arg.contains(MyGeneratorConstant.splitStr)) {
                    String[] split = arg.split(MyGeneratorConstant.splitStr);
                    MyGenerator generator = new MyGenerator();
                    generator.run(split[1]);
                }
            }
        }
    }

}
