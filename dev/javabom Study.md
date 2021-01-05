클래스 다이어그램
- 코드 작성하기 전에 그리고, 리팩토링 전, 후에 그리기?!

A가 B에 의존 == A수정 -> B 수정

- 강한 의존(멤버변수로 갖고 있는 경우)
class A{
	B b
}

-약한 의존 (메서드의 멤버변수로 갖고 있거나, return 할 때 일시적으로 생성하느 ㄴ경우)
class A{
	void add(B b)

	return new B b
}

- 서로 참조하고 있는 경우를 유의해서 코딩하기

- 참조하고 있는 값이 같은데 그 클래스의 연관관계가 없이 코딩돼있으면 잘 분석해서
연관관계를 부여. (내부 클래스를 생성하는 방식으로?)

- 가장 독립적인 것을 찾는다.(어떤 것에도 의존하지 않는 것)
-> 이것을 가장 먼저 작성하면 설계를 해나가기 쉬움.

- 객체 간의 메세지를 메소드
그 메소드를 누가 갖고 있어야 할 지를 생각하면서 클래스 도출

- cycle이 생성되는 게 없는 지 확인
-> cycle을 없애는 법 :  A -><- B 를 A->C<-B로 바꿈?

- 일급 Collection
Collection
-List
-Map
-Set
-Table 등

class AA{
	List<Integer> number 얘가 할 수 있는 행동을 여기서 메소드로 만들고, 코드의 중복을 막음.
		sum{
}

}
밖에서는 AA.sum()으로 불러서 쓸 수 있음.

ex) List<Integer>에서 Integer를 양수로 쓰고싶을 때,
밖에서 Integer 검증을 해야 함.
하지만 일급컬렉션을 쓸 때, 생성자에 validation 로직을 넣어주면, Validator를 따로 만들필요 없어짐.
일급 컬렉션 -> 불변성을 유지, 상태와 행동을 한 곳에서 유지할 수 있게 해줌.
여기서는 private final로 만들어놓고 많이 변하지 않도록!
https://jojoldu.tistory.com/412


-void test
1. 상태를 이용
2. 검증하는 메소드를 이용
해서 테스트 할 수 있음.

InputView 클래스에서만
scanner 쓰고
OutputView 클래스 에서만 (넘겨서)
print 하도록


자동차 대수는 한 번 실행할 때, 몇 줄이 쓰이느냐를 결정
-> 그러면 그냥 carRacingGame에서 numberOfCar 변수에 (만약 3대일 시) 3을 넣고,
그만큼의 ArrayList를 할당하면 됨.

carRacingGame 에서 time : 시도할 횟수

근데 그 ArrayList에 들어갈 값은 car객체? 
-> 객체의 random값을 print 해주는 로직?

