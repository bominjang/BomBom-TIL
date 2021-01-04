# 자율주행자동차

### 1. BMW 자동차 코딩
- 차량 기능의 동작 여부 / 조건 변경
- 차량 옵션을 추가/제거하는 VO(Vehicle Order)
   
   VIN 넘버를 [http://bmwvin.com](http://bmwvin.com)에 조회하면 차량에 추가된 장비들을 조회 가능. VO 코딩이란 이렇게 차량의 옵션 ㄱ밧을 변경하여 해당 기능이 동작하도록 만드는 역할을 함.
  ex)  ‘DECODING VARIABLE LIGHT DISTRIBUTION’라는 항목이 설정되어있을 때, VO코딩으로 이것을 활성화시킬 수 있음.
- 펌웨어 업데이트


### 2. 차종별 코딩 프로그램과 케이블 비교

![image](https://user-images.githubusercontent.com/44834680/103501102-919a5580-4e90-11eb-8303-0b158bfee57a.png)


5시리즈는 G 시리즈에 해당
[https://www.turnermotorsport.com/t-BMW-Chassis-Codes](https://www.turnermotorsport.com/t-BMW-Chassis-Codes) 여기서 조회 가능.

### 3. 케이블, 프로그램


### 3-1. ENET 케이블.
![image](https://user-images.githubusercontent.com/44834680/103501506-acb99500-4e91-11eb-832b-ff3dcec47c6a.png)

위 케이블의 한 쪽은 OBD2(On-board diagnostics, 차량을 진단하고 리포팅하는 기능) 포트, 다른 한 쪽은 LAN포트에 끼울 수 있는 케이블. 

구매는 [이런 데서](https://smartstore.naver.com/hunintl/products/347575893?NaPm=ct%3Dkji2ldio%7Cci%3D0zG0003IAJ9toQWegf3b%7Ctr%3Dpla%7Chk%3D74321162026d5565684f60d6a7154f57fc12a4b0)하면 될 듯.

차량의 OBD2 포트는 운전석 하단에 있다고 함.
![image](https://user-images.githubusercontent.com/44834680/103501644-2e112780-4e92-11eb-8f77-656e8cdc4903.png)

### 3-2. 프로그램

F, G 시리즈의 코딩 프로그램으로 가장 많이 사용되는 것은 **E-SYS**

**E-SYS Launcher**

E-SYS를 사용하기 위해서는 토큰이라는 것이 필요.
일반적으로 통용되는 시리얼이나 정품 인증, 제품키 정도로 이해하면 됨.
따라서 일반 사용자가 E-SYS를 사용하기 위해서는 마치 토큰을 발급받은 것처럼 프로그램을 구동시켜주는 크랙 프로그램이 필요함.

가장 널리 사용되는 프로그램이 TokenMaster가 만든 E-SYS Launcher.
E-SYS Launcher 또한 무료와 유료 버전이 있는료는 Premium 버전이고, 유료는 Pro 버전입니다.

무료는 유료에 비해 코딩 차종을 쉽게 바꿀 수 없다던지, 프로그램 실행시 일정 시간 기다려야된다던지 등의 기능상 제약이 존재.
좀 더 적극적으로 여러 사용자를 대상으로 코딩을 하고 싶다면 TokenMaster에게 연락하여 유료를 구입할 수 있음. 보통 기부 단체에 기부하고 증명서를 제시하면 구입 가능하다고 함.

**psdzdata**
코딩 프로그램이 준비되었다면 차량코딩의 설계도라고 할 수 있는 psdzdata라는 프로그램을 설치해야 함.
Full-ver과 Lite-ver이 있는데, Full 버전은 차량의 전체 진단이나 업그레이드, 코딩 등을 할 때 필요한 전체 파일이 다 있는 버전.
Lite버전은 코딩할 때 필요한 파일만 모아놓은 버전이라고 생각하면 됨.

따라서 E-SYS 설치 -> E-SYS Launcher -> psdzdata순으로 설치

[다운로드 링크](https://drive.google.com/drive/folders/1rc0GajkPcj2AatCYIjtkydZnvh5oPbk6)

### 4. 자세한 코딩 방법
[참고](https://bimmermac.com/702)

#### References
[https://bimmermac.com/1974](https://bimmermac.com/1974)
