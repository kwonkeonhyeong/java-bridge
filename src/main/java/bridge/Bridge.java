package bridge;

import java.util.ArrayList;
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
}
