package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpli;

public class TodoModifyAction implements Action {
    private String path;

    public TodoModifyAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        String no = req.getParameter("no");
        TodoService service = new TodoServiceImpli();

        // DB 작업
        TodoDto todo = service.getRow(no);
        req.setAttribute("todo", todo);

        return new ActionForward(path, false);
    }

}
