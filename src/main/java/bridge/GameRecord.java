package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {
    private List<String> moveRecord;

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
}
