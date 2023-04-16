package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id; // id 는 Member 를 회원 저장소에 저장하면 회원 저장소가 할당한다
    private String username; // 이름
    private int age; // 나이

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
