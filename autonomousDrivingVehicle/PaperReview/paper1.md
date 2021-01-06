# 논문 : Enhanced Android App-Repackaging Attack on In-Vehicle Network

## Abstract

connected car가 IoT 기술과 연결되었을 때의 취약점을 분석하고 실제 자동차와 상용앱을 사용한 실험을 통해 cyberattack의 가능성을 증명함.

## 1. Introduction

운전자와 탑승자의 안전과 편안함을 높이기 위해 다양한 전자제어장치(ECU)가 최신 차량에 탑재되고 있으며, 이러한 자동차-ICT(정보통신기술) 융합은 차세대 차량 개발의 새로운 패러다임이 되었음.
자동차 전자 부분이 증가함에 따라 차량 및 외부 데이터 서비스 간의 통신도 증가하고 있음.
대표적인 IoT 활용 사례 중 하나인 커넥티드카는 5세대(5G) 기술 개발로 빠르게 성장하고 있음.
기존 V2X 기술은 LTE나 5G를 이용해 C-V2X로 진화하고 있으며, 차량은 IoT 기술을 통해 외부 기기와 연결됨. 수십 년 동안 전형적인 기계였던 차량은 대형 IT 시스템으로 발전하고 있음. 그 결과, IT 전문가들은 이제 차량 개발에 참여할 수 있게 되었고 일반 대중들도 차량을 보다 쉽게 이해할 수 있게 됨.

그러나 자동차 전자제품의 개발로 차량은 해커들의 새로운 대상이 되었음. Lee 등은 ELM327 기반 CAN-to-Bluetooth 장치와 차량용 앱의 취약성을 분석한 사이버 공격 실험 결과를 발표함. 게다가, Samy Kamkar의 GM OnStar 해킹과 미하일 쿠진과 빅터 체비셰프의 차내 스마트폰의 취약성에 대한 연구에서 보듯이, 취약한 스마트폰 앱들이 차량의 새로운 공격 표면으로 떠오르고 있음.

본 연구에서는 [9]에서 수동으로 수행한 앱 분석 작업을 자동화하고 구글 플레이스토어에 등록된 213개 앱의 취약점을 분석함. 이 분석 결과를 바탕으로, 차량용 상용 앱 중 가장 인기 있는 앱 10가지를 repackaging하여 실제 차량을 통제하기 위한 공격을 수행한다. 마지막으로, 공격으로부터 보호하고 ELM327 기기의 통신 서비스 보안을 위한 화이트리스트에 기반한 접근 제어 장치를 개발하기 위한 보안 기술을 제안한다. 이는 자동차 제조업체가 CAN ID를 설정할 수 있는 경우, 모든 차량에 적용할 수 있는 범용 접근 제어 장치이다.


## 2. Background

#### 2.1 CAN(Controller Area Network)
ECU들간의 효율적인 통신을 지원하기 위해 BOSCH는 1980년대 초에 CAN을 개발했음.
CAN은 버스 네트워크 토폴로지를 지원하는 발신자 ID 기반 브로드캐스트 통신 기술이다. CAN은 point-to-point 통신의 단점을 해결함으로써 차량 내 통신 라인의 복잡성과 길이를 크게 줄였다. CAN을 사용하는 ECU 간의 데이터 전송 프로세스에서 전송ECU는 데이터를 전송하기 전에 CAN 데이터 프레임에 고유한 ID를 포함한다. 수신ECU는 브로드캐스트 데이터 프레임에 포함된 송신 ECU의 ID를 확인한 후 선택적으로 데이터를 수신할 수 있다. CAN 버스 시스템은 데이터 프레임의 ID 길이에 따라 다음과 같은 두 가지 유형으로 분류된다.

1) Standard CAN 2.0A(11-bit ID)
2) Extended CAN 2.0B(29-bit ID)

데이터 프레임은 SOF(start of frame), Arbitraion ID(Arbitraion), Control, Data, CRC(cyclic redundancy check), ACK(acknowledge) 및 EOF(end of frame) 필드로 구성된다. Standard CAN 2.0A 형식은 Arbitraion 비트로 11비트 ID를 사용하고, Extended CAN 2.0B 형식은 Arbitraion 비트로 29비트 ID를 사용한다.
CAN은 원래 closed network 상에서 design되었기 때문에 protection feature들(기밀성, 인증 및 접근제어)을 제공하지 않았음.
그러나 최근에는 커넥티드카 서비스가 상용화되면서 FOTA(Firmware Over-The-Air) 사용이 확산되고 차량 내 네트워크, 외부 네트워크가 상호 연결되고 있다. 그 결과, CAN은 일반 IT 환경에서와 같은 사이버 공격에 노출됨.

#### 2.2 Connected Car
Connected Car라는 말은 차량이 항상 외부와 연결되어 있음을 의미한다.

Connected Car는 다음과 같은 구성요소로 이루어진다.
- (i) ECU가 설치된 차량과 차량 내 네트워크가 구성된 차량
- (ii) 차량에 대한 다양한 서비스를 제공하기 위한 포털
- (iii) 차량을 포털과 연결하기 위한 통신 링크

이러한 환경에서 차량에는 여러개의 ECU가 설치되어 있으며, 이 ECU는 CAN 버스 시스템과 같은 차량 내 네트워크에 연결되어있음. 통신 링크는 텔레매틱스 ECU 또는 ELM327과 같은 무선 통신 장치를 사용하여 구성되고, 포털은 웹 기반 서비스와 스마트폰 애플리케이션 기반 서비스로 구분된다.

실험을 통해, 이 연구는 연결 차량 환경이 차내 네트워크의 취약성을 해결하지 않고 구성될 경우 차량이 심각한 위협에 노출된다는 것을 입증한다. 그런 다음 이 문제를 해결하기 위한 보안 메커니즘을 제안한다. 여기서 제안하는 공격 모델은 그림 1에 나와 있는 Connected Car 환경에 기초하여 설계되었다.

<img width="562" alt="image" src="https://user-images.githubusercontent.com/44834680/103730573-824d1080-5026-11eb-97c0-4062f513084e.png">

<img width="518" alt="image" src="https://user-images.githubusercontent.com/44834680/103731065-a1986d80-5027-11eb-8fda-c6b6711968b9.png">

#### 2.3 OBD Protocol
OBD(on-board diagnostics)는 자동차 상태를 진단하기 위해 사용되는 도구이다.
OBD는 원래 차량 배기 가스를 제어하기 위해 제작되었지만, 자동차 전자장치 개발이 가속화되면서 고장 목록을 점검하기 위해 개발됨. 이후에는 ISO 15765-4으로 제정되어 표준화된 단말기를 통해 자동차 진단장치로 차량 상태를 확인할 수 이게 되었음. 미국에서는 판매되는 모든 차량에 OBD-2 설치를 의무화 함.
OBD-II를 사용한 차량 상태 점검은 SAE J1989 표준에 정의된 점검 프로세스에 사용되는 요청/응답 방법과 OBD PID(OBD Parameter ID)를 통해 작동한다. 이 표준에 정의된 통신을 위한 CAN ID 및 데이터 프레임의 구조는 그림 2에 나와 있고 PID 코드와 파라미터는 표 1에 정의되어 있다.
OBD-II를 통해 얻은 차량의 진단 정보는 자동차 수리점에서 사용하는 전용 진단 기기뿐만 아니라 애프터마켓 공급업체에서 구입한 `스마트폰 애플리케이션` 및 `ELM327` 모듈을 통해 쉽게 얻을 수 있다. 따라서 악성사용자는 차량의 진단정보를 조작하여 차량을 제어할 수 있고 이에 따른 진단장치 및 관련 프로토콜에 대한 보안 정책이 필요하다.

<img width="555" alt="image" src="https://user-images.githubusercontent.com/44834680/103730614-98f36780-5026-11eb-8170-8d7c7bb1b4d0.png">

#### 2.4 ELM327
ELM327은 차량 상태를 진단하는 데 사용되는 차량 수리용 microcontroller이다.
블루투스 같은 무선 통신 모듈이 ELM327에 추가되면 운전자는 스마트폰을 ELM327에 연결하여 차량 상태를 실시간으로 확인할 수 있다. 스마트폰 및 ELM327을 사용하여 차량 상태를 확인하는 프로세스는 그림 3에 나와 있다.
<img width="450" alt="image" src="https://user-images.githubusercontent.com/44834680/103731547-bc1f1680-5028-11eb-96b3-3c9e73ebf757.png">


#### 2.5 Cyber Kill Chain
Lockheed Martin은 일반적으로 모든 사이버 공격에 적용할 수 있는 사이버 공격 프로세스를 제안했다.
그들은 사이버 공격 프로세스를 분석해 공격 단계별로 위협을 파악하고 공격 목적과 의도, 활동을 무력화해 조직의 복원력을 높이는 Cyber Kill Chain 방식도 제시했다. 사이버 킬 체인은 reconnaissance, weaponization, deliv- ery, exploitation, installation, command and control, and actions on objectives의 7단계로 구성된다. 각 단계의 특성은 표 2에 설명되어 있다.

<img width="387" alt="image" src="https://user-images.githubusercontent.com/44834680/103731696-22a43480-5029-11eb-9e1c-37e42a8faed2.png">

