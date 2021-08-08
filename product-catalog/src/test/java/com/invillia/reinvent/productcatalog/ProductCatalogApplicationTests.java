package com.invillia.reinvent.productcatalog;

import com.invillia.reinvent.productcatalog.controller.ProductCatalogController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductCatalogApplicationTests {

	@Autowired
	private ProductCatalogController controller;

	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}
