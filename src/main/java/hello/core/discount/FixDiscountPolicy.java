package hello.core.discount;

import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        return 1000;
    }
}
