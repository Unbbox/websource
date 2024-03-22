package service;

import java.util.List;

import dao.TodoDao;
import dto.TodoDto;

public class TodoServiceImpli implements TodoService {

    TodoDao dao = new TodoDao();

    @Override
    public List<TodoDto> list() {
        return dao.getList();
    }

    @Override
    public TodoDto getRow(String no) {
        return dao.getRow(no);
    }

    @Override
    public boolean insert(TodoDto insertDto) {
        // 1이면 true, 아니면 false

        // boolean flag = dao.insert(insertDto)==1?true:false;
        // return flag;
        return dao.insert(insertDto) == 1;
    }

    @Override
    public boolean update(TodoDto updateDto) {
        // 1이면 true, 아니면 false
        return dao.update(updateDto) == 1;
    }

    @Override
    public boolean delete(String no) {
        // 1이면 true, 아니면 false
        return dao.delete(no) == 1;
    }

}
