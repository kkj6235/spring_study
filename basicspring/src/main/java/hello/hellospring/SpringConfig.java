package hello.hellospring;


import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig{
//    private final DataSource dataSource;
//    private final EntityManager em;
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    public SpringConfig(DataSource dataSource,EntityManager em) {
//        this.dataSource = dataSource;
//        this.em=em;
//    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JdbcMemberRepository(dataSource);
////        return new MemoryMemberRepository();
//    }
}