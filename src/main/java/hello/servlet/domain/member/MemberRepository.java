package hello.servlet.domain.member;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
public class MemberRepository { // 싱글톤 패턴 적용 - 스프링 없이 순수 서블릿 만으로 구현

    private static Map<Long, Member> store = new HashMap<>(); // static 사용
    private static long sequence = 0L; // static 사용

    private static final MemberRepository instance = new MemberRepository();
    // 얜 머지? 클내스 안에 (해당 클래스 타입의) 객체를 생성??

    public static MemberRepository getInstance() { // 생성해둔걸 불러다 씀
        return instance;
    }

    private MemberRepository(){ // 생성자를 private 접근자로 막아둠 - 객체를 단 하나만 생성해서 공유(싱글톤)
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member; //
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){ // 테스트에서 사용할 용도
        store.clear();
    }

}
