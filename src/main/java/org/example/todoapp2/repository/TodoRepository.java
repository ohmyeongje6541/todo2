package org.example.todoapp2.repository;

import org.example.todoapp2.dto.TodoDto;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TodoRepository {
    // storage 라는 Map에(키, 값)을 담은 객체 생성
    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>();
    private Long nextId =  1L; // 새 Todo를 만들 때 사용할 다음 ID 번호.

    public TodoDto save(TodoDto todo) {
        todo.setId(nextId++); // 저장 될 떄 마다 새로운 번호 1, 2, 3
        storage.put(todo.getId(), todo); // 스토리지 객체에 todo id, todo를 넣음
        return todo; // 다시 todo로 돌아감
    }
}
