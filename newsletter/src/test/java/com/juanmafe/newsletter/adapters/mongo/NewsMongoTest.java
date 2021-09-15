package com.juanmafe.newsletter.adapters.mongo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.juanmafe.newsletter.adapters.mongo.dao.NewsRepository;
import com.juanmafe.newsletter.objectmother.ObjectMotherNewsEntity;

/**
 * Newsletter Mongo Test.
 * @author juanmafe.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class NewsMongoTest {

	/** {@link NewsMongo} newsMongo */
	@Autowired
	private NewsMongo newsMongo;

	/** {@link NewsRepository} newsRepository */
	@MockBean
	private NewsRepository newsRepository;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsRepository.findAll()).thenReturn(ObjectMotherNewsEntity.getNewsEntityList());
	}

	/**
	 * Checks the get all news service.
	 */
	@Test
	void getAllNewsletterSubscriptionsTest() {
		assertThat(newsMongo.getAllNews()).isNotEmpty().anyMatch(n -> n.getTitle().equals("Linux"));
	}

}