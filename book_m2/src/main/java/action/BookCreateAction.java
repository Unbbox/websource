package action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

import dto.BookDto;

@AllArgsConstructor
public class BookCreateAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // 도서추가 화면에서 넘어오는 데이터 가져오기
        String code = req.getParameter("code");
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        BookDto insertDto = new BookDto();
        insertDto.setCode(Integer.parseInt(code));
        insertDto.setTitle(title);
        insertDto.setWriter(writer);
        insertDto.setPrice(Integer.parseInt(price));
        insertDto.setDescription(description);

        // 서비스 호출 create
        BookService service = new BookServiceImpl();
        boolean result = service.create(insertDto);

        return new ActionForward(path, true);
    }

}
