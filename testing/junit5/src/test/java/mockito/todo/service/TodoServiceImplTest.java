package mockito.todo.service;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockito.todo.repository.TodoRepository;

@DisplayName("Test TodoService")
class TodoServiceImplTest {
	private TodoRepository todoRepository;
	private TodoServiceImpl todoService;

	@BeforeEach
	void setUp() throws Exception {
		todoRepository = mock(TodoRepository.class);
		todoService = new TodoServiceImpl(todoRepository);
	}

	@Test
	@DisplayName("Method RetrieveTodos should returns list")
	void testRetrieveTodos_returnListOfFruits() {
		given(todoRepository.retrieveTodos()).willReturn(Arrays.asList("Apple", "Banana"))
				.willReturn(Arrays.asList("Apple", "Banana", "Pineapple"));
		assertIterableEquals(Arrays.asList("Apple", "Banana"), todoService.retrieveTodos());
		assertIterableEquals(Arrays.asList("Apple", "Banana", "Pineapple"), todoService.retrieveTodos());

	}
}
