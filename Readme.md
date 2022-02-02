# JPA

- SQL 매퍼와 ORM

MyBatis 와 같은 SQL 매퍼를 사용하면 객체 모델링 보다는 테이블 모델링에만 집중하고
객체는 단순히 테이블에 맞추어 사용하게 된다. 그렇기 때문에 실제로 개발하는 시간보다 SQL를 다루는 시간이 더 많게 된다.

관계형 데이터베이스와 객체지향 프로그래밍의 패러다임은 서로 다르다.
JPA는 서로 다른 패더다임을 가진 위 2개의 영역을 중간에서 일치시켜 주는 기술이다.

개발자는 객체지향적으로 프로그래밍을 하고 , JPA가 이를 관계형 데이터 베이스에 맞게 SQL을 대신
생성해서 실행한다. 이로 인해 개발자는 항상 객체지향적으로 코드를 표현할 수 있고, SQL에 종속적인 개발을
하지 않아도 된다.

## Spring Data JPA
- JPA는 인터페이스로서 자바 표준 명세서이다.
- 인터페이스인 JPA를 사용하기 위해 구현체가 필요하다. 대표적으로 Hibernate, Eclipse Linke 등이 있다.
- 하지만 Spring 에서 JPA를 사용할 때 이 구현체를 직접 다루지 않는다.
- 구현체를 좀 더 쉽게 사용하기 위해 추상화 시킨 것이 Spring Data JPA 이다.

Hibernate를 쓰는 것과 Spring Data JPA를 쓰는 것 사이에는 큰 차이가 없다.
그럼에도 스프링 진영에는 Spring Data JPA 를 개발했고, 이를 권장하고 있다. 

그 이유는 다음과 같다.
- 구현체 교체의 용이성
- 저장소 교체의 용이성

`구현체 교체의 용이성` : Hibernate 외에 다른 구현체로 쉽게 교체하기 위함

Hibernate 가 언젠가 수명을 다해서 새로운 JPA 구현체가 대세로 떠오를 때, Spring Data JPA를 쓰는 중이라면
아주 쉽게 교체할 수 있다. Spring Data JPA 내부에서 구현체 매핑을 지원해주기 때문이다.
실제로 자바의 Redis 클라이언트가 Jedis 에서 Lettuce 로 대세가 넘어갈 때 
Spring Data Redis 를 쓰신 분들은 아주 쉽게 교체를 했다. 

`저장소 교체의 용이성` : 관계형 데이터베이스 외에 다른 저장소로 쉽게 교체하기 위함

서비스 초기에는 관계형 데이터베이스로 모든 기능을 처리했지만, 점점 트래픽이 많아져 관계형 데이터베이스로
도저히 감당이 안 될 때, MongoDB로 교체가 필요하다면 개발자는 Spring Data JPA에서
Spring Data MongoDB 로 의존성만 교체하면 된다.

이는 Spring Data의 하위 프로젝트들은 기본적인 CRUD 의 인터페이스가 같기 때문이다. 
즉, Spring Data JPA , Spring Data Redis , Spring Data MongoDB 등등 Spring Data 의 하위 프로젝트들은
save() , findAll , findOne() 등을 인터페이스로 갖고 있다.  그러다 보니 저장소가 교체 되어도 기본적인 기능은
변경할 것이 없다.




#h2

jdbc:h2:mem:testdb