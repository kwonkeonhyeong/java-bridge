package bridge.view;

import bridge.Bridge;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridge = new Bridge();
    }

    public void run() {
        while(!createBridge()) {
            System.out.println("입력중");
        }
        System.out.println(bridge.getBridge());
    }

    public boolean createBridge() {
        try {
            System.out.println("다리 길이를 입력해주세요.");
            int bridgeSize = inputView.readBridgeSize();
            bridge.addBridge(bridgeSize);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3~20 사이의 숫자만 입력 가능 합니다.");
            return false;
        }
    }
}
