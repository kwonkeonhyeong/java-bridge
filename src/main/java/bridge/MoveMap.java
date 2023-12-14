package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveMap {
    private final List<String> upBridge;
    private final List<String> downBridge;

    public MoveMap() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public void drawBridge(Bridge bridge, GameRecord gameRecord) {
        drawNormalBridge(gameRecord);
        drawBrokenBridge(bridge, gameRecord);
    }

    public void drawNormalBridge(GameRecord gameRecord) {
        int moveRecordLastIndex = gameRecord.getMoveRecordLastIndex();

        if (gameRecord.isPosition(moveRecordLastIndex, "U")) {
            upBridge.add("O");
            downBridge.add(" ");
        }
        if (gameRecord.isPosition(moveRecordLastIndex, "D")) {
            upBridge.add(" ");
            downBridge.add("O");
        }

    }

    public void drawBrokenBridge(Bridge bridge, GameRecord gameRecord) {
        int moveRecordLastIndex = gameRecord.getMoveRecordLastIndex();

        if (!bridge.isCross(gameRecord) && gameRecord.isPosition(moveRecordLastIndex, "U")) {
            upBridge.remove(moveRecordLastIndex);
            upBridge.add("X");
        }
        if (!bridge.isCross(gameRecord) && gameRecord.isPosition(moveRecordLastIndex, "D")) {
            downBridge.remove(moveRecordLastIndex);
            downBridge.add("X");
        }

    }

    public void initMoveMap() {
        upBridge.clear();
        downBridge.clear();
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
