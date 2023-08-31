package hello.servlet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@SpringBootTest
class ServletApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void test() {
		Map<String, HandlerMapping> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
				context, HandlerMapping.class, true, false);

		matchingBeans.forEach((k, v) -> System.out.printf("handler order:%s %s=%s%n",
				((Ordered) v).getOrder(),
				k, v.getClass().getSimpleName()));

	}

	@Test
	void test2() {
		Map<String, HandlerAdapter> matchingBeans =
				BeanFactoryUtils.beansOfTypeIncludingAncestors(context, HandlerAdapter.class, true, false);

		matchingBeans.forEach((k, v) -> System.out.printf("Adapter order:%s %s=%s%n",
				((Ordered) v).getOrder(),
				k, v.getClass().getSimpleName()));

	}


}
