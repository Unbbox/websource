package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLeaveAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // 탈퇴 페이지의 데이터 가져오기
        MemberDto delDto = new MemberDto();
        delDto.setUserid(req.getParameter("userid"));
        delDto.setPassword(req.getParameter("password"));

        // 서비스 백업
        BookService service = new BookServiceImpl();

        if (service.leave(delDto)) {
            // 탈퇴 시 기존 세션 제거
            HttpSession session = req.getSession();
            session.invalidate();
        } else {
            path = "/view/leave.jsp";
        }

        // list.do
        return new ActionForward(path, true);
    }

}
