package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    /*
    * @BeforeEach:
    *   각 테스트 메서드 실행 전에 실행됩니다. 따라서 여러 테스트 메서드가 있으면 매번 새로운 상태에서 시작할 수 있도록 준비해줍니다.
    * 상단 실행:
    *   한 번만 실행됩니다. 일반적으로 클래스가 로드되고 테스트 실행 전에 수행되므로, 모든 테스트 메서드가 공유 상태를 사용하게 됩니다.
    * */
    @BeforeEach //테스트 실행 전 반드시 실행되는 것
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberZ", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(),1000);
    }
}
