package problems.parkingLot.optimized.strategy;

import problems.parkingLot.optimized.model.Slot;

public interface SlotAllocationStrategy {
    int getNearestAvailableSlot();
}
