package mockito.todo.repository;

import java.util.List;

public interface TodoRepository {
	public List<String> retrieveTodos();

	public List<String> retrieveTodos(String todo);
}
