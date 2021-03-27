package com.buaa1921rlb.contact;

import com.buaa1921rlb.contact.util.HashUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ContactApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(HashUtil.sha256("13598634768" + UUID.randomUUID()));
    }

}
