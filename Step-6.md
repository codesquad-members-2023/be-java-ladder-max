# Step-6: GUI 구현하기

---
# GUI 구현하면서 변경된 사항들
## InputView에서 InputStream을 교체할 수 있도록 변경
- InputView에 있는 메서드들을 재사용하기 위해 BufferedReader에 들어가는 INputStream을 교체할 수 있도록 변경
```java
public class InputView {

    private BufferedReader br;

    public InputView(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    public void changeInputStream(InputStream is) throws IOException {
        br.close();
        br = new BufferedReader(new InputStreamReader(is));
    }

    //...
}
```

## ResultGroup 생성 로직을 GameController에서 ResultGroup으로 이동
- GUI에서 ResultGroup 생성 로직을 재활용 하기 위해 ResultGroup 생성을 ResultGroup 스스로 하게 만든다.
- 기존에는 ResultGroup 생성 로직을 GameController에 private 메서드로 두었다
  - GameController에서 ResultGroup을 만들기 위한 재료(Ladder, PlayerGroup, DestinationGroup)을 생성하기 때문에 별 생각없이 Controller에 로지긍ㄹ 두게 되었다
- GUI를 만들다 보니 ResultGroup 생성 로직을 재사용해야 되는 상황이 생겼다
  - ResultGroup 생성 로직을 ResultGroup 스스로 하게 만들어 해결

