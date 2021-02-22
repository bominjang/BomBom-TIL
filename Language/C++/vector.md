### Vector란?

C++ 표준 라이브러리에 있는 컨테이너로 사용자가 손쉽게 사용하기 위해 정의된 class.
Vector의 가장 큰 장점은 동적으로 원소를 추가할 수 있으며 크기가 자동으로 늘어난다는 점.
즉, 크기가 가변적인 배열.

vector는 heap에 생성되며 동적할당 됨.

front() : 첫 번째 원소
back() : 마지막 원소
begin() : 첫번째 위치
end() : 마지막의 다음 위치
size() : 원소의 개수
capacity() : 할당된 공간의 크기

### Vector 사용법

```
  #include<vector> //vector가 들어있는 헤더파일
  vector<int> v; //int type 벡터 생성
  vector<int> v = {1,2,3};
  vector<int> v[10]; // int타입 벡터 배열(크기 : 10) 생성
  vector<int> v[] = {{1,2},{3,4}};//int 벡터 배열 생성. (행은 가변, 열은 고정)
  vector<vector<int>> v; //2차원 벡터 생성(행과 열 모두 가변)
  vector<int> v(5); //5개의 원소를 0으로 초기화
  vector<int> v(5, 3); //5개의 원소를 3으로 초기화
  vector<int> v2(v); //vector v를 복사하여 벡터 v2생성
```

## Vector 값 추가
```
  v.push_back(10); //마지막 위치에 숫자 10 추가
  v.insert(2,10); //index 2의 위치에 숫자 10 추가
  v.insert(2,3,4); //2번째 위치에 4를 3개 추가
```
## Vector 값 삭제
```
  v.pop_back(); //마지막에 넣은 값 제거
  v.erase(vec.begin()+10); //index 10의 값 제거
  v.erase(vec.begin(), vec.begin()+5); //index 0~5 제거
```
