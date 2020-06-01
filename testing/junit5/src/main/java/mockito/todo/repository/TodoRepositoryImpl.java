package mockito.todo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TodoRepositoryImpl implements TodoRepository {

	@Override
	public List<String> retrieveTodos() {
		return Arrays.asList("Todo1", "Todo2", "Todo3", "Todo4", "Todo5");
	}

	@Override
	public List<String> retrieveTodos(String todo) {
		return retrieveTodos().stream().filter(todo1 -> todo.equals(todo)).collect(Collectors.toList());
	}

}
