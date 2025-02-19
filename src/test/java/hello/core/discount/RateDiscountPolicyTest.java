package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 되어야 한다.")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int disccount = discountPolicy.discount(member, 20000);

        // then
        Assertions.assertEquals(disccount, 2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 안되어야 한다.")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        // when
        int disccount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertEquals(disccount, 0);
    }
}