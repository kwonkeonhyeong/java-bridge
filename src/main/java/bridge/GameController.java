package bridge;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.GameRecord;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.sql.SQLOutput;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private final GameRecord gameRecord;
    private final BridgeGame bridgeGame;
    private final MoveMap moveMap;
    private boolean isArrive;
    private boolean isCross;

    private boolean endGame = false;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridge = new Bridge();
        gameRecord = new GameRecord();
        bridgeGame = new BridgeGame(gameRecord);
        moveMap = new MoveMap();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        createBridge();
        boolean isSuccess;
        do {
            crossBridge();
            isSuccess = (isCross && isArrive);
        } while(!isSuccess && !endGame);
        outputView.printResultMessage();
        outputView.printMap(moveMap.getUpBridge());
        outputView.printMap(moveMap.getDownBridge());
        outputView.printResult(isSuccess, bridgeGame.getTryCount());
    }

    public void createBridge() {
        boolean isValid = true;

        while(isValid) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                bridge.addBridge(bridgeSize);
                isValid = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    public void crossBridge() {
        boolean isValid = true;

        while(isValid) {
            try {
                String moveCommand = inputView.readMoving();
                bridgeGame.move(moveCommand);
                isValid = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage("이동 할 칸을 다시 입력해주세요.(위: U, 아래: D)");
            }
        }

        isArrive = bridge.isArrive(gameRecord);
        isCross = bridge.isCross(gameRecord);

        moveMap.drawBridge(bridge, gameRecord);
        outputView.printMap(moveMap.getUpBridge());
        outputView.printMap(moveMap.getDownBridge());


        if (!bridge.isCross(gameRecord)) {
            inputRetry();
        };
    }

    public void inputRetry() {
        boolean isValid = true;

        while(isValid) {
            try {
                String retryCommand = inputView.readGameCommand();
                endGame = bridgeGame.retry(retryCommand, moveMap);
                isValid = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage("재시작 / 종료 여부를 다시 입력해주세요.(재시작: R, 종료: Q)");
            }
        }
    }
}
