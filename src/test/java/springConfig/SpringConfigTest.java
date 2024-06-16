package springConfig;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.repositories.CarRepository;
import project.repositories.PeopleRepository;
import project.springConfig.SpringConfig;

import static junit.framework.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
 @ContextConfiguration(classes = SpringConfig.class)
 public class SpringConfigTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void testContextLoads() {
            assertNotNull(context);
        }

        @Test
        public void testBeanPresence() {
            assertNotNull(context.getBean(CarRepository.class));
            assertNotNull(context.getBean(PeopleRepository.class));
        }
}
