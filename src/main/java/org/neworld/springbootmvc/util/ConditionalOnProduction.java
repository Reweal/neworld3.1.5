package org.neworld.springbootmvc.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Properties;

@Log4j2
public class ConditionalOnProduction implements Condition {

    private static volatile Integer counter = 0;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //Если хотим получать ответ с консоли - то Properties закомментировать
        Properties properties = new Properties();
        properties.setProperty("application.on-production", "true");
        if (counter == 0) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Is this application on 'prod'?");
//            System.out.println("write 'y' if yes, and 'n' if no");
//            String strFromConsole = scanner.nextLine();
            String isProduction = properties.getProperty("application.on-production");
            if (isProduction.equals("true")) {
                ++counter;
//                System.out.println("Ворон услышал, пошёл создавать бин 'ravenListener'");
                log.info("Ворон услышал, пошёл создавать бин 'ravenListener'");
                return true;
            } else if (isProduction.equals("false")) {
                --counter;
//                System.out.println("Ворон ничего не услышал, бин 'ravenListener' не создан");
                log.info("Ворон ничего не услышал, бин 'ravenListener' не создан");
                return false;
            }
            log.error("unexpected answer : \"" + isProduction + "\" - try again with correct answer.");
            throw new RuntimeException("unexpected answer");
        } else if (counter < 0) {
            return false;
        }
        return true;
    }
//    non-cache method
//    @Override
//    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Is this application on 'prod'?");
//        System.out.println("write 'y' if yes, and 'n' if no");
//        String strFromConsole = scanner.nextLine();
//        if (strFromConsole.equals("y")) {
//            System.out.println("Ворон услышал, пошёл создавать бин 'ravenListener'");
//            return true;
//        } else if (strFromConsole.equals("n")) {
//            System.out.println("Ворон ничего не услышал, бин 'ravenListener' не создан");
//            return false;
//        }
//        System.err.println("unexpected answer");
//        throw new RuntimeException("unexpected answer");
//    }
}
