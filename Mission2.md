# Mission2. 사다리 게임 2단계 - 리팩토링 맛보기
## 미션 구현
- [x] Ladder 클래스의 메서드들이 depth가 1이 되도록 리팩터링
  - makeLadderLength() -> makeLadderVerticalLine() : 메서드 이름 변경(더 직관적)
  - makeLadderWidth() -> makeLadderHorizontalLine() : 메서드 이름 변경(더 직관적)
  - makeLadderVerticalLine()에 fillLadderVerticalLine() 추가 : 중첩된 for문을 다른 메서드로 분리해주기 위함
  - makeLadderHorizontalLine()에 fillLadderHorizontalLine() 추가 : 중첩된 for문을 다른 메서드로 분리해주기 위함

## 학습한 내용
### 이슈: rebase 시 .idea의 파일들이 push되지 않아서 rebase가 안됨
__상황__    
1. step1이 이미 머지 완료된 상태
2. .idea 폴더를 gitignore에 추가하였으나 remote의 '시오' 브랜치는 gitignore가 반영되지 않음
3. rebase 시도하면 다음과 같은 오류가 떴다.    

![gitrebase](https://user-images.githubusercontent.com/57451700/223365718-c77e148a-cda3-4674-8e29-d4398939d86e.png)    

__해결__    
1. .idea의 파일들을 커밋하고 싶지 않으므로 stash를 사용
2. 성공!

### 이슈: .gitignore 파일이 제대로 작동하지 않는 문제 발생
__상황__    
1. .gitignore에 .idea/ 을 추가했는데 changes에 계속 해당 파일들이 올라왔다.

__해결__    
1. git의 캐시 내용을 전부 삭제
2. 성공!
```shell
# 캐시 내용 전부 삭제
git rm -r --cached
# 전체 파일 add
git add .
# 커밋
git commit -m "{커밋메시지}"
```

### Enum 클래스에서 static 메서드 사용하는 것이 일반적인가
사다리를 그릴 때 "-"와 " "을 랜덤으로 불러올 때 Enum 클래스에서 직접 static으로 takeRandom() 메서드를 구현해서 사용했다.    
이런식으로 사용해도 되는지 팀원들과 그룹 리뷰 때 얘기를 나눴고 [[우아한형제들]Java Enum 활용기](https://techblog.woowahan.com/2527/)의 예제코드에서 사용하는 것을 보고 사용해도 되겠다는 확신을 얻었다.    

### git stash
내 로컬에서 작업 중인데 급하게 다른 버그를 처리해야 할 때 작업중인 내용을 __임시저장__하기 위한 용도로 stash가 필요하다.    
```shell
# git stash 변경 내용 임시저장하기
git stash
# 내가 stash 했던 내용 보기
git stash list
# 가장 최근 stash 가지고 오기
git stash apply
# 특정 stash 가지고오기
git stash apply stash@{1}
# 가장 최근 stash 지우기
git stash drop
# 특정 stash 지우기
git stash drop stash@{1}
# 한번에 stash 지우기
git stash clear
```
stash는 stack 방식으로 작동하고 있고, apply 해도 자동으로 지워지지 않는다.    
따라서 작업들을 stash apply해서 commit까지 완료했다면 stash list를 깨끗하게 삭제하는 것이 좋다.

### 이중 배열을 다룰 경우 이중 for문 말고 다른 좋은 방법은 없나
팀원들과 그룹리뷰 때 얘기를 나누었는데, 이중배열을 사용할 때는 중첩 for문을 사용할 수밖에 없는 것 같다.    
List를 사용한다면 for문을 중첩해서 사용하지 않아도 될 것 같다고 했는데 step2는 step1의 요구사항과 동일하므로 이중 for문을 사용해야 한다는 결론이 내려졌다.

### 리팩토링
겉으로 보이는 동작은 바꾸지 않을 채 내부 구조를 변경하는 것이다. 여기서의 핵심은 __동작은 동일__하다는 점이다.    
동작이 변경되면 그것은 리팩토링이라고 할 수 없다.

