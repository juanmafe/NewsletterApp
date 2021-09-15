package com.juanmafe.newsletter.domain.services.news;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.juanmafe.newsletter.domain.persistence.NewsPersistence;
import com.juanmafe.newsletter.objectmother.ObjectMotherNews;

/**
 * Get All News Service Test.
 * @author juanmafe.
 */
@SpringBootTest
class GetAllNewsServiceTest {

	/** {@link GetAllNewsService} getAllNewsService */
	@Autowired
	private GetAllNewsService getAllNewsService;

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
		assertThat(getAllNewsService.execute()).isNotEmpty().anyMatch(n -> n.getTitle().equals("Linux"));
	}

}