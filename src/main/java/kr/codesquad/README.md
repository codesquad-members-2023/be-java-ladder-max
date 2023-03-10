PR 코드 리뷰 과정
=

### 브랜치 생성 및 fork

1. 자신의 이름으로 브랜치 생성
2. 이후 브랜치를 자신의 repository로 fork

### 저장소 clone 및 브랜치 생성

3. clone
    ```java
    $ git clone https://github.com/{본인 id}/{project}
    ```
  
- 디렉토리로 이동
    ```java
    $ cd {project}
    ```

- 브랜치 생성
    ```java
    $ git switch -c {본인 id}
    ```

### 새로운 브랜치 생성 및 작업

4. 기능 구현을 위한 브랜치 생성
    ```java
    $ git switch -c {작업 브랜치 이름 ex) feature1, step1}
    ```

5. 기능 구현 후 add, commit

### remote origin 저장소에 올리기

6. push 명령으로 본인의 원격 저장소(origin)에 업로드
    ```java
    $ git push origin {작업 브랜치 이름}
    ```

### Pull Request 보내기

7. github 서비스에서 pull request를 보내기

### PR 리뷰 승인과 머지 후 작업 브랜치 제거

8. 리뷰어는 리모트(upstream) 저장소에서 PR 리뷰를 마무리하고 승인(approved)한다.
   - 승인되기 이전에 변경할 사항이 있으면 PR을 열어놓은 상태에서 작업 브랜치에 계속 커밋하고 푸시한다.
9. merge를 완료했다는 통보를 받으면 head 브랜치를 변경하고 작업 브랜치를 삭제한다.
    ```java
    $ git switch {아이디_브랜치_이름}
    $ git branch -D feature1
    ```

### 원본 저장소(upstream) 최초 등록

10. merge한 codesquad 저장소 : 브랜치를 동기화하기 위해 codesquad 저장소의 자기 브랜치 추가
- remove -v 명령으로 확인해보고 최초 한번만 upstream으로 등록한다.
  ```java
  $ git remote add -t {아이디_브랜치_이름} {저장소_별칭} base_저장소_url
  $ git remote -v
  ```

### upstream 저장소와 브랜치 정보 갱신

11. codesquad 저장소에서 자기 브랜치 정보 가져오기
    ```java
    $ git fetch upstream {아이디_브랜치_이름}
    ```
  
### 내 브랜치 동기화

12. codesquad 리모트(upstream) 저장소 브랜치와 동기화하기
    ```java
    $ git rebase upstream/{아이디_브랜치_이름}
    ```
13. remote 오리진(origin) 저장소 브랜치에 올리기
    ```java
    # git push origin {아이디_브랜치_이름}
    ```

### 반복작업 진행
14. 4단계부터 다시 진행한다. 또한 피드백 내용을 반영할 필요가 있을 경우 이를 반영하고 다시 PR을 준비한다.

---
### Mission 1

### Mission 2

### Mission 3
![image](https://user-images.githubusercontent.com/118447769/223296201-afd18586-782d-4577-b67e-3cfd37709845.png)  


![image](https://user-images.githubusercontent.com/118447769/224179845-b30583b4-d6cb-48d7-8ea3-3ad7302279d7.png)
