package hello.servlet.web.springmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("springmvc/v3/members")
public class SpringMemberControllerV3 { // 실무에서 일반적으로 사용하는 ver, 완전 깔끔!, 유연

    private MemberRepository memberRepository = MemberRepository.getInstance();


//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) // 원래는 GET, POST 둘다 응답했으나, GET 에서만 동작하도록 method 잡아줌
    @GetMapping("/new-form") // @RequestMapping 에서 method 포함하는 에노테이션
    public String newForm() {
        return "new-form";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST) // 데이터를 변경하기에 GET 으로도 동작하게 되면 여러 문제가 생길수 있다,,곤란
    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age,
                       Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

//    @RequestMapping(method = RequestMethod.GET) // 단순 조회 - GET
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

}
