package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
//    ⭐ 역할이 잘 보이도록 제작하는게 중요!


//    생성자 주입 방식으로 DIP 법칙 지키기!
//    AppConfig는 객체를 생성하고 연결하는 역할만 진행한다!
        // 이 과정을 통해, ~~Impl은 어떤 실제 구현체가 주입되는지 모른다!

    public MemberService memberService(){
        return new MemberServiceImpl(getMemoryMemberRepository());
//        MemberServiceImpl 입장에서는 의존관계(의존성)주입이 된다고 하면 된다
    }

    private static MemoryMemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(getMemoryMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
