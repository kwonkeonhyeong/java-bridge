package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {
    private final List<String> moveRecord;

    public GameRecord() {
        moveRecord = new ArrayList<>();
    }

    public void addMoveRecord(String moveCommand) {
        validateMoveCommand(moveCommand);
        moveRecord.add(moveCommand);
    }

    public void validateMoveCommand(String moveCommand) {
        if (moveCommand.equals("U") || moveCommand.equals("D")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getLastMoveRecord() {
        return moveRecord.get(moveRecord.size() -1);
    }

    public int getMoveRecordSize() {
        return moveRecord.size();
    }

    public boolean isPosition(int index, String moveCommand) {
        String position = moveRecord.get(index);
        if (position.equals(moveCommand)) {
            return true;
        }
        return false;
    }

    public int getMoveRecordLastIndex() {
        return moveRecord.size() - 1;
    }

    public void initMoveRecord() {
        moveRecord.clear();
    }

    public List<String> getMoveRecord() {
        return moveRecord;
    }
}
