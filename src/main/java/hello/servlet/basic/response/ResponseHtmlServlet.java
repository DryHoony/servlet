package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet { // HTTP 응답 데이터 - 단순 텍스트, HTML
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Content-Type : text/html;charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8"); // 없으면 한글 깨질수도

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println(" <div>안녕? 은 개뿔 이걸 직접 다 입력한다고?,,,</div> ");
        writer.println("</body>");
        writer.println("</html>");
        // ContentType 을 text/html 로 설정했으므로 웹 브라우저가 랜더링 해준다.
        // 자바 코드이므로 동적으로 만들 수 있다 (if문을 넣는다던가)


    }
}
