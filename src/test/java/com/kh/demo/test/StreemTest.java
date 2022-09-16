package com.kh.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreemTest {

  @Test
  void test1(){
    String[] args = new String[]{"홍길동", "홍길순", "홍길남"};

    //일반for문
    for (int i = 0; i < args.length; i++) {
      log.info(args[i]);
    }

    log.info("-------------");

    //향상된 for문
    for (String ele:  args) {
      log.info(ele);
    }

    log.info("-------------");

    //stream & lamda
    Arrays.stream(args).forEach(ele->{
      log.info(ele);
    });

  }

  enum Gender {
    MAN,WAMAN
  }

  @Test
  void test2(){

    @Data
    @AllArgsConstructor
    class Person{
      String name;
      int age;
      Gender gender;
    }

    Person p1 = new Person("홍길동", 10, Gender.MAN);
    Person p2 = new Person("홍길서", 20, Gender.MAN);
    Person p3 = new Person("홍길남", 30, Gender.MAN);
    Person p4 = new Person("홍길녀", 40, Gender.WAMAN);

//    List<Person> persons = new ArrayList<>();
//    persons.add(p1);
//    persons.add(p2);
//    persons.add(p3);
//    persons.add(p4);
    List<Person> persons = Arrays.asList(p1, p2, p3, p4);

    persons.stream().forEach(person->{
      log.info(person.toString());
    });

    List<Person> list = persons.stream()
        .filter(person -> person.gender == Gender.MAN)
        .collect(Collectors.toList());

    log.info("요소갯수={}",list.size());

  }

}
