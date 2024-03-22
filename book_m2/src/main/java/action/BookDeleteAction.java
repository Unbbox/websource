package action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookDeleteAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // 도서코드 가져오기
        String code = req.getParameter("code");

        // 서비스 백업
        BookService service = new BookServiceImpl();
        boolean result = service.delete(Integer.parseInt(code));

        if (!result) {
            path = "/view/delete.jsp";
        }

        // list.do
        return new ActionForward(path, true);
    }

}
