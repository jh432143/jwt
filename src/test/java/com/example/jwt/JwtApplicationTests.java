package com.example.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void currentTimeToDate () {
        long nano1 = Long.parseLong("1634252856332");
        System.out.println("1-> "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(nano1));

        long nano2 = Long.parseLong("1634253096333");
        System.out.println("2-> "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(nano2));

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDateTime :::: "+localDateTime);


        int ttlMinutes = 1;
        long expiration = System.currentTimeMillis() + (60000L * ttlMinutes);

        System.out.println("1 ::: "+expiration);

        ttlMinutes = 5;
        expiration = System.currentTimeMillis() + (60000L * ttlMinutes);

        System.out.println("5 ::: "+expiration);


//        localDateTime :::: 2021-10-15T08:06:36.332
//        1 ::: 1634252856332 - 2021-10-15 08:07:36.332
//        5 ::: 1634253096333 - 2021-10-15 08:11:36.333
    }

    @Test
    void listTest () {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        System.out.println("-> "+list.size());

        for (int i=0; i<list.size(); i++) {
            if (i == 1) {
                list.remove(i);
            }
        }

        System.out.println("-> "+list.size());

        System.out.println(":::::::::::: "+LocalDate.parse("2021-10-21").withDayOfMonth(1));

        long diff = ChronoUnit.MONTHS.between(LocalDate.parse("2021-10-21").withDayOfMonth(1), LocalDate.parse("2021-10-21").withDayOfMonth(1));

        System.out.println("diff :: "+diff);
        String[] a = new String[(int) (diff + 1)];
        for (String data : a) {
            System.out.println("data :: "+data);
        }
    }

}