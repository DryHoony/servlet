package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    // 이 컨트롤러는 서블릿 기술을 전혀 사용하지 않음. - 구현이 매우 단순, 테스트 하기 쉬움
    // HttpServletRequest 가 제공하는 파라미터는 프론트 컨트롤러가 paramMap 에 담아 호출
    // 응답 결과로 '뷰 이름'과 뷰에 전달할 Model 데이터를 포함하는 ModelView  객체를 반환

    ModelView process(Map<String, String> paramMap);
    // Model 에 담을 데이터가 username, age 이므로 둘다 String 타입
    // <key,value> 모두 String 타입

}
