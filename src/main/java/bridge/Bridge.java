package bridge;

import java.sql.SQLOutput;
import java.util.List;

public class Bridge {
    private List<String> bridge;
    private final BridgeMaker bridgeMaker;

    public Bridge() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void addBridge(int size) {
        validateBridgeSize(size);
        bridge = bridgeMaker.makeBridge(size);
    }

    public void validateBridgeSize(int size) {
        if (size >= 3 && size <= 20) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isCross(GameRecord gameRecord) {
        int index = gameRecord.getMoveRecordLastIndex();
        String moveRecord = gameRecord.getLastMoveRecord();
        String currentBridgePosition = bridge.get(index);
        return currentBridgePosition.equals(moveRecord);
    }

    public boolean isArrive(GameRecord gameRecord) {
        int moveCommandSize = gameRecord.getMoveRecordSize();
        return moveCommandSize == bridge.size();
    }
}
