package action;

import javax.servlet.http.HttpServletRequest;

import service.TodoService;
import service.TodoServiceImpli;

public class TodoDeleteAction implements Action {
    private String path;

    public TodoDeleteAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        String no = req.getParameter("no");
        TodoService service = new TodoServiceImpli();
        boolean result = service.delete(no);

        return new ActionForward(no, true);
    }

}
