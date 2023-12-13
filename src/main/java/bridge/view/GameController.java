package bridge.view;

import bridge.Bridge;
import bridge.GameRecord;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private final GameRecord gameRecord;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridge = new Bridge();
        gameRecord = new GameRecord();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        while(!createBridge()) {
            System.out.println("다리 길이 입력중");
        }
        while(!crossBridge()){
            System.out.println("이동 칸 입력중");
        };
        System.out.println(bridge.getBridge());
    }

    public boolean createBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            bridge.addBridge(bridgeSize);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return false;
        }
    }

    public boolean crossBridge() {
        try {
            String moveCommand = inputView.readMoving();
            gameRecord.addMoveRecord(moveCommand);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동 할 칸을 다시 입력해주세요.(위: U, 아래: D)");
            return false;
        }
    }
}
