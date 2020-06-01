package mockito.todo.service;

import java.util.List;

import mockito.todo.repository.TodoRepository;

public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public List<String> retrieveTodos() {
		return todoRepository.retrieveTodos();
	}

	@Override
	public List<String> retrieveTodos(String todo) {
		return todoRepository.retrieveTodos(todo);
	}

}
