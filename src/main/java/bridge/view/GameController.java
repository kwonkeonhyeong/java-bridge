package bridge.view;

import bridge.Bridge;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge Bridge;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        Bridge = new Bridge();
    }

    public void run() {
        while(!inputBridgeSize()) {
            System.out.println("입력중");
        }
    }

    public boolean inputBridgeSize() {
        try {
            System.out.println("다리 길이를 입력해주세요.");
            int bridgeSize = inputView.readBridgeSize();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
            return false;
        }
    }
}
