package com.juanmafe.newsletter.domain.usecases.news;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.juanmafe.newsletter.objectmother.ObjectMotherNews;
import com.juanmafe.newsletter.ports.in.NewsService;
import com.juanmafe.newsletter.ports.out.NewsPersistence;

/**
 * Get All News Test.
 * @author juanmafe.
 */
@SpringBootTest
class GetAllNewsTest {

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
	void getAllNewsServiceTest() {
		assertThat(newsService.getAll()).isNotEmpty().anyMatch(n -> n.getTitle().equals("Linux"));
	}

}