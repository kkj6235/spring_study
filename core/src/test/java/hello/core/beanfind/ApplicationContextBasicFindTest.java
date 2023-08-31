package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " +memberService);
        System.out.println("memberService.getClass() = "+memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceimpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
//        MemberService memberService = ac.getBean("XXX", MemberServiceimpl.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("NemberService", MemberServiceimpl.class));
//        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }


}