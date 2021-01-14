# MAuth-CAN: Masquerade-Attack-Proof Authentication for In-Vehicle Networks

## Abstract

최근 현대 차량에 대한 수많은 해킹 시도는 공격자가 취약한 telematics services를 사용하여 원격으로 차량을 제어할 수 있다는 것을 보여주었다. 이러한 시도들에서 ECU(전자 제어 장치)를 가장한 위장 공격은 일반적으로 차량을 제어하기 위해 수행된다. 지난 10년 동안 위장 공격으로부터 차량을 보호하기 위해 CAN(Controller Area Network)에 대한 몇 가지 메시지 인증 프로토콜이 제안되었지만, 일부 메시지 인증 프로토콜은 손상된 ECU의 위장 공격으로부터 차량을 완벽하게 보호하지 못한다. 위장공격에 안전한 다른 프로토콜들은
위장 공격에 대해 최대 100%의 CAN 네트워크 용량을 채우거나 CAN 통신에 사용되는 전용 하드웨어인 CAN 컨트롤러의 하드웨어 수정이 필요하다. 본 논문에서는 새로운 인증 프로토콜인 MAuth-CAN을 제안한다.
위장 공격을 막는 MAuth-CAN은 네트워크 용량의 최대 100%를 차지하지 않으며 CAN 컨트롤러의 하드웨어 수정도 필요하지 않는다. 또한, ECU를 bus-off 공격으로부터 보호하고 버스 오프 공격을 처리하기 위해 MAuth-CAN에 이 기술을 적용하는 기술을 제안한다.


## Intrtoduction

챠랑 네트워크 기술 : CAN, LIN(Local Interconnect Network), FlexRay

LIN & FlexRay : 가벼운 기능들을 위해 개발됨. (e.g.유리닦개를 컨트롤하는 것, 고속 네트워크 등..)

CAN : 엔진 컨드롤이나, 전송 제어, 조종 장치, suspension control, diagnostics 를 위해 개발됨. 

이와 같이 CAN은 차내 네트워크의 실제 표준으로서 **bus topology**를 사용함.



