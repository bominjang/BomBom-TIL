#### 프로그래머스 - [해시->전화번호 목록 문제](https://github.com/bominjang/Algorithm/blob/main/src/programmers/hash2.java) 풀이 & 회고

```
    import java.util.*;

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            boolean finish = false; //for 문을 멈추기위한 제어자.

            Arrays.sort(phone_book, (s1,s2)->s1.length()-s2.length()); //길이순으로 sorting.

            for(int i=0;i<phone_book.length;i++){
                if (finish){
                    break;
                } //for문 멈추기 위한 조건문
                
                String current = phone_book[i];//기준값
                int cur_len = current.length();//기준값의 길이
                for (int j=i+1; j<phone_book.length;j++){
                    String compare = phone_book[j];//비교 대상 값

                    if(current.equals(compare.substring(0,cur_len))){ //비교값을 기준값의 길이만큼 잘라서 비교
                        answer = false;
                        finish = true;
                        break;
                    }
                }
            }
            return answer;
        }
    }

```

위 코드는 사실.. 공간복잡도가 쓸데없이 많다고 생각.. 그리고 sorting할 때 시간복잡도가 커진다는 문제점이 있음.

아래 방법을 사용하면 훨씬 빠르게 사용할 수 있음.

```
    class Solution {
    public boolean solution(String[] phoneBook) {
       for (int i=0;i<phoneBook.length-1;i++){
            for(int j=i+1;j<phoneBook.length;j++){
                if(phoneBook[i].startsWith(phoneBook[j])){return false;}
                if(phoneBook[j].startsWith(phoneBook[i])){return false;}
            }
        }
     return true;
    }
}
```
startsWith라는 메소드를 알았다면 잘 풀 수 있었을 듯한 문제.....ㅠ0ㅠ
메소드 공부는 어떻게 해야하는걸까!!!!
