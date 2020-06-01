package mockito.todo.service;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos();

	public List<String> retrieveTodos(String todo);
}
