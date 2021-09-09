package com.juanmafe.newsletter.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.juanmafe.newsletter.domain.persistence.NewsPersistence;
import com.juanmafe.newsletter.objectmother.ObjectMotherNews;

/**
 * News Service Test.
 * @author juanmafe
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class NewsServiceTest {

	/** {@link NewsService} newsService */
	@Autowired
	private NewsService newsService;

	/** {@link NewsPersistence} newsPersistence */
	@MockBean
	private NewsPersistence newsPersistence;

	/**
	 * Load mock beans behavior.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsPersistence.getAllNews()).thenReturn(ObjectMotherNews.getNewsStream());
	}

	/**
	 * Checks the get all news service.
	 */
	@Test
	void getAllNewsTest() {
		assertThat(newsService.getAllNews()).isNotEmpty().anyMatch(n -> n.getTitle().equals("Linux"));
	}

}